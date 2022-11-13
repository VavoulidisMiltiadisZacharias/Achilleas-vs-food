import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener
{
	
	//Variables declaration
	final int PANEL_WIDTH = 500;	//Setting the bounds for the moving image
	final int PANEL_HEIGHT = 500;	//Setting the bounds for the moving image
	
	WinnerWindow myNewWindow ;
	MyFrame myFrame;
	
	Image Achilleas;
	Image Burger;
	Image Space;
	
	Timer Timer;
	
	int hx = 0 ;//Helping variable..checks whether Achilleas ate the burger or not
	int hy = 0;
	
	int xVelocity = 5;
	int yVelocity = 4;
	
	int x1Velocity = 2;
	int y1Velocity = 3;
	
	int xStart = 0;
	int yStart = 0;
	
	int x1Start = 280;
	int y1Start = 420;
	
	int[] xGreaterSimilarCoordinates = new int[12] ; //Holds the value of the next 3 and previous 3 coordinates of Achilleas at a certain moment
	int[] xSmallerSimilarCoordinates = new int[12] ;
	int[] x1GreaterSimilarCoordinates = new int[12] ;
	int[] x1SmallerSimilarCoordinates = new int[12] ;
	
	int[] yGreaterSimilarCoordinates = new int[12] ; //Holds the value of the next 4 and previous 4 coordinates of Achilleas at a certain moment
	int[] ySmallerSimilarCoordinates = new int[12] ;
	int[] y1GreaterSimilarCoordinates = new int[12] ;
	int[] y1SmallerSimilarCoordinates = new int[12] ;
	
	int xcounter = 1; 	//Helping variable for debugging reasons(counts the times they "touched" on x axis)
	int ycounter = 1;
	
	
	//Constructor
	MyPanel()
	{
		
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT)); //Since we are using pack() function
		this.setBackground(Color.black);
		
		Burger = new ImageIcon("D:\\Github local repositories\\Achilleas vs food\\Achilleas vs Food\\photos\\Burger.png").getImage();
		Achilleas = new ImageIcon("D:\\Github local repositories\\Achilleas vs food\\Achilleas vs Food\\photos\\Achilleas.png").getImage(); //Creates (gets) an image out of our imageIcon
		
		Space = new ImageIcon("D:\\Github local repositories\\Achilleas vs food\\Achilleas vs Food\\photos\\Space.jpg").getImage();  //Creates (gets) an image out of our imageIcon
		
		Timer = new Timer(12, this); 	//1st arg: Delay of how often this timer fires or does something (in milliseconds)
									//2nd arg: An ActionListener
		
		Timer.start(); //Will start our timer right when we instantiate this panel
	}

	//The paint() method is called behind the scenes when we instantiate our panel
	//because our JPanel is a subclass of a component Class
 	public void paint(Graphics g)
 	{
 		//Paints the background for us (the background belongs to the parent class, so we are using super())
 		super.paint(g);
 		
 		Graphics g2D = (Graphics2D) g ; //Casting our 1d graphic to 2d because there are more available options for 2D graphics
 		
 		g2D.drawImage(Space, 0, 0, null);
 		g2D.drawImage(Achilleas, xStart, yStart, null);
 		g2D.drawImage(Burger, x1Start, y1Start, null);
 	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
/*ACHILLEAS - START*/
		//If reach east or west bound, move towards the opposite direction
		if(xStart + Achilleas.getWidth(null) >= PANEL_WIDTH || xStart < 0)
		{
			xVelocity = xVelocity*(-1); 
		}
		xStart = xStart + xVelocity; //Updates the x coordinate of the Alien image (moves it on x axis)
	
		//If reach east or west bound, move towards the opposite direction
		if(yStart + Achilleas.getHeight(null) >= PANEL_HEIGHT || yStart < 0)
		{
			yVelocity = yVelocity*(-1); 
		}
		yStart = yStart + yVelocity; //Updates the y coordinate of the Alien image (moves it on y axis)	
/*ACHILLEAS - END*/	
		
		
/*FOOD - START*/		
		if(x1Start + Burger.getWidth(null) >= PANEL_WIDTH || x1Start < 0)
		{
			x1Velocity = x1Velocity*(-1); 
		}
		x1Start = x1Start + x1Velocity; //Updates the x coordinate of the Alien image (moves it on x axis)			
		
		//If reach east or west bound, move towards the opposite direction
		if(y1Start + Burger.getHeight(null) >= PANEL_HEIGHT || y1Start < 0)
		{
			y1Velocity = y1Velocity*(-1);
		}
		y1Start = y1Start + y1Velocity; //Updates the y coordinate of the Alien image (moves it on y axis)
		
/*FOOD - END*/
		
		
/*ACHILLEAS/FOOD - START*/
		
//-----------------------------TOUCH CHECK - START------------------------------//
		
		//Filling x array with next and previous coordinates	
		for(int i = 0 ; i < 12 ; i++)
		{
			xGreaterSimilarCoordinates[i] = xStart + Achilleas.getWidth(null) + i;	//Next i coordinates
			xSmallerSimilarCoordinates[i] = xStart + Achilleas.getWidth(null) - i;	//Previous i coordinates
			x1GreaterSimilarCoordinates[i] = x1Start + Burger.getWidth(null) + i;	//Next i coordinates
			x1SmallerSimilarCoordinates[i] = x1Start + Burger.getWidth(null) - i;	//Previous i coordinates
		}
		
		//Filling x array with next and previous coordinates
		for(int i = 0 ; i < 12 ; i++)
		{
			yGreaterSimilarCoordinates[i] = yStart + Achilleas.getHeight(null) + i;	//Next i coordinates
			ySmallerSimilarCoordinates[i] = yStart + Achilleas.getHeight(null) - i;	//Previous i coordinates
			y1GreaterSimilarCoordinates[i] = y1Start + Burger.getHeight(null) + i;	//Next i coordinates
			y1SmallerSimilarCoordinates[i] = y1Start + Burger.getHeight(null) - i;	//Previous i coordinates
		}
		
		//Check if they touch on x axis
		for(int i = 0 ; i < 12 ; i ++)
		{
			for(int j = 0 ; j < 12 ; j++)
			{
				if(xGreaterSimilarCoordinates[i] == x1GreaterSimilarCoordinates[j] || xGreaterSimilarCoordinates[i] == x1SmallerSimilarCoordinates[j])
				{
					//System.out.println("THEY TOUCHED ON X AXIS: " + xcounter);
					hx = 1;
				}
				
				 if(xSmallerSimilarCoordinates[i] == x1GreaterSimilarCoordinates[j] || xSmallerSimilarCoordinates[i] == x1SmallerSimilarCoordinates[j])
				{
					//System.out.println("THEY TOUCHED ON X AXIS: " + xcounter);
					hx = 1;
				}
			}
		}
		
		//Check if they touch on y axis
 		for(int i = 0 ; i < 12 ; i ++)
		{
			for(int j = 0 ; j < 12 ; j++)
			{
				if(yGreaterSimilarCoordinates[i] == y1GreaterSimilarCoordinates[j] || yGreaterSimilarCoordinates[i] == y1SmallerSimilarCoordinates[j])
				{
					//System.out.println("THEY TOUCHED ON Y AXIS: " + ycounter);
					hy = 1;
				}
				
				if(ySmallerSimilarCoordinates[i] == y1GreaterSimilarCoordinates[j] || ySmallerSimilarCoordinates[i] == y1SmallerSimilarCoordinates[j])
				{
					//System.out.println("THEY TOUCHED ON Y AXIS: " + ycounter);
					hy = 1;
				}
			}
		}
 		
 		//Achilleas caught the burger
		if(hy == 1 && hx ==1)
		{
			//System.out.println("ACHILLEAS ATE THE BURGER");
			
			//Sort of Ok but shows message as many times as the "hits" of the images (5) 
			JOptionPane.showMessageDialog(null, "Achilleas ate the burger", "We' ve got a burger king", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		//Updates (resets) hx and hy values to prepare them for the next check !!!
		hx = 0;
		hy = 0;
		
		
//------------------------TOUCH CHECK - END------------------------------------//
		
/*ACHILLEAS/FOOD - END*/
		
		repaint(); //Calls the paint() method for us and paints every component within our window
	}
}

