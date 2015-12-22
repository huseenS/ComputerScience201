/**
 * 
 */
package TSP;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Huseen Sufi
 *
 */
public class readinData {
	
	public int[][] readFile(File fileName) {
		int size = 0;
		int[][] numArray = null;
		try(Scanner myScanner = new Scanner(fileName)){//try with resources, auto close
			size = myScanner.nextInt();
			numArray = new int[size][size];
				for (int i = 0; i < numArray.length; i++) {
					for (int j = 0; j < numArray.length; j++) {
						numArray[i][j] = myScanner.nextInt();
					}
				}
				System.out.println("Array: " + Arrays.deepToString(numArray));
		} catch (IOException e ) {
			e.printStackTrace(); //e.g. fileNotFound
		} //end catch
		return numArray;
	}
	
}
