package ActualGame;

import java.awt.Image;
import java.awt.Toolkit;

public class Goodguy {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	private Image img;
	
	/**
	 * Goodguy will be the default constructor
	 */
	public Goodguy() {
		setxCoord (10);
		setyCoord (10);
		setWidth (75);
		setHeight (75);
		setImg ("../Files/Swamp.png");
	}
	
	/**
	 * Goodguy overloaded constructor
	 * @param x initial x location
	 * @param y initial y location
	 * @param w initial width
	 * @param h initial hight
	 */
	public Goodguy(int x, int y, int w, int h, String imgpath) {
		setxCoord (x);
		setyCoord (y);
		setWidth (w);
		setHeight (h);
		setImg (imgpath);
	}

	public void moveIt(int direction, int w, int h) {
		int speed = 15;
		int slow = 1;
		int x = getxCoord();
		int y = getyCoord();
		
		if (direction == 68) {
			x = x + speed;
			if (x > w) {x = x - speed * 3; } //this checks to see if the user has moved off the screen						
			setxCoord (x);
			setImg ("Files/SwampL.png");
		} else if (direction == 65) {
			x = x - speed;
			if (x<0) {x = x + speed * 3; } //this does the same thing but on the other side
			setxCoord (x);
			setImg ("Files/Swamp.png");
			
		}	
		else if (direction == 87) {
			y = y - 5;
			if (y < 0) {y = y + speed * 3;} //This checks to see if the user is still on screen
			setyCoord (y);
			
		} else if (direction == 83) {
			y = y + speed;
			if (y > h - 10) {y = y - speed * 3; } //checks to see if the user has moved off screen
			setyCoord (y);
		}
	}
	


	public void setImg (String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
		
}