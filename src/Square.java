import java.awt.Color;

// A Square IS A Rectangle -- it is drawn the exact same way
public class Square extends Rectangle {

	public Square(Color color, int x, int y, int width) {
		super(color, x, y, width, width);
	}

}
