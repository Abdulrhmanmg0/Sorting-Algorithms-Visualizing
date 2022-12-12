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


public class BubbleFrame extends JFrame{

	 BubblePanel BP = new BubblePanel();
	 JPanel BT;
	 
	 public BubbleFrame(){

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("Bubble Sort Algorithm");
	        setLocation(500,250);
	        setResizable(false);
	        
	        toolsPanel();
	        
	        add(BT,BorderLayout.SOUTH);
	        add(BP,BorderLayout.CENTER);
	        pack();
	        
	        setVisible(true);
	 }
	 
	 public void toolsPanel() {
		 

		 	BT = new JPanel();
		 
		 	BT.setPreferredSize(new Dimension(525,50));
		 	BT.setBackground(Color.BLACK);
		 	BT.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	        BT.setDoubleBuffered(true);
	        BT.setFocusable(true);
	        BT.setLayout(new FlowLayout(FlowLayout.CENTER));

	        
	        JButton Sort = new JButton("Sort");
	        
	        Sort.setBorderPainted(false);
	        Sort.setContentAreaFilled(true);
	        Sort.setFocusable(false);
	        Sort.setFont(new Font("Arial",Font.BOLD,20));
	        
	        Sort.addActionListener(new Bubble());
	        
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
	     
	        BT.add(Rand);
	        BT.add(Sort);
	        BT.add(Back);
	        
	    }
	 

		public class Bubble implements ActionListener{
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BP.BubbleSort();
				
			}
		}
		
		public class RAND implements ActionListener{
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BP.randomize();
				
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
