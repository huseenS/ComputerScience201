/**
 * 
 */
package LINK;

//import java.util.Collections;
//import java.lang.NullPointerException;


/**
 * @author Huseen Sufi
 * This class instantiates two Node Objects, the first and last node
 * Includes Methods for adding a node, deleting a node, finding a node and listing all nodes
 */
public class LinkedList {

	private Node firstNode = new Node("lion",null,null); //root node
	private Node lastNode = firstNode; //in a one node list the head and tail are the same

	/**
	 * 
	 * @param toAdd
	 * @return name of added
	 * Instantiate a newNode, set its name value to the user's inputed text
	 * Set the Node's prev/next pointers so that newNode is at the head of the Linked List
	 * 
	 */
	public String addNode(String toAdd) {
		Node newNode = new Node(toAdd, lastNode, null); //the new node's previous is the last node, and it's next is null
		lastNode.setNext(newNode); //the last node's next is now new node
		lastNode = newNode; //the newNode is now the new lastNode
		return newNode.getName();
	}

	/**
	 * 
	 * @param toDelete
	 * @return deleted Name 
	 * This method keeps a reference to the first Node, and iterates through the Linked list
	 * While the current Node isn't null, and if the foundName method returns a name
	 * Then remove the Node at that location by moving around the previous and next links of the next/prev nodes
	 */
	public String deleteNode(String toDelete) {
			Node currentNode = firstNode;
			while(currentNode!= null) { //while the next Node exists
				if (currentNode.getName().equalsIgnoreCase(toDelete)) {
					
					if (currentNode.getPrev() != null) {
						currentNode.getPrev().setNext(currentNode.getNext()); //set the previous Node's next value, to current's Next
					}
					if (currentNode.getNext()!= null) {
						currentNode.getNext().setPrev(currentNode.getPrev()); //set the next Node's previous value to current's Prev
						return "Deleted " + currentNode.getName();
					} //end second iffg
				}
				currentNode = currentNode.getNext(); //increment
			} //end while
		return "Not Found ";
	}
	
	/**
	 * @param toFind
	 * @return Found
	 * This Method Sets a reference to the firstNode and iterates through the Linked list.
	 * While the currentNode isn't null, and if the currentNode's name value is equal to the param toFind
	 * then return the found node's name value
	 */
	public String findName(String toFind) {
		Node currentNode = firstNode;
		String Found = "Name Found " + toFind;
		while(currentNode!= null) {
			if (currentNode.getName().equalsIgnoreCase(toFind)) {
				System.out.println(Found); //console Log check
				return Found;
			} 
			currentNode = currentNode.getNext(); // increment
		}
		return "Name not Found ";
		
	}
	/**
	 * 
	 * @return the list of all Node's name values
	 * This instantiates a reference  to the firstNode, and iterates through the linked List
	 * while the currentNode isn't null append that Node's nameValue to a String
	 *  increment the list
	 *  return all name values
	 */
	public String listAll() {
		Node refNode = firstNode;
		String toPrint = "All Animals in Zoo: ";
		while (refNode != null) {
			toPrint += refNode.getName() + " ";
			refNode = refNode.getNext(); //increment by moving to nextNode
		}
		return toPrint;
	}
	
	/** 
	 * sorts list alphabetically using Collections.sort
	 * Implements the compareByName class overridden compareTo method
	 * @SuppressWarnings("unchecked")
	 * @param mylist
	 * @return alphabetized List
	public String alphabetize(LinkedList mylist) {
		Comparator<Node> compareNames = new compareByName();
		 Collections.sort(mylist,compareNames);
		 return mylist.listAll();
	}
	*/

}
