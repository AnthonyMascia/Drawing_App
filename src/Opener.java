import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// Controller
public class Opener implements ActionListener {
	
	// Create ArrayList to hold the phrases and dimensions of text file using the .split() method
	ArrayList <OrigOutput> oldPhrase = new ArrayList<OrigOutput>();
	/*
	 * Create ArrayList to properly store phrase and dimensions as one element.
	 * Makes sure the proper dimensions are associated with the correct phrase
	*/
	ArrayList<InputSaver> newPhrase = new ArrayList<InputSaver>();
	Frame app;
	public Opener(Frame app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// Pop up a file dialog
		FileDialog open = new FileDialog(app);
		open.setVisible(true);
		
		// Get the received file + dir and save it as a single string for convenience
		String path = open.getDirectory() + open.getFile();
		
		
		
		try{
			// Open the file that is the first command line parameter
			FileInputStream fstream = new FileInputStream(path);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			// Create variable to hold each phrase and dimensions
			String strLine;
			
			// Read File Line By Line and add to arraylist
			while ((strLine = br.readLine()) != null)   {
				oldPhrase.add(new OrigOutput(strLine));
			}
			// Close the input stream
			in.close();
		}catch (IOException ioe){// Catch exception if any
			  System.err.println("Error: " + ioe.getMessage());
		}
		

		/*
		 * For loop to iterate through every word of the .txt file to assign them to the
		 * InputSaver ArrayList
		 */
		for(int i = 0; i < oldPhrase.size(); i++){
			String[] pData = oldPhrase.get(i).p.split(" ");
			if(pData[0].equals("line")){
				newPhrase.add(new InputSaver(pData[0], pData[1], pData[2], pData[3], pData[4]));
			}
			// Since some shapes don't have a 4th element, it is replaced with an empty string
			else if(pData[0].equals("circle")){
				newPhrase.add(new InputSaver(pData[0], pData[1], pData[2], pData[3], ""));
			}
			else if(pData[0].equals("filledcircle")){
				newPhrase.add(new InputSaver(pData[0], pData[1], pData[2], pData[3], ""));
			}
			else if(pData[0].equals("rectangle")){
				newPhrase.add(new InputSaver(pData[0], pData[1], pData[2], pData[3], pData[4]));
			}
			else if(pData[0].equals("filledrectangle")){
				newPhrase.add(new InputSaver(pData[0], pData[1], pData[2], pData[3], pData[4]));
			}
			else if(pData[0].equals("square")){
				newPhrase.add(new InputSaver(pData[0], pData[1], pData[2], pData[3], ""));
			}
			else if(pData[0].equals("filledsquare")){
				newPhrase.add(new InputSaver(pData[0], pData[1], pData[2], pData[3], ""));
			}
			else if(pData[0].equals("color")){
				newPhrase.add(new InputSaver(pData[0], pData[1], pData[2], pData[3], ""));
			}
			// Catches invalid phrase in .txt
			else{
				System.out.println("Invalid Shape: " + pData[0]);
			}

			
		}// End for loop
		
		// Create new screen when file is opened so the screen knows what data to draw
		Painting s = new Painting(this);
		
		// Add the screen the main frame and repack
		Main.f.add(s);
		Main.f.pack();
		
		
		
	}// End actionPerformed
	
}// End Opener Class


