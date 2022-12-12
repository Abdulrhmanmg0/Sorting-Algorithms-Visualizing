package vsa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SelectionFrame extends JFrame {

	 SelectionPanel SP = new SelectionPanel();
	 JPanel ST;
	 
	 public SelectionFrame(){

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("Selection Sort Algorithm");
	        setLocation(500,250);
	        setResizable(false);
	        
	        toolsPanel();
	        
	        add(ST,BorderLayout.SOUTH);
	        add(SP,BorderLayout.CENTER);
	        pack();
	        
	        setVisible(true);
	 }
	 
	 public void toolsPanel() {
		 

		 	ST = new JPanel();
		 
		 	ST.setPreferredSize(new Dimension(525,50));
		 	ST.setBackground(Color.BLACK);
		 	ST.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	        ST.setDoubleBuffered(true);
	        ST.setFocusable(true);
	        ST.setLayout(new FlowLayout(FlowLayout.CENTER));

	        
	        JButton Sort = new JButton("Sort");
	        
	        Sort.setBorderPainted(false);
	        Sort.setContentAreaFilled(true);
	        Sort.setFocusable(false);
	        Sort.setFont(new Font("Arial",Font.BOLD,20));
	        
	        Sort.addActionListener(new Selection());

	        Sort.setPreferredSize(new Dimension(138, 34));
	        
	        
	        JButton Rand = new JButton("Randomize");
	        
	        Rand.setBorderPainted(false);
	        Rand.setContentAreaFilled(true);
	        Rand.setFocusable(false);
	        Rand.setFont(new Font("Arial",Font.BOLD,20));
	        
	        Rand.addActionListener(new RAND());
	        
	        JButton Back = new JButton("Back");
	        
	        Back.setBorderPainted(false);
	        Back.setContentAreaFilled(true);
	        Back.setFocusable(false);
	        Back.setFont(new Font("Arial",Font.BOLD,20));
	        
	        Back.addActionListener(new BACK());
	           
	        Back.setPreferredSize(new Dimension(138, 34));
	     
	        ST.add(Rand);
	        ST.add(Sort);
	        ST.add(Back);
	        
	    }
	 

		public class Selection implements ActionListener{
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SP.SelectionSort();
				
			}
		}
		
		public class RAND implements ActionListener{
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SP.randomize();
				
			}
		}
		public class BACK implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new MenuFrame();
				dispose();
				
			}
		}
	 
}
