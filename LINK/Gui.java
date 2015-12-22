
package LINK;

//All imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;

//import java.util.Collections;
//import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;


/**
 * @author Huseen Sufi
 *This Class uses a Javax Swing Gui with one input form, one output form, and several Buttons.
 *The class instantiates the Linked List, buttons and forms. 
 *The user inputs the name of the node object they want to add,delete,or find in the input text area
 * and presses the corresponding buttons which include action listeners. User can also list all nodes currently in LinkedList
 * Output is then shown in the Output Text area.\
 */
public class Gui extends JFrame implements ActionListener {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 522050906897978371L;

	private LinkedList myList = new LinkedList(); //instantiate new linked List

	//initial Variables for Gui
	private JPanel textPanel;
	private JPanel containerPanel;
	private JScrollPane scrollPaneOutput;
	private JTextField inputText;
	private JTextArea outputText;
	private JLabel textLabel;
	private JPanel buttonPanel;
	private JButton addButton,deleteButton,findNameButton,listAllButton,alphabeticalOrder; //all buttons
	
	/**
	 * Gui Object includes a Text Panel, Button Panel and Container Panel
	 */
	public Gui() {
		setSize(800,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//container for all panels
		containerPanel = new JPanel();
		containerPanel.setLayout(new BorderLayout(25,25));
		
		//text panel containing inputText,OutputText areas
		textPanel = new JPanel();
		inputText = new JTextField("Input Animal Name Here");
		inputText.setBounds(15,15,15,15);
		inputText.addActionListener(this);
		outputText = new JTextArea("Output Will Appear Here");
		outputText.setWrapStyleWord(true);
		outputText.setLineWrap(true);
		scrollPaneOutput = new JScrollPane(outputText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneOutput.setPreferredSize(new Dimension(50, 50));
		textLabel = new JLabel("Input/Output Text!");
		textPanel.add(textLabel);
		textPanel.add(inputText);
		textPanel.setVisible(true);
		containerPanel.add(textPanel,BorderLayout.CENTER); //add text areas/scroll pane to frame
		containerPanel.add(scrollPaneOutput,BorderLayout.SOUTH);
		
		
		//button panel containing all buttons
		buttonPanel = new JPanel();
		addButton = new JButton("Add an Animal");
		addButton.addActionListener(this);
		deleteButton = new JButton("Delete an Animal");
		deleteButton.addActionListener(this);
		findNameButton = new JButton("Find Animal");
		findNameButton.addActionListener(this);
		listAllButton = new JButton("List All Animals");
		listAllButton.addActionListener(this);
		alphabeticalOrder = new JButton("List in Alphabetical Order");
		alphabeticalOrder.addActionListener(this);
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(findNameButton);
		buttonPanel.add(listAllButton);
		buttonPanel.add(alphabeticalOrder);
		containerPanel.add(buttonPanel, BorderLayout.NORTH); //add buttons to the container
		
		add(containerPanel); //add container to frame
		setVisible(true);
	}

	/* 
	 * @param ActionEvent
	 * Action Performed Method calls Linked List methods for each button pressed
	 */
	public void actionPerformed(ActionEvent e) throws NullPointerException {
		if(e.getSource() == addButton) {
			String toAdd = "Added an Item " + myList.addNode(inputText.getText().toLowerCase());
			System.out.println(toAdd + myList.listAll()); //console log check
			outputText.setText(toAdd + myList.listAll());
			
		} else if(e.getSource() == listAllButton) {
			String allAnimals = myList.listAll();
			System.out.println(allAnimals);
			outputText.setText(allAnimals);
		} else if (e.getSource() == deleteButton) {
			String deleted = "Deleted An Item " + myList.deleteNode(inputText.getText().toLowerCase());
			outputText.setText(deleted + "\n" + myList.listAll()); //console log check
			System.out.println("\nDeleted an Item " + myList.listAll()); 
		} else if (e.getSource() == findNameButton) {
			String nameFound = myList.findName(inputText.getText().toLowerCase().toLowerCase());
			outputText.setText(nameFound + "\n" + myList.listAll());
		} 
		
		/**  Code block to alphabetize the list
		 * else if (e.getSource() == alphabeticalOrder) {
			*String alphabetical = myList.alphabetize(myList);
			*outputText.setText("Sorted List " + alphabetical);
		*}
		*/
	}
}
