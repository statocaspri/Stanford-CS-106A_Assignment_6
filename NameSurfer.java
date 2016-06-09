/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*; 
import javax.swing.*; 

public class NameSurfer extends Program implements NameSurferConstants { 
	
	public static void main(String[] args) {
		new NameSurfer().start(args);
	}

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
		
		//set interactors
		name = new JLabel("Name");
		graphButton = new JButton ("Graph");
		clearButton = new JButton ("Clear");
		nameField = new JTextField (15);
		nameField.setActionCommand("name");
		
		//we have to create the GCanvas 
		graph = new NameSurferGraph(); 
		add(graph);
		
		//add Interactors to Canvas
		add(name, SOUTH);
		add(nameField, SOUTH);
		add(graphButton, SOUTH);
		add(clearButton, SOUTH);
		
		//call actionPerformed method
		addActionListeners();
		nameField.addActionListener(this); 
		
		//reads the file names-data.txt from source folder
		namesData = new NameSurferDataBase("names-data.txt");

	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

			if ( !(nameField.getText().equals("")) ) { 
				if (cmd.equals("name") || e.getSource() == graphButton) {
					if (namesData.findEntry(toUpperCase(nameField.getText())) != null) {
						graph.addEntry(namesData.findEntry(toUpperCase(nameField.getText())));
					}
					graph.update();
				}
			}
				if (e.getSource() == clearButton) {
				graph.clear();
				graph.update();
				}
	}
	
	/* Changes the first letter of a word to upper case */
	private String toUpperCase(String str){
		String result = "";
		char ch = str.charAt(0);
		char strUpperCase = Character.toUpperCase(ch);
		result = strUpperCase + str.substring(1);
		return result;
	}
	
	/* Private Instance Variables*/
	private JTextField nameField;
	private JButton graphButton;
	private JButton clearButton;
	private JLabel name;
	
	private NameSurferGraph graph;
	private NameSurferDataBase namesData; 
}
