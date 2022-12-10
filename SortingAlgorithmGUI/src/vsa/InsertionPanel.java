package vsa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class InsertionPanel extends JPanel{

	Random rand = new Random();

    int WIDTH= 525;
    int HEIGHT = 300;
    
    int [] elements = new int [20];
    int [] posibilties = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    int elementsSize = 20;
    int Corrected = 0;
    int Pacing = 26;

    int pace = 1;
    
    boolean flag = true;
    
	public InsertionPanel(){
		
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        randomize();
    }
	
	public int rand(int n) {
		
		for(int i = 0 ; i < n; i++) {
			if(elements[n] ==  elements[i]) {
				elements[n] = posibilties[rand.nextInt(1, 24)];		
				return rand(n);
			}
		}
		return elements[n];
	}
	
	public void randomize() {
		
		for(int i = 0; i < elements.length; i++ ) { 
			elements[i] = posibilties[rand.nextInt(1, 24)] ;	
			rand(i);
		}
		repaint();
		pace = 1 ;
		Corrected = 0;
	}
	
	public void Shiffter(int first , int last) {
		
		int swap = elements[first];
		elements[first] = elements[last];
		elements[last] = swap;
		
		if(last > 0) {
			if(elements[last]<elements[last-1]) {
				Shiffter(last,last-1);
			}
		}
	}
	
	public void InsertionSort() {
	
		if(elements[pace]<elements[pace-1]) {
			
			Shiffter(pace,pace-1);
			
		}
		repaint();
		Corrected++;
		if(pace < 19) {
			pace++;
		}
		
	}
	
	public void paintComponent(Graphics g){
	        
	        super.paintComponent(g);
	        Graphics2D g2 =(Graphics2D)g;
	        int C = Corrected;
	        
	        for(int i = 0 ; i < elements.length; i++) {
	        	
	        	if(flag == true) {
	        		g2.setColor(Color.PINK);
	        		flag = false;
	        	}else {
	         		g2.setColor(Color.RED);
	        		flag = true;
	        	}
	        	
	        	if(C > 0 ) { 
	        		g2.setColor(Color.GREEN);
	        		C--;
	        	}
	        	
	        	g2.fillRect(  Pacing * i + 5 , HEIGHT - elements[i]*10-13 , elementsSize, elements[i]*10);
	        	g2.setColor(Color.BLUE);
	        	g2.setFont(new Font("Arial",Font.BOLD,10));
	        	g2.drawString(""+elements[i]*10, Pacing * i + 5, HEIGHT-3);
	        	
	        }
	        g2.dispose();
	}
	
}
