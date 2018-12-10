package ActualGame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
public class MyScreen extends JFrame {
	
/**
 * Myscreen basic window for the game, inherits properties and methods from JFrame
 * @author andrew.morse
 * @since Oct. 8, 2018
 */
	
	/**
	 * Myscreen default constructor
	 * @param none, default constructor
	 */
	public MyScreen() {
		// this is the current instance, setters are mutator methods which change properties
		this.setSize(855,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Super Pokemon");
		this.pack();
		this.setLocationRelativeTo(null);
		this.add(new MyCanvas(), BorderLayout.CENTER);
	}

	//main method is required to run the program
	public static void main(String[] args) {
		// instantiate an individual instance of Myscreen by calling on constructor
		JFrame frame = new JFrame();
		MyScreen screen = new MyScreen ();
		MyCanvas canvas = new MyCanvas ();
		frame.setSize(855,800);
		screen.getContentPane().add(canvas);
	}
}
