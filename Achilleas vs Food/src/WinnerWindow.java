import java.awt.*;
import javax.swing.*;

public class WinnerWindow extends JFrame
{	
	
	//Just creating a new frame to demonstrate the new window that i want to be appeared 
	JFrame myFrame = new JFrame();
	
	//Image declaration
	ImageIcon myImage ;
	
	//Create a label to add it to the new window (frame)
	JLabel myLabel  = new JLabel();
	
	//Constructor
	WinnerWindow()
	{
		myImage = new ImageIcon("D:\\Github local repositories\\Achilleas vs food\\Achilleas vs Food\\Photos\\Achilleas2.png");
		
		
		myLabel.setSize(570, 570);
		myLabel.setBackground(Color.black);
		myLabel.setIcon(myImage);	//Places the myImage on myLabel
		
		myLabel.setText("YEAHHH....I'M FAT GUY NOW ^_^ ");
		myLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
		myLabel.setHorizontalTextPosition(JLabel.CENTER);
		myLabel.setVerticalTextPosition(JLabel.TOP);
		myLabel.setIconTextGap(-45);
		myLabel.setForeground(Color.green);
		myLabel.setOpaque(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Achilleas the 'burger king'");
		this.setSize(570, 570);
		this.setBackground(Color.black);
		this.setLayout(null);
		this.add(myLabel);
		
		//this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		//Use the following  if i want to print Achilleas as the burger king and then print a message
		//JOptionPane.showMessageDialog(null, "Achilleas ate the burger", "We' ve got a burger king", JOptionPane.INFORMATION_MESSAGE);
		
	}
}