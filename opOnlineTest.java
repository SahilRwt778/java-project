/*Online Java Paper Test*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class opOnlineTest extends JFrame implements ActionListener
{
	JLabel l;
    JRadioButton  jb[]=new JRadioButton[5];
	JButton b1,b2,b3;
    ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	opOnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Previous");
		b3=new JButton("Result");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		add(b1);add(b2);add(b3);
		set();
		l.setBounds(30,40,450,20);
	    jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(270,240,100,30);
		b2.setBounds(100,240,100,30);
		b3.setBounds(460,40,100,30);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Previous");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Privious");
			setVisible(false);
			setVisible(true);
		}
		if(e.getSource()==b2)
		{
			if(check())
				count=count-1;
			current--;
			set();	
			b1.setEnabled(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			for(int i=0;i<=1;i++){
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que.1: int a=20,b=21,c; c=a&&b; what is the value of c ?");
			 jb[0].setText("20");jb[1].setText("21");jb[2].setText("1");jb[3].setText("0");
			
		}
		if(current==1)
		{
			l.setText("Que.2: int a=10,b; b=a>>3 what is the value of b");
			jb[0].setText("10");jb[1].setText("20");jb[2].setText("0");jb[3].setText("1");
		}
		if(current==2)
		{
			l.setText("Que.3: Java is developed by");
			jb[0].setText("Microsoft");jb[1].setText("Sun Microsystem of USA");jb[2].setText("Adobe");jb[3].setText("None");
		}
		if(current==3)
		{
			l.setText("Que.4: ..............is one of the java features that can handle multiple tasks");
			jb[0].setText("Object-Oriented");jb[1].setText("Dynamic & Extensible");jb[2].setText("Platform-Independent");jb[3].setText("Multithreaded");
		}
		if(current==4)
		{
			l.setText("Que.5: Java Interpreter translates............... into machine code");
			jb[0].setText("Bitcode");jb[1].setText("Bytecode(virtual Machine code)");jb[2].setText("Machine code");jb[3].setText("User code");
		}
		if(current==5)
		{
			l.setText("Que.6: ............... is use for naming classes,mathods,variables etc in a program");
			jb[0].setText("Operator");jb[1].setText("Separator");jb[2].setText("Identifier");jb[3].setText("Constructor");
		}
		if(current==6)
		{
			l.setText("Que.7: Which statement is used to terminate the loop early ? ");
			jb[0].setText("Terminate");jb[1].setText("Contnue");jb[2].setText("Skip");jb[3].setText("Break");
		}
		if(current==7)
		{
			l.setText("Que.8: Which of the following is the correct decaration statement in java program");
			jb[0].setText("int num=new int[5]");jb[1].setText("int num=new num[5]");jb[2].setText("int[]num=new int[5]");jb[3].setText("None");		
		}
		if(current==8)
		{
			l.setText("Que.9: Java");
			jb[0].setText("Only compiles");jb[1].setText("Only interprets");jb[2].setText("Compiles and then Interprets");jb[3].setText("Interprets and then Compile");
		}
		if(current==9)
		{
			l.setText("Que.10: What keyword is used in java to define a constant");
			jb[0].setText("static");jb[1].setText("final");jb[2].setText("abstract");jb[3].setText("private");
		}
		
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[0].isSelected());
		if(current==1)
			return(jb[3].isSelected());
		if(current==2)
			return(jb[1].isSelected());
		if(current==3)
			return(jb[3].isSelected());
		if(current==4)
			return(jb[1].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[3].isSelected());
		if(current==7)
			return(jb[2].isSelected());
		if(current==8)
			return(jb[2].isSelected());
		if(current==9)
			return(jb[1].isSelected());
		return true;
	}
	public static void main(String s[])
	{
		new opOnlineTest("Online Test Of Java");
	}


}
