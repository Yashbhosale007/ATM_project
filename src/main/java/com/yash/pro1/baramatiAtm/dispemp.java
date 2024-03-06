package com.yash.pro1.baramatiAtm;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class dispemp {
	
		public static void main(String[] args) {
			
			
			Configuration cfg = new Configuration().configure().addAnnotatedClass(empinfo.class).addAnnotatedClass(Acount.class);
    		
    		SessionFactory sessionfactory = cfg.buildSessionFactory();
    		
    		Session session = sessionfactory.openSession();
    		
    		
    		session.beginTransaction();
    		List ll = session.createQuery("from Acount").list();
    		Iterator i = ll.iterator();
    		
    		while(i.hasNext())
    		{
    				Acount obj = (Acount) i.next();
    				System.out.println(obj);
    		}
			
		}

}
