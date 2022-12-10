package vsa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuFrame extends JFrame{

	 private final int WINDOW_WIDTH = 525;
	 private final int WINDOW_HEIGHT = 400;
	 
	
	 
	 public MenuFrame(){

	        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("V.S.A.");
	        this.setLocation(500,250);
	        
	        JPanel p = new JPanel(new BorderLayout());
	        p.setBackground(Color.BLACK);
	        
	        JPanel Menu = new JPanel(new GridLayout(11,1));
	        Menu.setBackground(Color.BLACK);
	        
	        JLabel Label = new JLabel("Visualizing Sorting Algorithm");
	        Label.setFont(new Font("Arial",Font.BOLD,25));
	        Label.setForeground(Color.WHITE);
	        Label.setHorizontalAlignment(JLabel.CENTER);
	        
	        Menu.add(Label);
	        Menu.add(new JLabel(""));
	        
	        JButton BS = new JButton("Selection Sort");
	        BS.setFont(new Font("Arial",Font.BOLD,17));
	        BS.setFocusable(false);
	        BS.addActionListener(new Selection());
	        
	        JPanel PS = new JPanel();
	        PS.setBackground(Color.BLACK);
	        PS.add(BS);
	        Menu.add(PS);
	        
	        Menu.add(new JLabel(""));
	        JButton BI = new JButton("Insertion Sort");
	        BI.setFont(new Font("Arial",Font.BOLD,17));
	        BI.setFocusable(false);
	        BI.addActionListener(new Insertion());
	        
	        JPanel PI = new JPanel();
	        PI.setBackground(Color.BLACK);
	        PI.add(BI);
	        Menu.add(PI);
	        
	        Menu.add(new JLabel(""));
	        JButton BB = new JButton("Bubble Sort");
	        BB.setFont(new Font("Arial",Font.BOLD,17));
	        BB.setFocusable(false);
	        BB.addActionListener(new Bubble());
	        JPanel PB = new JPanel();
	        PB.setBackground(Color.BLACK);
	        PB.add(BB);
	        Menu.add(PB);
	        
	        Menu.add(new JLabel(""));
	        JButton BE = new JButton("Exit");
	        BE.setFont(new Font("Arial",Font.BOLD,17));
	        BE.setFocusable(false);
	        BE.addActionListener(new EXIT()); 
	        
	        JPanel PE = new JPanel();
	        PE.setBackground(Color.BLACK);
	        PE.add(BE);
	        Menu.add(PE);
	        
	        Menu.add(new JLabel(""));
	       
	        p.add(Menu,BorderLayout.CENTER);
	        p.add(new JLabel("            "),BorderLayout.EAST);
	        p.add(new JLabel("            "),BorderLayout.WEST);
	        
	        add(p);
	        
	        setVisible(true);
	 }
	 public class Selection implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			new SelectionFrame();
			dispose();
		}
	 }
	
	 public class Insertion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			new InsertionFrame();
			dispose();
		}
	 }
	 
	 public class Bubble implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			new BubbleFrame();
			dispose();
		}
	 }
	 
	 public class EXIT implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.exit(0);
		}
	 }
}
