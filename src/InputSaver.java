/*
 *  ArrayList to store the read in contents from the .txt file so that every dimension is properly
 *  assigned to its correct phrase. Also makes painting and collision testing much easier
 */
public class InputSaver {
	
	String phrase, xCoord, yCoord, var1, var2;
	public InputSaver(String phrase, String xCoord, String yCoord, String var1, String var2) {
		this.phrase = phrase;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.var1 = var1;
		this.var2 = var2;
	}
	
	/*
	 *  Function that gets called when user clicks on a shape. "Removes" the element from the list
	 *  by making every piece of data in the element a blank string. Blank strings are not written
	 *  to the save file
	 */
	public void remove(){
		phrase = "";
		xCoord = "";
		yCoord = "";
		var1 = "";
		var2 = "";
	}
}
