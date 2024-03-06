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

class transfer extends JFrame implements ActionListener
{

	JButton b1,b2;
	JLabel ll,l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	
	transfer()
	{
		setSize(500,530);
		setLocation(500,150);
		setLayout(null);
		//JFrame.setBackground(Color.RED);
		
		ll = new JLabel("---- Transfer Amount ----");
		l1 = new JLabel("Account No Send - From : ");
		l2 = new JLabel("Account No Send - To : ");
		l3 = new JLabel("Enter Amount : ");
		l4 = new JLabel("Enter Pin : ");

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		b1 = new JButton("Submit");
		b2 = new JButton("Back");
		
		add(ll);
		add(l1);	add(t1);
		add(l2);	add(t2);
		add(l3);	add(t3);
		add(l4);	add(t4);
		add(b1);	add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		ll.setBounds(150,30,200,40);
		l1.setBounds(80,100,150,40);
		t1.setBounds(250,100,200,40);
		l2.setBounds(80,160,150,40);
		t2.setBounds(250,160,200,40);
		l3.setBounds(80,220,150,40);
		t3.setBounds(250,220,200,40);
		l4.setBounds(80,280,150,40);
		t4.setBounds(250,280,200,40);
		b1.setBounds(100,340,100,40);
		b2.setBounds(220,340,100,40);
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
			if(ae.getSource()==b1)
			{
					try {
						
							int bal=0,trans=0,flag1=0,flag2=0,flag3=0;
						
							Configuration cfg  = new Configuration().configure().addAnnotatedClass(Acount.class);
							
							SessionFactory sessionfactory = cfg.buildSessionFactory();
							
							Session session = sessionfactory.openSession();
							
							List ll = session.createQuery("from Acount").list();
							
							Iterator i = ll.iterator();
							
							session.beginTransaction();
							
							while(i.hasNext())
							{
									Acount obj = (Acount) i.next();
												
									if(obj.getAcount_no()==Integer.parseInt(t1.getText()) && obj.getAc_pin()==Integer.parseInt(t4.getText()))
									{
											
											bal = obj.getBalance();
											System.out.println(bal);
											trans  = Integer.parseInt(t3.getText());
											flag1=1;
											
											if((bal-trans)>500)
											{
													bal = bal - trans;
													obj.setBalance(bal);
													session.update(obj);
													System.out.println(bal);
													System.out.println("Amount  TransFer ");
													flag2=1;
												
													List l2 = session.createQuery("from Acount").list();
													Iterator i1 = ll.iterator();
													{
															while(i1.hasNext())
															{
																	Acount obj2 = (Acount) i1.next();
																	
																	if(obj2.getAcount_no()==Integer.parseInt(t2.getText()))
																	{
																														
																			trans = Integer.parseInt(t3.getText());
																			bal = obj2.getBalance();
																			System.out.println("bal1 = "+bal);
																			bal = bal + trans;
																			obj2.setBalance(bal);
																			session.update(obj2);
																			System.out.println("bal1 = "+bal);
																			flag3=1;
																			//break;		
																			
																	}
																	
															}
													}
																		
											}
																										
									}
								
							}
							if(flag1==0)
							{
									JOptionPane.showMessageDialog(null, "------ Sender Acount Not Exist ------");								
							}
							else if(flag2==0)
							{
									JOptionPane.showMessageDialog(null, "------ InSuficent Balance ------");
							}
							else if(flag3==0)
							{
									JOptionPane.showMessageDialog(null, "------ Reciver Acount Not Exist ------");								
							}
							else
							{
									JOptionPane.showMessageDialog(null, "------ Data TransFer sucessfully ------");
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

class transferBalance
{
	public static void main(String args[])
	{
		new transfer();
	}
}
