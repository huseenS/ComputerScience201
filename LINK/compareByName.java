/**
 * 
 */
package LINK;

import java.util.Comparator;

/**
 * @author Huseen Sufi
 * 
 */
public class compareByName implements Comparator<Node>{

	/* 
	 * Overrides built in compare method of Comparator
	 * Compares the names lexicographically 
	 */
	@Override
	public int compare(Node node1, Node node2) {
	String name1 = node1.getName().toLowerCase();
	String name2 = node2.getName().toLowerCase();
		return name1.compareTo(name2);
	}

	
}
