package vsa;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class SelectionPanel  extends JPanel {


	Random rand = new Random();
	
	int pointing = 1;

    int WIDTH= 525;
    int HEIGHT = 300;
    
    int [] elements = new int [20];
    int [] posibilties = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    int elementsSize = 20;
    int Corrected = 0;
    int Pacing = 26;
    int pace = 0 ;
    int min = 0;
    
    boolean flag = true;
    
	public SelectionPanel(){
		
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
		min = 0 ;
		pace = 0 ;
		Corrected = 0;
		pointing = 1;
	}
	
	
	
	public void SelectionSort() {
	
		
		int swap;
		boolean flag = false;
		
		for(int i = pace; i < elements.length; i++) {
			
			if(elements[i] < elements[min]) {
				min = i ;
				flag = true;
			}
		}
		
		if(flag == true) {
			swap = elements[min];
			elements[min] = elements[pace];
			elements[pace] = swap;
			flag = false;
		}
		repaint();
		Corrected++;
		pointing++;
		if(pace < 19) {
			pace++;
			min = pace;
		}
	}
	
	public void paintComponent(Graphics g){
	        
	        super.paintComponent(g);
	        Graphics2D g2 =(Graphics2D)g;
	        int C = Corrected;
	        int P = pointing;
	        
	        for(int i = 0 ; i < elements.length; i++) {
	        	
	        	if(flag == true) {
	        		g2.setColor(Color.PINK);
	        		flag = false;
	        	}else {
	         		g2.setColor(Color.RED);
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
	        	g2.setColor(Color.BLUE);
	        	g2.setFont(new Font("Arial",Font.BOLD,10));
	        	g2.drawString(""+elements[i]*10, Pacing * i + 5, HEIGHT-3);
	        	
	        }
	        g2.dispose();
	}
	
}
