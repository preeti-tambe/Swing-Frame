package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.EmployeeDao;
import model.Employee;

public class MenuView {

	public MenuView()
	{
		JFrame f = new JFrame("Asterisc");
		int x=60;
		int xl=30;
		
		JLabel lb1=new JLabel("Name : ");
		lb1.setBounds(xl, 50, 100, 20);
		
		JTextField tx=new JTextField();
		tx.setBounds(x+xl, 50, 100, 20);
		
		JLabel lb2=new JLabel("Address : ");
		lb2.setBounds(xl, 100, 100, 20);
		
		JTextField tx1=new JTextField();
		tx1.setBounds(x+xl, 100, 100, 20);
		
		JButton btn=new JButton("SAVE");
		btn.setBounds(xl,160,100,50);
		
		JLabel lb3=new JLabel("Result : ");
		lb3.setBounds(xl, 100, 100, 20);
		
		
		btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				Employee e=new Employee(tx.getText(),tx1.getText());
				
				try {
					int a=new EmployeeDao().save(e);
					
					if(a>0)
					{
						lb3.setText("Data Inserted !");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		f.add(lb1);
		f.add(tx);
		
		f.add(lb2);
		f.add(tx1);
		f.add(btn);
		f.add(lb3);
		f.setSize(340, 300);
		f.setLayout(null);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	
	}
}
