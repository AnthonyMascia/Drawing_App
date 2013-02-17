import java.awt.Color;
import java.awt.Graphics;


public class Rectangle extends Shape {

	private int x, y, width, height;
	public Rectangle(Color color, int x, int y, int width, int height) {
		super(color);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void paintRectangle(Graphics g) {
		g.setColor(getColor());
		g.drawRect(x, y, width, height);
	}
}
