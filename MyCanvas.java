package ActualGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import sun.audio.*;

public class MyCanvas extends Canvas implements KeyListener {
	
	// global variables - accessible in all methods
	Goodguy swamp = new Goodguy (400,616,100,100,"files/swamp.png");
	LinkedList badguys = new LinkedList();
	Image map1 = Toolkit.getDefaultToolkit().getImage("Files/images.png");
	LinkedList balls = new LinkedList();
	//badBoss bigboi = new badBoss(400, 100, 100, 100, "Files/Badguy.png");
	Image lose = Toolkit.getDefaultToolkit().getImage("Files/Over.jpg");
	Boolean change = new Boolean (true);
	Boolean end = new Boolean(false); {
		if (end = true) {
			change = false;
		}
	}
	
	public MyCanvas() {
		//Boolean finish = new Boolean(false);
		this.setSize(855,800); // set same size as the screen
		this.addKeyListener(this); //add the listener to canvas
		playIt("Files/RPG.wav");
		
		Random rand = new Random();
		int winwidth = this.getWidth();
		int winheight = this.getHeight();
		for (int t = 0; t < 4; t++) {
			Badguy bg = new Badguy (rand.nextInt(winwidth), rand.nextInt(winheight),50,50, "Files/Badguy.png");
			Rectangle r = new Rectangle (100,100,30,30);
			if (r.contains(swamp.getxCoord(), swamp.getyCoord())) { //checks to see if badguy spawns on the same point as swampert
				badguys.remove(bg);
			} 
			if (bg.getyCoord() > 675) {
				bg.setyCoord(100);
			}
				
			
			badguys.add(bg);
		}
		
		TimerTask repeatedTask = new TimerTask() {

            public void run() {

                for(int i = 0; i < badguys.size(); i++) {// draw bad guys

                    Badguy bg = (Badguy) badguys.get(i);

                    //bg.setxCoord(bg.getxCoord() + 10);

                    bg.moveIt(swamp.getxCoord(), swamp.getyCoord());
                }
                
                for (int t = 0; t < 25; t++) {
                	if (t == 25) {
                		end = true;
                	}
                }
                repaint();
                
            }          
     };

        Timer timer = new Timer("Timer");

         

        long delay  = 1000L;

        long period = 1000L;

        timer.scheduleAtFixedRate(repeatedTask, delay, period);
        
       
	}
		

	@Override
	public void paint (Graphics g) {
	    g.drawImage (map1, 0, 0, this);
		g.drawImage (swamp.getImg(), swamp.getxCoord(), swamp.getyCoord(), swamp.getWidth(), swamp.getHeight(), this);		
		repaint();
		
		


			
		
		for(int i = 0; i < badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i);
			g.drawImage(bg.getImg(), (int) bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
			Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
			if (change = false) {
				g.drawImage(lose, 0,0, this);
			}
			
		for(int j = 0; j < balls.size(); j++) {
			Projectile k = (Projectile) balls.get(j);
			if (k.getxCoord() >this.getWidth()) { balls.remove(k); }
			k.setxCoord (k.getxCoord() + 1);
			g.drawImage(k.getImg(), (int) k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight(), this);
		
		Rectangle kr = new Rectangle (k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight());
		if (kr.intersects(r)) {
			badguys.remove(i);
			balls.remove(j);
			
		}
		
		
		repaint();		
		}
	}
}

	

	public Image getMap1() {
		return map1;
	}



	public void setMap1(Image map1) {
		this.map1 = map1;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(e);
		swamp.moveIt(e.getKeyCode(), this.getWidth(), this.getHeight());
		//System.out.println(swamp.getxCoord());
		
		
		for (int i = 0; i< badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i);
			Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
			if(r.contains(swamp.getxCoord(),swamp.getyCoord())) {
				System.out.println("Oh No");
				badguys.remove(i);
				}
		}

		
		//if I want to use q the code is 81
		if(e.getKeyCode() == 69) {
			Projectile ball = new Projectile(swamp.getxCoord() +50, swamp.getyCoord() +40, 20, 20,"Files/water.png");
			balls.add(ball);

		}
		
		

		Rectangle gg_r = new Rectangle(swamp.getxCoord(), swamp.getyCoord(),swamp.getWidth(), swamp.getHeight());

		Rectangle a = new Rectangle(0,724,855, 200);
		if (gg_r.intersects(a)) {
			swamp.setyCoord(swamp.getyCoord() -15);
		}
		Rectangle b = new Rectangle (0, 560, 300, 20);
		if (gg_r.intersects(b)) {
			swamp.setyCoord(swamp.getyCoord() -15);
		}
		Rectangle c = new Rectangle (535, 560, 300, 20);
		if (gg_r.intersects(c)) {
			swamp.setyCoord(swamp.getyCoord() -15);
		}
		Rectangle d = new Rectangle (210, 405, 300, 20);
		if (gg_r.intersects(d)) {
			swamp.setyCoord(swamp.getyCoord() -15);
		}
		

		for (int i = 0; i< badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i);
			Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
			if(r.intersects(gg_r)) {
				badguys.remove(i);
			
			}

		
		repaint();
	}		
}


	//@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
	
	public void playIt(String filename) {
		
		try {
			InputStream in = new FileInputStream(filename);
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
		} catch (IOException e) {
			System.out.println(e);
					
		}
	
	}
	
}