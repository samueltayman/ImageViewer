/**
//***********************************************************************
'Project:            Assignment 03
'Programmer:     Samuel Tayman
'Company Info:  nicholstayman@live.com  
'Date:                24 09 2016
'Description:      Assignment 3 Chapter 13 Problem 2
'    
'
'**********************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


/*
 * The ImageViewer class creates a GUI element to display
 * an image selected by the user
 */
@SuppressWarnings("serial")
public class ImageViewer extends JFrame
{

	//Holds Label of image
	private JPanel imagePanel;
	
	//Holds button 
	private JPanel buttonPanel;
	
	//Displays image
	private JLabel imageLabel;
	
	//Retrieves image
	private JButton button;
	
	/*
	 * Creates the GUI to display the images in
	 */
	public ImageViewer()
	{
		//Sets the title of the GUI to Images
		setTitle("Images");
		
		//Sets the close operation to exit on close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creates the border
		setLayout(new BorderLayout());
		
		//Creates the image panel
		buildImagePanel();
		
		//Creates the button panel
		buildButtonPanel();
		
		//Centers the image
		add(imagePanel, BorderLayout.CENTER);
		
		//Places the button at the bottom of the panel
		add(buttonPanel, BorderLayout.SOUTH);
		
		//Allows image to fit within panel
		pack();
		
		//Allows image to be seen by user
		setVisible(true);
		
	}
	
	/*
	 * Creates the panel the image will be displayed within
	 */
	private void buildImagePanel()
	{
		
		//Creates a new JPanel
		imagePanel = new JPanel();
		
		//Creates a new JLabel
		imageLabel = new JLabel();
		
		//Adds the label to the image panel
		imagePanel.add(imageLabel);
				
		
	}

	/*
	 * Creates the panel the button will be 
	 * located in 
	 */
	private void buildButtonPanel()
	
	{
		//Creates a new JPanel for the button
		buttonPanel = new JPanel();
		
		//The text shown on the button
		button = new JButton("Choose image to be displayed");
		
		//Sets action listener to accept user actions
		button.addActionListener(new ButtonListener());
		
		//Adds the button to the panel
		buttonPanel.add(button);
		
	}

	/*
	 * The ButtonListener class is used to both wait for the user
	 * to click the shown button then opens
	 * a menu for the user to choose an image and 
	 * allows the image to be displayed to 
	 * the user
	 */
	public class ButtonListener implements ActionListener
	{

		/*
		 * This method waits for the user to perform an action
		 * which would be to click the provided button and then
		 * waits for the user to select a file to 
		 * display within a created panel.
		 * (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent event)
		{
			
			//Allows the user to select a file on their computer
			JFileChooser fileChooser = new JFileChooser();
			
			//Waits for user to hit the button provided
			int status = fileChooser.showOpenDialog(null);
						
			if(status == JFileChooser.APPROVE_OPTION)
				
			{
				//File selected by user
				File selectedFile = fileChooser.getSelectedFile();
				
				//Retrieves path to selected file and filename
				String filename = selectedFile.getPath();
				
				//Puts the selected image or file into an image icon object
				ImageIcon selectedImageFile = new ImageIcon(filename);
				
				//Displays the file within the image label
				imageLabel.setIcon(selectedImageFile);
				
				//Removes text from the label
				imageLabel.setText(null);
				
				//Allows the image to fit within the label
				pack();
			}
			
		}
			
	}
	
	/*
	 * Activates the image viewer class for user to select a file
	 * and displays the file to the user in a generated panel
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		
		//Creates an image viewer object
		ImageViewer images = new ImageViewer();
		
		//Displays the image viewer object
		images.show();
		
		
	}

}
