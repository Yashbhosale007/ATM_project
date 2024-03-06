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

class withd extends JFrame implements ActionListener
{

	JButton b1,b2;
	JLabel ll,l1,l2,l3,l4;
	JTextField t1,t2,t3;
	
	withd()
	{
		setSize(500,530);
		setLocation(500,150);
		setLayout(null);
		//JFrame.setBackground(Color.RED);
		
		ll = new JLabel("---- Withdraw Amount ----");
		l1 = new JLabel("Enter Account No : ");
		l2 = new JLabel("Enter Amount : ");
		l3 = new JLabel("Enter Pin : ");

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		b1 = new JButton("Submit");
		b2 = new JButton("Back");
		
		add(ll);
		add(l1);	add(t1);
		add(l2);	add(t2);
		add(l3);	add(t3);
		add(b1);	add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		ll.setBounds(150,30,200,40);
		l1.setBounds(100,100,120,40);
		t1.setBounds(220,100,200,40);
		l2.setBounds(100,160,120,40);
		t2.setBounds(220,160,200,40);
		l3.setBounds(100,220,120,40);
		t3.setBounds(220,220,200,40);
		b1.setBounds(100,280,100,40);
		b2.setBounds(220,280,100,40);
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
			if(ae.getSource()==b1)
			{
				if(t1.getText()!=null && t2.getText()!=null && t3.getText()!=null)
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
									
									if(obj.getAcount_no()==Integer.parseInt(t1.getText()) && obj.getAc_pin()==Integer.parseInt(t3.getText()))
									{
											withd = Integer.parseInt(t2.getText());
											bal = obj.getBalance();
											
											
											//---------------- Checking Balance In DB ---------------
											if((bal-withd)<500)
											{
													JOptionPane.showMessageDialog(null, "------- InSuficent Balance ------");
													System.out.println("----- InSuficent Balance ------");									
													System.out.println("Yaur Balance = "+obj.getBalance());
											}
											else
											{
											// ---------------- WithDraw Amount ----------------
													bal = bal - withd;
													obj.setBalance(bal);
													session.update(obj);
													JOptionPane.showMessageDialog(null, "---- Amount WithDraw Sucessfully ----");
													System.out.println("Rem - Balance = "+bal);
													flag=1;
													break;
											}
											break;
							
									}
								
							}
							if(flag==0)
							{
									JOptionPane.showMessageDialog(null, "------ Wrong Info Entered ------");
									System.out.println("Wrong Info Entered");	
							}
							session.getTransaction().commit();
							session.close();
							sessionfactory.close();
							System.exit(0);
							
					}
					catch(Exception ea)
					{
							System.out.println(ea);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "------ Please Enter All Details ------");
				}
			}
			else if(ae.getSource()==b2)
			{
					new bankdemo();
			}
	}
	
}

class withdraw
{
	public static void main(String args[])
	{
		new withd();
	}
}
