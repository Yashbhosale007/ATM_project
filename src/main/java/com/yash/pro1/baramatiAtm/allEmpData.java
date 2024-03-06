package com.yash.pro1.baramatiAtm;


import javax.swing.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class demo extends JFrame {

	demo() {
		setTitle("demo Frame");
		setSize(500, 530);
		setLocation(500, 150);
		setLayout(new FlowLayout());
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Acount.class).addAnnotatedClass(empinfo.class);
		
		SessionFactory sessionfactory = cfg.buildSessionFactory();
		
		Session session = sessionfactory.openSession();
		
		
		empinfo eobj = new empinfo();
		
		List ll = session.createQuery("from Acount").list();
		ArrayList al = new ArrayList();
		al.add(ll);
		System.out.println(al);
		
		


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}

public class allEmpData {

	public static void main(String[] args) {

		new demo();

	}

}
