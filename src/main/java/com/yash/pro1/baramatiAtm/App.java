package com.yash.pro1.baramatiAtm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    		
    		Configuration cfg = new Configuration().configure().addAnnotatedClass(empinfo.class).addAnnotatedClass(Acount.class);
    		
    		SessionFactory sessionfactory = cfg.buildSessionFactory();
    		
    		Session session = sessionfactory.openSession();
    		
    		empinfo obj = new empinfo();
    		obj.setUser_id(1);
    		obj.setUserName("Yash");
    		obj.setUserEmail("Yash@");
    		obj.setUserPassword(123);
    		
    		Acount ac = new Acount();
    		ac.setAcount_id(1);
    		ac.setAcount_no(1111);
    		ac.setBalance(1000);
    		ac.setAc_pin(1234);
    		ac.setEmp_id(obj);
    		
    		session.beginTransaction();
    		
    		session.save(obj);
    		session.save(ac);
    		System.out.println("Data Inserted");
    		
    		session.getTransaction().commit();
    		session.close();
    		sessionfactory.close();
    		
        //new bankatm();
    }
}

