/**
 * 
 */
package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * @author Huseen Sufi
 * This class lets the user pick a text file via a JFileChooser, then asks for a String input via the console.
 *  If that String is not found in the file it appends it to the end of the file. 
 */
public class fileReader {
	static File myFile;
	
	/**
	 * @param args, @return none
	 * Main method is the Controller. It instantiates the JFileChooser and calls the readFile Method
	 */
	public static void main(String[] args) {
		JFileChooser chooseFile = new JFileChooser();
		int result = chooseFile.showOpenDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION) { //check if choose a file
			myFile = chooseFile.getSelectedFile();
		}
		//
		readFile(myFile);
	}
	
	/**
	 * 
	 * @param myFile
	 * @return String nameToSearch
	 * Uses a Buffered Reader to read in consoleInput 
	 */
	public static String getConsoleInput(File myFile) {
		String nameToSearch = "";
		try(BufferedReader readConsole = new BufferedReader
				(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
			System.out.println("\nWhich name would you like to search in File?");
			nameToSearch = readConsole.readLine(); //assign return value to line user enters in console
			System.out.println("\nYou searched for " + nameToSearch); //check if input is grabbed correctly
		} catch (IOException e) {
			System.err.println(e);
		} //end catch
		return nameToSearch; 
	} //end getConsoleInput
	
	
	/**
	 * @param fileName
	 * @return none
	 * Void Method that reads the file via  scanner, calls the getConsoleInput method, and checks if that string is in the file
	 * Splits the file into an array of names, and checks the userInput against that array of names
	 */
	public static void readFile(File fileName) {
		String input = getConsoleInput(myFile);
		String[] nameArray = null; //instantiate null ArrayPointer
		try(Scanner scr = new Scanner(new FileReader(fileName))) {
			
			while (scr.hasNext()) { //while the file has more lines
				String line = scr.next(); //read the next name
				System.out.println(line);
				 nameArray = line.split(" "); //split names into an array
			}//end while
			
			//codeBlock to Check user input against txt file
			int count = nameArray.length -1;
			int i = 0;
				 while (count != 0) {
					 i++;
					 if (nameArray[i].equals(input)) { //ignore case
							System.out.println("Name " + input + " is already found in file");
							System.out.println(nameArray[i]);
							count--;
						} if (!nameArray[i].equals(input)) {
							writeToFile(myFile, input); //if userInput is not in the found, then call writeToFile						}
							count--;
						} //end second if
				} //endWhile
			
		} catch (IOException e) { //FileNotFound
			System.err.println(e);
		} catch (NullPointerException e) {
			System.err.println(e);
		} //end catch
	} //end readFile

/**
 * 
 * @param fileName
 * @param Name
 * Method that uses a Buffered writer to append the userInput to the file
 */
	public static void writeToFile(File fileName, String Name) {
		try (BufferedWriter writeText = new BufferedWriter
				(new OutputStreamWriter(new FileOutputStream(fileName, true)))) {
			writeText.write(" " + Name + "\n");
		} catch (IOException e ) { //FileNotFound
			System.err.println(e); 
		} //end catch
	
	} // end writeToFile
	
} //end Class
