package com.yash.pro1.baramatiAtm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;
import java.sql.*;

class SignUpTwo extends JFrame implements ActionListener 
{
    //1).Declaration

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    TextField t1,t2;
    JRadioButton rb1,rb2,rb3,rb4;
    ButtonGroup btn,btn1;
    JButton b1;
    JComboBox cmb1,cmb2,cmb3,cmb4,cmb5;
    long formno;
    Connection conn;
    Statement stm;
    PreparedStatement prstm;

    SignUpTwo()
    {
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		setSize(1000,900);
		setLocation(150,50);
		setLayout(null);
        getContentPane().setBackground(Color.WHITE); 

        //2)Memoery Allocation

        l1= new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Raleway",Font.BOLD,20));

        //Name
        l2= new JLabel("Religion :");
        l2.setFont(new Font("Raleway",Font.BOLD,15));
        cmb1=new JComboBox();
		cmb1.addItem("Hindu");
		cmb1.addItem("Sikh");
		cmb1.addItem("Christian");
        cmb1.addItem("Muslim");
        cmb1.setBackground(Color.WHITE);

        //Fname
        l3= new JLabel("Category :");
        l3.setFont(new Font("Raleway",Font.BOLD,15));
        cmb2=new JComboBox();
		cmb2.addItem("General");
		cmb2.addItem("OBC");
		cmb2.addItem("SC");
        cmb2.addItem("Other");
        cmb2.setBackground(Color.WHITE);

        //Date Of Birth
        l4= new JLabel("Income :");
        l4.setFont(new Font("Raleway",Font.BOLD,15));
        cmb3=new JComboBox();
		cmb3.addItem("NULL");
		cmb3.addItem("<1,50,000");
		cmb3.addItem("<2,50,000");
        cmb3.addItem("<5,00,000");
        cmb3.addItem("<10,00,000");
        cmb3.setBackground(Color.WHITE);

        //email      
        l5= new JLabel("Qualification :");
        l5.setFont(new Font("Raleway",Font.BOLD,15));
        cmb4=new JComboBox();
		cmb4.addItem("Non-Graduation");
		cmb4.addItem("Graduate");
		cmb4.addItem("Post-Graduation");
        cmb4.addItem("Doctrate");
        cmb4.addItem("Other");
        cmb4.setBackground(Color.WHITE);

        //address
        l6= new JLabel("Occupation :");
        l6.setFont(new Font("Raleway",Font.BOLD,15));
        cmb5=new JComboBox();
		cmb5.addItem("Salaried");
		cmb5.addItem("Self_Employed");
		cmb5.addItem("Bussiness");
        cmb5.addItem("Student");
        cmb5.addItem("Other");
        cmb5.setBackground(Color.WHITE);

        
        //city
        l7= new JLabel("PAN Number :");
        l7.setFont(new Font("Raleway",Font.BOLD,15));
        t1=new TextField();
        t1.setFont(new Font("Raleway",Font.BOLD,12));
        
        //state
        l8= new JLabel("Aadhar Number :");
        l8.setFont(new Font("Raleway",Font.BOLD,15));
        t2=new TextField();
        t2.setFont(new Font("Raleway",Font.BOLD,12));
        
        //pin
        l9= new JLabel("Senior Citizen :");
        l9.setFont(new Font("Raleway",Font.BOLD,15));
        rb1=new JRadioButton("Yes");
        rb1.setBackground(Color.WHITE);
        rb2= new JRadioButton("No");
        rb2.setBackground(Color.WHITE);
        
        //gender
        l10= new JLabel("Existing Account :");
        l10.setFont(new Font("Raleway",Font.BOLD,15));
        rb3=new JRadioButton("Yes");
        rb3.setBackground(Color.WHITE);
        rb4= new JRadioButton("No");
        rb4.setBackground(Color.WHITE);

        
        btn=new ButtonGroup();
        btn.add(rb1);
        btn.add(rb2);
        btn1=new ButtonGroup();
        btn1.add(rb3);
        btn1.add(rb4);

        b1= new JButton("Next");
        b1.setFont(new Font("Raleway",Font.BOLD,15));

        //3)Add to Frame 
        add(l1);
        add(l2);     add(cmb1);
        add(l3);     add(cmb2);
        add(l4);     add(cmb3);
        add(l5);     add(cmb4);
        add(l6);     add(cmb5);
        add(l7);     add(t1);
        add(l8);     add(t2);
        add(l9);    add(rb1);  add(rb2);
        add(l10);     add(rb3);  add(rb4);
        add(b1);
        //4) setBounds(x,y,width,height)

        l1.setBounds(150,10,600,40);
        l2.setBounds(100,90,100,30);    cmb1.setBounds(230,90,300,30);
        l3.setBounds(100,140,100,30);   cmb2.setBounds(230,140,300,30);
        l4.setBounds(100,190,150,30);   cmb3.setBounds(230,190,300,30);    
        l5.setBounds(100,240,150,30);   cmb4.setBounds(230,240,300,30);         
        l6.setBounds(100,290,150,30);   cmb5.setBounds(230,290,300,30);      
        l7.setBounds(100,340,120,30);   t1.setBounds(230,340,300,30);      
        l8.setBounds(100,390,130,30);   t2.setBounds(230,390,300,30);      
        l9.setBounds(100,440,150,30);   rb1.setBounds(250,440,80,30) ;  rb2.setBounds(350,440,80,30);     
        l10.setBounds(100,490,150,30);  rb3.setBounds(250,490,80,30) ;  rb4.setBounds(350,490,80,30);     
        b1.setBounds(250,540,280,30);    
              
                        
        // 5) Add Listeners if required
        b1.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {   
        
        String Religion=(String) cmb1.getSelectedItem();
        String Category=(String) cmb2.getSelectedItem();
        String Income=(String) cmb3.getSelectedItem();
        String Qualification=(String) cmb4.getSelectedItem();
        String Occupation=(String) cmb5.getSelectedItem();
        //String PIN_No=t1.getText();	int Aadhar_No=t2.getText();
        String SeniorCitizen=null;
        if(rb1.isSelected())
        {
            SeniorCitizen="Yes";
        }else if(rb2.isSelected())
        {
            SeniorCitizen="No";
        }
        String Existing_Account=null;
        if(rb3.isSelected())
        {
            Existing_Account="Yes";
        }else if(rb4.isSelected())
        {
            Existing_Account="No";
        }

        try{
            if(Religion.equals("")) {
                JOptionPane.showMessageDialog(null,"Sorry,Name Is Required");
            }else{
                
                try{
            
                	Configuration cfg=new Configuration();
                	cfg.configure("hibernate.cfg.xml");
                	SessionFactory factory = cfg.buildSessionFactory();
                	Session session = factory.openSession();
                	Transaction tx = session.beginTransaction();
                	
                	SignUp2 obj = new SignUp2();
                	
                	obj.setFormno(formno);
                	obj.setReligion(Religion);
                	obj.setCategory(Category);
                	obj.setIncome(Income);
                	obj.setQualification(Qualification);
                	obj.setOccupation(Occupation);
                	obj.setPIN_No(Integer.parseInt(t1.getText()));
                	obj.setAadhar_No(Integer.parseInt(t2.getText()));
                	obj.setSeniorCitizen(SeniorCitizen);
                	obj.setExisting_Account(Existing_Account);
                	
                	session.save(obj);
                	tx.commit();
                	
                	JOptionPane.showMessageDialog(null,"insert data Sucessfully");
                	
                	
                  setVisible(false);
                  new SignUpThree(formno).setVisible(true);
                    
                }
                catch(Exception eee)
                {
                     System.out.println(eee);
                } 
                   
            }
        }
        catch(Exception ee)
        {
            System.out.println(ee);
        }  
    }
}

public class deno {
	
	public static void main(String[] args) {
		
		new SignUpTwo(100);
	}

}

