import java.awt.Color;
import java.awt.Graphics;

//Line IS A Shape -- inherits its properties
public class Line extends Shape{

	int x, y, x1, y1;
	public Line(Color c, int x, int y, int x1, int y1) {
		super(c);
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
	}

	public void paintLine(Graphics g){
		g.setColor(getColor());
		g.drawLine(x, y, x1, y1);
	}
	
}
