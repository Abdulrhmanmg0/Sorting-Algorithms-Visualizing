package vsa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InsertionFrame extends JFrame{

	 InsertionPanel IP = new InsertionPanel();
	 JPanel IT;
	 
	 public InsertionFrame(){

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("Selection Sort Algorithm");
	        this.setLocation(500,250);
	        
	        toolsPanel();
	        
	        add(IT,BorderLayout.SOUTH);
	        add(IP,BorderLayout.CENTER);
	        pack();
	        
	        setVisible(true);
	 }
	 
	 public void toolsPanel() {
		 

		 	IT = new JPanel();
		 
		 	IT.setPreferredSize(new Dimension(525,50));
		 	IT.setBackground(Color.BLACK);
		 	IT.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	        IT.setDoubleBuffered(true);
	        IT.setFocusable(true);
	        IT.setLayout(new FlowLayout(FlowLayout.LEFT));

	        
	        JButton Sort = new JButton("Sort");
	        
	        Sort.setBorderPainted(false);
	        Sort.setContentAreaFilled(true);
	        Sort.setFocusable(false);
	        Sort.setFont(new Font("Arial",Font.BOLD,20));
	        
	        Sort.addActionListener(new Selection());
	        
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
	        
	        IT.add(Rand);
	        IT.add(Sort);
	        IT.add(Back);
	        
	    }
	 

		public class Selection implements ActionListener{
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				IP.InsertionSort();
				
			}
		}
		
		public class RAND implements ActionListener{
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				IP.randomize();
				
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
