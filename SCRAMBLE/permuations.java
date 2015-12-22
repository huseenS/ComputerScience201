/**
 * 
 */
package SCRAMBLE;

//All Imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author Huseen Sufi
 * permutes string that a user inputs from the console
 */
public class permuations {
	/**
	 * @param args
	 * controller calls permute method and prints to console
	 */
	public static void main(String[] args) {
		System.out.println(permute("",getConsoleInput()));
	}
	/**
	 * 
	 * @param none
	 * @return string toPermute
	 * uses a Buffered Reader to read in console input
	 * 
	 */
	public static String getConsoleInput() {
		String toPermute = "";
		try(BufferedReader reader = new BufferedReader
				(new InputStreamReader(System.in, StandardCharsets.UTF_8))) { //try with resources auto close inputStream!
			System.out.println("Enter String to Permute: ");
			toPermute = reader.readLine().toLowerCase().trim(); //lower case and remove whitespace
			System.out.println("Will Now list all permutations of: " + toPermute);
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return toPermute;
	}
	/**
	 * @param firstLetter
	 * @param input
	 * @return outputText a stringBuilder object
	 * method to permute a string recursively
	 */
	public static StringBuilder permute(String firstLetter, String input) {
		String output = "";
		StringBuilder outputText = new StringBuilder(output);
		int length = input.length();
		if (length <= 0) {
			System.out.println(firstLetter); //base Case
		} else {
			for (int i = 0; i < length; i++) {
				String shorterWord = input.substring(0,i) + input.substring(i+1,length);
				/** Append the StringBuilder with the permuted Strings
				 * Call Permute Recursively. On each recursion the firstLetter index is moved up, 
				 * and the shorterWord or rest of the word gets shorter per recursive call
				 */
				outputText.append(permute(firstLetter + input.charAt(i),shorterWord));
			}
		}
		return outputText;
	}
}
