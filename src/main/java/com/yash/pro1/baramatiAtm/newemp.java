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

class addnew extends JFrame implements ActionListener {
	JLabel l0, l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2, b3, b4;

	addnew() {
		setSize(500, 500);
		setLocation(600, 100);
		setLayout(null);

		l0 = new JLabel("*** Enter Data ***");
		l1 = new JLabel("Enter User Id  : ");
		l2 = new JLabel("Enter Full-Name : ");
		l3 = new JLabel("Enter Email : ");
		l4 = new JLabel("Enter Password : ");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();

		b1 = new JButton("Back");
		b2 = new JButton("Submit");
		b3 = new JButton("Exit");

		add(l0);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
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
		b1.setBounds(100, 360, 100, 30);
		b2.setBounds(210, 360, 100, 30);
		b3.setBounds(320, 360, 100, 30);

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
					cfg.configure().addAnnotatedClass(empinfo.class);
					SessionFactory sessionfactory = cfg.buildSessionFactory();
					Session session = sessionfactory.openSession();
	
					empinfo eobj = new empinfo();
					eobj.setUser_id(Integer.parseInt(t1.getText()));
					eobj.setUserName(t2.getText());
					eobj.setUserEmail(t3.getText());
					eobj.setUserPassword(Integer.parseInt(t4.getText()));
	
					List ll = session.createQuery("from empinfo").list();
					Iterator i = ll.iterator();
	
					session.beginTransaction();
	
					while (i.hasNext()) 
					{
							empinfo obj1 = (empinfo) i.next();
							if (obj1.getUser_id() == Integer.parseInt(t1.getText())) 
							{
									flag = 1;
									break;
							}
	
					}
					if (flag == 1) {
						JOptionPane.showMessageDialog(null, "---- Employee Exist Already ----");
						System.out.println(" Employee Exist Already ");
	
					} else {
						session.save(eobj);
						JOptionPane.showMessageDialog(null,
								" ----- Data Inserted ---- ");
						System.out.println("Student Not Found");
					}
					
					session.getTransaction().commit();
					session.close();
					sessionfactory.close();
					//new addacount(); 
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

class newemp {
	public static void main(String args[]) {
		new addnew();
	}
}
