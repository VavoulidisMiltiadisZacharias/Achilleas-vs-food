import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame
{
	//Variables declaration
	MyPanel myPanel;
	
	//Constructor
	MyFrame()
	{
		//Instantiate myPanel object
		myPanel = new MyPanel();
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Will Achilleas catch the burger ?");
		this.add(myPanel);
		this.pack();
		this.setLocationRelativeTo(null);	//Allows the frame to appear in the middle of our screen
		this.setVisible(true);
		
	}
}
