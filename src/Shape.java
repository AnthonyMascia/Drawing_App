import java.awt.Color;

// Shape is abstract because nothing is actually DECLARED a Shape
// Inherits the color from TheColor class so all of Shape's child classes inherit it as well
public abstract class Shape {
	
	private Color color;
	
	public Shape(Color color) {
		this.color = color;
	}
	
	// Gets color of the superclass to be used to set the color of the child classes
	// when drawing them
	public Color getColor(){
		return this.color;
	}

}
