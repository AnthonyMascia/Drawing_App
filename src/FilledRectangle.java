import java.awt.Color;
import java.awt.Graphics;

// A FilledRectangle IS A Shape -- inherits its properties
public class FilledRectangle extends Shape {

	private int x, y, width, height;
	public FilledRectangle(Color color, int x, int y, int width, int height) {
		super(color);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void paintRectangle(Graphics g) {
		g.setColor(getColor());
		g.fillRect(x, y, width, height);
	}
}
