import java.awt.Color;
import java.awt.Graphics;

//FilledSquare IS A FilledRectangle -- it is drawn the exact same way
public class FilledSquare extends FilledRectangle{

	public FilledSquare(Color c, int x, int y, int width) {
		super(c, x, y, width, width);
	}
	
}
