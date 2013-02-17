import java.awt.Color;
import java.awt.Graphics;

//Circle IS A Shape -- inherits its properties
public class FilledCircle extends Shape{

	
	private int x, y, radius;
	public FilledCircle(Color color, int x, int y, int radius) {
		super(color);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public void paintCircle(Graphics g) {
		g.setColor(getColor());
		g.fillOval(x, y, radius*2, radius*2);
	}

}
