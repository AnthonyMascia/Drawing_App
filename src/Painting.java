import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


// View -- will draw the ArrayList of shapes on to a canvas
public class Painting extends Canvas implements MouseListener{
	// Takes in an Opener -- because Opener has the ArrayList of phrases to draw stored in it
	Opener opener;
	public Painting(Opener opener){
		setSize(800, 600);
		this.opener = opener;
		addMouseListener(this);
	}
	
	public void paint(Graphics g){
	TheColor TC = new TheColor(Color.black); // Set initial color of TheColor class to a default black
		for(InputSaver s : opener.newPhrase){
			// If statements to draw proper shapes on to canvas
			if(s.phrase.equals("line")){
				int x = Integer.parseInt(s.xCoord);
				int y = Integer.parseInt(s.yCoord);
				int x1 = Integer.parseInt(s.var1);
				int y1 = Integer.parseInt(s.var2);
				Line li = new Line(TC.color, x, y, x1, y1);
				li.paintLine(getGraphics());
			}
			else if(s.phrase.equals("circle")){
				int x = Integer.parseInt(s.xCoord);
				int y = Integer.parseInt(s.yCoord);
				int r = Integer.parseInt(s.var1);
				Circle circ = new Circle(TC.color, x, y, r);
				circ.paintCircle(getGraphics());
			}
			else if(s.phrase.equals("filledcircle")){
				int x = Integer.parseInt(s.xCoord);
				int y = Integer.parseInt(s.yCoord);
				int r = Integer.parseInt(s.var1);
				FilledCircle fcirc = new FilledCircle(TC.color, x, y, r);
				fcirc.paintCircle(getGraphics());
			}
			else if(s.phrase.equals("rectangle")){
				int x = Integer.parseInt(s.xCoord);
				int y = Integer.parseInt(s.yCoord);
				int w = Integer.parseInt(s.var1);
				int h = Integer.parseInt(s.var2);
				Rectangle r = new Rectangle(TC.color, x, y, w, h);
				r.paintRectangle(getGraphics());
			}
			else if(s.phrase.equals("filledrectangle")){
				int x = Integer.parseInt(s.xCoord);
				int y = Integer.parseInt(s.yCoord);
				int w = Integer.parseInt(s.var1);
				int h = Integer.parseInt(s.var2);
				FilledRectangle fr = new FilledRectangle(TC.color, x, y, w, h);
				fr.paintRectangle(getGraphics());
			}
			else if(s.phrase.equals("square")){
				int x = Integer.parseInt(s.xCoord);
				int y = Integer.parseInt(s.yCoord);
				int wh = Integer.parseInt(s.var1);
				Square sq = new Square(TC.color, x, y, wh);
				sq.paintRectangle(getGraphics());
			}
			else if(s.phrase.equals("filledsquare")){
				int x = Integer.parseInt(s.xCoord);
				int y = Integer.parseInt(s.yCoord);
				int wh = Integer.parseInt(s.var1);
				FilledSquare fsq = new FilledSquare(TC.color, x, y, wh);
				fsq.paintRectangle(getGraphics());
			}
			//Sets new color of the super class for all other shapes to inherit
			else if(s.phrase.equals("color")){
				int r = Integer.parseInt(s.xCoord);
				int gr = Integer.parseInt(s.yCoord);
				int b = Integer.parseInt(s.var1);
				Color newColor = new Color(r, gr, b);
				TC.color = newColor;
			}
	
				
		}// End for loop
		  
		
	
	}// End paint class

	
	// MouseListener
	@Override
	public void mouseClicked(MouseEvent arg0) {;}

	@Override
	public void mouseEntered(MouseEvent arg0) {;}

	@Override
	public void mouseExited(MouseEvent arg0) {;}

	@Override
	public void mousePressed(MouseEvent me) {
		//Assign variables to get location of mouse click
		int mouseX = me.getX();
		int mouseY = me.getY();
		
		//For loop ran every time user clicks mouse to determine if mouse click is on a shape
		/*
		 * Canvas is redrawn if one of these if statements is true because if true,
		 * the shape that was clicked on is removed from the ArrayList.
		 * It is removed because when user goes to save the new drawing, the deleted shapes will
		 * not appear in the .txt file
		 */
		for(InputSaver s : opener.newPhrase){
			if(s.phrase.equals("rectangle") || s.phrase.equals("filledrectangle")){
				int x = Integer.parseInt(s.xCoord);
				int y = Integer.parseInt(s.yCoord);
				int w = Integer.parseInt(s.var1);
				int h = Integer.parseInt(s.var2);
					if((mouseX >= x && mouseX <= (w + x)) &&
					   (mouseY >= y && mouseY <= (h + y))){
						s.remove();
						repaint();
					}
			}
			else if(s.phrase.equals("square") || s.phrase.equals("filledsquare")){
				int x = Integer.parseInt(s.xCoord);
				int y = Integer.parseInt(s.yCoord);
				int wh = Integer.parseInt(s.var1);
					if((mouseX >= x && mouseX <= (wh + x)) &&
					   (mouseY >= y && mouseY <= (wh + y))){
						s.remove();
						repaint();
					}
			}
			else if(s.phrase.equals("circle") || s.phrase.equals("filledcircle")){
				int x = Integer.parseInt(s.xCoord);
				int y = Integer.parseInt(s.yCoord);
				int r = Integer.parseInt(s.var1);
					if((mouseX >= Math.abs(x) && mouseX <= Math.abs(r*2 + x)) &&
					   (mouseY >= Math.abs(y) && mouseY <= Math.abs(r*2 + y))){
						s.remove();
						repaint();
					}
			}
			else if(s.phrase.equals("line")){
				int x = Integer.parseInt(s.xCoord);
				int y = Integer.parseInt(s.yCoord);
				int x1 = Integer.parseInt(s.var1);
				int y1 = Integer.parseInt(s.var2);
					if((mouseX >= x && (mouseX <= (x / x1))) &&
					   (mouseY >= y && (mouseY <= (y / y1)))){
						s.remove();
						repaint();
					}
			}
			// Do nothing and continue loop if the loop reaches a color. Color will not be modified
			else if(s.phrase.equals("color")){
				continue;
			}
			
			
		}// End for loop
		
	}// End MousePressed

	@Override
	public void mouseReleased(MouseEvent arg0) {;}

}// End Class Painting
