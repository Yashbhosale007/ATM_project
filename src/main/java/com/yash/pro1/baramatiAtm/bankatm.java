package com.yash.pro1.baramatiAtm;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class bankdemo extends JFrame implements ActionListener {
	
	JLabel l1;
	JButton b1, b2, b3, b4;

	bankdemo() {
		setSize(500, 550);
		setLocation(500, 150);
		setLayout(null);

		l1 = new JLabel("State Bank OF India");
		b1 = new JButton("----- Withdraw -----");
		b2 = new JButton("----- View Balance -----");
		b3 = new JButton("----- Transfer Amount -----");
		b4 = new JButton("----- Reset Pin -----");
		
		l1.setFont(new Font("Lucida Handwriting", Font.PLAIN, 30));
		b1.setFont(new Font("Arial",Font.BOLD,20));
		b2.setFont(new Font("Arial",Font.BOLD,20));
		b3.setFont(new Font("Arial",Font.BOLD,20));
		b4.setFont(new Font("Arial",Font.BOLD,20));
		
//		b1.setForeground(Color.GRAY);
//		b2.setForeground(Color.GRAY);
//		b3.setForeground(Color.GRAY);
//		b4.setForeground(Color.GRAY);

		add(l1);
		add(b1);
		add(b2);
		add(b3);
		add(b4);


		l1.setBounds(70,50,400,50);
		b1.setBounds(100, 130, 300, 50);
		b2.setBounds(100, 200, 300, 50);
		b3.setBounds(100, 270, 300, 50);
		b4.setBounds(100, 340, 300, 50);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == b1) {

					new withd();

			} else if (e.getSource() == b2) {

					new viewbal();

			} else if (e.getSource() == b3) {
				
					new transfer();
				
			} else if (e.getSource() == b4) {
				
					new reset();
			}
		} catch (Exception ex) {

		}
	}
}
public class bankatm{
	public static void main(String args[])
	{
			new bankdemo();
	}
}

