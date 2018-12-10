package ActualGame;

import java.awt.Image;
import java.awt.Toolkit;

public class Badguy {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	private Image img;
	
	/**
	 * Badguy will be the default constructor
	 */
	public Badguy() {
		setxCoord (10);
		setyCoord (10);
		setWidth (30);
		setHeight (30);
		setImg ("../Files/ball.jpg");
	}
	
	/**
	 * Secondgoodguy overloaded constructor
	 * @param x initial x location
	 * @param y initial y location
	 * @param w initial width
	 * @param h initial hight
	 */
	public Badguy(int x, int y, int w, int h, String imgpath) {
		setxCoord (x);
		setyCoord (y);
		setWidth (w);
		setHeight (h);
		setImg (imgpath);
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

	public void moveIt(int gx, int gy) { 
		int x = getxCoord();
		int y = getyCoord();
		int speed = 3;
		
		if (x > gx ) {
			x = x + speed;
			setxCoord(x);
		}
		
		if (x < gx) {
			x= x - speed;
			setxCoord(x);
		}

		if (y < gy) {
			y = y - speed;
			setyCoord(y);
		}

		if (y > gy) {
			y= y + speed;
			setyCoord(y);
		}


	}

	
		
	}