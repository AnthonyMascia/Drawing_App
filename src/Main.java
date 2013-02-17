
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;


public class Main{

	// Declare frame as static variable so it can be accessed by the Opener class
	static Frame f = new Frame("Open a text file to see drawing");
	
	public static void main(String[] args) {
		
		
		
		
		// Show application
		f.setSize(800,600);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
		// MenuBar can be seen as the MODEL
		MenuBar bar = new MenuBar(); //create new menu bar
		f.setMenuBar(bar); //add the menu bar to the frame
		Menu fileMenu = new Menu("File"); //create the first menu item: file
		MenuItem open = new MenuItem("Open"); //this is the flydown window that can be added to any menu item
		MenuItem save = new MenuItem("Save -- (save as a .txt)");
		
		// Add opener controller
		Opener o = new Opener(f);
		open.addActionListener(o);
		
		// Add saving controller
		save.addActionListener(new Saver(f, o));
		
		fileMenu.add(open); //add 'open' to 'file'
		fileMenu.add(save); // add 'save' to 'file'
		bar.add(fileMenu);
		
		// Add a Closer to exit program
		f.addWindowListener(new Closer());
		
		
	}
	


}

