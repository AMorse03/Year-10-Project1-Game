package ActualGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Titlescreen extends JPanel implements ActionListener {

	private String name = "Click Start to Begin" ;
	private Container c;
	private JFrame menuscreen;
	private JButton startbutton;
	public Titlescreen() {
		menuscreen = new JFrame ("Super Pokemon Menu Screen");
		startbutton = new JButton ("Start");
		startbutton.setPreferredSize(new Dimension (100,100));
		startbutton.setBounds(100, 100, 100, 100);
		startbutton.addActionListener(this);
		menuscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = menuscreen.getContentPane();
		this.setLayout(null);
		this.add(startbutton);
		c.add(this);
		this.setPreferredSize(new Dimension (300,400));
		menuscreen.pack();
		menuscreen.setVisible(true);
		
		
		
	}
	@Override
	public void paintComponent (Graphics g) {
		g.setFont(new Font (name, 20,20));
		g.setColor(Color.red);
		g.drawString(name, 10, 50);
	}
	public static void main (String[] args) {
		new Titlescreen();		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {		
		Object button = arg0.getSource();
		if (button == arg0.getSource()) {
			new MyScreen();
			this.menuscreen.dispose();
		}
	}
	
	
}

