/**
 * 
 */
package TSP;

import java.io.File;
import java.util.Date;

import javax.swing.JFileChooser;
/**
 * @author Huseen Sufi
 *
 */
public class contoller {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File myFile = null;
		JFileChooser chooseFile = new JFileChooser();
		int result = chooseFile.showOpenDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION) { //check if choose a file
			myFile = chooseFile.getSelectedFile();
		} //end if
		
		//read matrix from file
		readinData reader = new readinData(); 
		int[][] matrix = reader.readFile(myFile);
		
		//calculate shortest route
		findShortestRoute myTSP = new findShortestRoute();
		long startTime = new Date().getTime();
		myTSP.solve(matrix);
		long endTime = new Date().getTime();
		long totalTime = endTime - startTime;
		System.out.println("Time: " + totalTime + " milliseconds"); //simple timer
		
	}

}
