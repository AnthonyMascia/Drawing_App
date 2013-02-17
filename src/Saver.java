import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

// Class that writes remaining elements in the InputSaver ArrayList to a .txt file
// This 'saves' the changes the user has made to the original painting after deleting shapes
public class Saver extends JPanel implements ActionListener {

	Frame app;
	Opener op;
	public Saver(Frame app, Opener o) {
		this.app = app;
		op = o;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// Pop up a file dialog
		FileDialog open = new FileDialog(app);
		open.setVisible(true);
		
		// Assign directory and file to single variable for convenience
		String path = open.getDirectory() + open.getFile();
				
		try{
			  // Create file 
			  FileWriter fstream = new FileWriter(path);
			  BufferedWriter out = new BufferedWriter(fstream);
			  // Write out every element left in the ArrayList to the .txt file
			  for(InputSaver p : op.newPhrase){
				  // If statement to make sure removed strings do not get written to file
				  if(!p.phrase.equals("")){
					  out.write(p.phrase + " " + p.xCoord + " " + p.yCoord +
							  	" " + p.var1 + " " + p.var2);
					  out.newLine();
				  }
			  }
			  //Close the output stream
			  out.close();
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
			  
			
		
	}// End actionPerformed
	

} //End Saver Class

	


