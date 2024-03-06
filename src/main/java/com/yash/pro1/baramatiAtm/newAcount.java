package com.yash.pro1.baramatiAtm;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


class addacount extends JFrame implements ActionListener {
	JLabel l0, l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2, b3, b4;

	addacount() {
		setSize(500,550);
		setLocation(600, 100);
		setLayout(null);

		l0 = new JLabel("*** Enter Data ***");
		l1 = new JLabel("Enter Acount-Id  : ");
		l2 = new JLabel("Enter Acount no : ");
		l3 = new JLabel("Enter Genetare-pin : ");
		l4 = new JLabel("Enter Amount : ");
		l5 = new JLabel("Enter Emp_ID : ");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();

		b1 = new JButton("Back");
		b2 = new JButton("Submit");
		b3 = new JButton("Exit");

		add(l0);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(b1);
		add(b2);
		add(b3);

		l0.setBounds(180, 50, 100, 50);
		l1.setBounds(100, 110, 100, 30);
		t1.setBounds(210, 110, 150, 30);
		l2.setBounds(100, 170, 100, 30);
		t2.setBounds(210, 170, 150, 30);
		l3.setBounds(100, 230, 100, 30);
		t3.setBounds(210, 230, 150, 30);
		l4.setBounds(100, 290, 100, 30);
		t4.setBounds(210, 290, 150, 30);
		l5.setBounds(100, 350, 100, 30);
		t5.setBounds(210, 350, 150, 30);
		b1.setBounds(100, 400, 100, 30);
		b2.setBounds(210, 400, 100, 30);
		b3.setBounds(320, 400, 100, 30);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ee) {
		try {

			if (ee.getSource() == b1) 
			{
					new bankdemo();
			} 
			
			else if (ee.getSource() == b2)
			{

					int flag = 0;
					Configuration cfg = new Configuration();
					cfg.configure().addAnnotatedClass(empinfo.class).addAnnotatedClass(Acount.class);
					SessionFactory sessionfactory = cfg.buildSessionFactory();
					Session session = sessionfactory.openSession();
	
					empinfo eobj = new empinfo();
					eobj.setUser_id(Integer.parseInt(t5.getText()));
					
					Acount aobj = new Acount();
					aobj.setAcount_id(Integer.parseInt(t1.getText()));
					aobj.setAcount_no(Integer.parseInt(t2.getText()));
					aobj.setAc_pin(Integer.parseInt(t3.getText()));
					aobj.setBalance(Integer.parseInt(t4.getText()));
					aobj.setEmp_id(eobj);
	
					List ll = session.createQuery("from Acount").list();
					Iterator i = ll.iterator();
	
					session.beginTransaction();
	
					while (i.hasNext()) 
					{
							Acount obj1 = (Acount) i.next();
							
							if (obj1.getAcount_id() == Integer.parseInt(t1.getText())) 
							{
//									List l2 = session.createQuery("from empinfo").list();
//									Iterator i2 = l2.iterator();
//									while(i2.hasNext())
//									{
//										empinfo obj2 = (empinfo) i2.next();
//										if(obj2.getUser_id()==Integer.parseInt(t5.getText()))
//										{
//												JOptionPane.showMessageDialog(null, "---- Employee Exist Already ----");
//												flag = 1;
//												break;										
//										}
//										
//									}
									flag = 1;
									break;	

							}
	
					}
					if (flag == 1) {
						JOptionPane.showMessageDialog(null, "---- Acount Exist Already ----");
						System.out.println(" Acount Exist Already ");
	
					} else {
						
						session.save(aobj);
						JOptionPane.showMessageDialog(null,
								" ----- Data Inserted ---- ");
						//System.out.println("Student Not Found");
					}
					
					
					session.getTransaction().commit();
					session.close();
					sessionfactory.close();
					System.exit(0);

			} 
			else if (ee.getSource() == b3)
			{
					System.exit(0);
			}

		} catch (Exception e) {

		}
	}
}

class newAcount {
	public static void main(String args[]) {
		new addacount();
	}
}

