package vsa;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class BubblePanel extends JPanel{

	Random rand = new Random();
	
	int pointing = 1;
	int Corrected = 0;
    
	int WIDTH= 525;
    int HEIGHT = 300;
    
    int [] elements = new int [20];
    int [] posibilties = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    int elementsSize = 20;
    
    int Pacing = 26;

    
    
    boolean flag = true;
    
	public BubblePanel(){
		
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
		Corrected = 0;
		pointing = 1;
	}
	
	
	
	public void BubbleSort() {
	
		for(int i = 1; i < elements.length; i++ ) {
			
			if(elements[i] < elements[i-1]) {
				
				int swap = elements[i];
				elements[i] = elements[i-1];
				elements[i-1] = swap;
				
			}
		}
		Corrected++;
		pointing++;
		repaint();
	}
	
	public void paintComponent(Graphics g){
	        
	        super.paintComponent(g);
	        Graphics2D g2 =(Graphics2D)g;
	        int C = Corrected;
	        int P = pointing;
	        
	        for(int i = elements.length-1 ; i >= 0; i--) {
	        	
	        	if(flag == true) {
	        		g2.setColor(Color.decode("#59bfff"));
	        		flag = false;
	        	}else {
	         		g2.setColor(Color.decode("#26abff"));
	        		flag = true;
	        	}
	        	
	        	if(P > 0 ) { 
	        		g2.setColor(Color.BLUE);
	        		P--;
	        	}
	        	
	        	if(C > 0 ) { 
	        		g2.setColor(Color.GREEN);
	        		C--;
	        	}
	        	
	        	g2.fillRect(  Pacing * i + 5 , HEIGHT - elements[i]*10-13 , elementsSize, elements[i]*10);
	        	g2.setColor(Color.WHITE);
	        	g2.setFont(new Font("Arial",Font.BOLD,10));
	        	g2.drawString(""+elements[i]*10, Pacing * i + 5, HEIGHT-3);
	        	
	        }
	        g2.dispose();
	}
	
}
