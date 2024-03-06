package com.yash.pro1.baramatiAtm;

import java.awt.*;
import java.awt.event.*;
import java.io.ObjectInputFilter.Config;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class viewbal extends JFrame implements ActionListener
{

	JButton b1,b2;
	JLabel ll,l1,l2,l3,l4;
	JTextField t1,t2,t3;
	
	viewbal()
	{
		setSize(500,530);
		setLocation(500,150);
		setLayout(null);
		//JFrame.setBackground(Color.RED);
		
		ll = new JLabel("---- View Balance ----");
		l1 = new JLabel("Enter Account No : ");
		l2 = new JLabel("Enter Pin : ");

		t1 = new JTextField();
		t2 = new JTextField();
		b1 = new JButton("Submit");
		b2 = new JButton("Back");
		
		add(ll);
		add(l1);	add(t1);
		add(l2);	add(t2);
		add(b1);	add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		ll.setBounds(150,30,200,40);
		l1.setBounds(100,100,120,40);
		t1.setBounds(220,100,200,40);
		l2.setBounds(100,180,120,40);
		t2.setBounds(220,180,200,40);
		b1.setBounds(130,260,100,40);
		b2.setBounds(280,260,100,40);
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
			if(ae.getSource()==b1)
			{
					try {
						
							int bal=0,withd=0,flag=0;
						
							Configuration cfg  = new Configuration().configure().addAnnotatedClass(Acount.class);
							
							SessionFactory sessionfactory = cfg.buildSessionFactory();
							
							Session session = sessionfactory.openSession();
							
							List ll = session.createQuery("from Acount").list();
							
							Iterator i = ll.iterator();
							
							session.beginTransaction();
							
							while(i.hasNext())
							{
									
									Acount obj = (Acount) i.next();
									if(obj.getAcount_no()==Integer.parseInt(t1.getText()) && obj.getAc_pin()==Integer.parseInt(t2.getText()))
									{
											JOptionPane.showMessageDialog(null,
													"--------- Employee Info --------"+
													"\n\t Acount - id  = "+obj.getAcount_id()+
													"\n\t Acount - Number  = "+obj.getAcount_no()+
													"\n\t Name = "+obj.getEmp_id().getUserName()+
													"\n\t Balance = "+obj.getBalance()
											);
											flag=1;
											break;
									}
									
							}
							if(flag==0)
							{
									JOptionPane.showMessageDialog(null," *** Employee Not Exist ***");
							}
							session.getTransaction().commit();
							session.close();
							sessionfactory.close();
							
					}
					catch(Exception ea)
					{
							System.out.println(ea);
					}
			}
			else if(ae.getSource()==b2)
			{
				new bankdemo();
			}
	}
	
}

class viewbalance
{
	public static void main(String args[])
	{
		new viewbal();
	}
}

