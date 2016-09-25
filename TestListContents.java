package csc207;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestListContents {
	
	ListContents ls = new ListContents();
	MakeDirectory mkdir = new MakeDirectory();
	
	@Test //if the user has not entered an incorrect argument.
	public void testListContentsWithIncorrectPath() {
	    FileSystem fs = new FileSystem(); 
	    //new fileSystem
	    fs = ls.executeCommand(fs,"/error"); 
	    // executed ls command but did not enter any argument
	    assertEquals("Error: The 'ListContents' command requires that the path exists. You've entered "
	        + "a non-existent path. \n", fs.getOutput()); 	 
	}
	
	@Test //Checks to see if the program works correctly on an empty directory.
	public void testListContentsInvalidArguement() {
	    FileSystem fs = new FileSystem(); 
	    //Creates a new fileSystem
	    fs = ls.executeCommand(fs, "ls once");
	    assertEquals("Error: The 'ls' command needs atleast 1 argument. You've entered "
	            + "an incorrect argument. \n"
	            , fs.getOutput());
	        // Checks to see if expected value is actual value
	}
	

	  protected String getErrorMessage(String arguments, int errorNumber) {
		    // checks for the correct arguments 
		    // checks if command exists 
		    ArrayList<String> errors = new ArrayList<String>();
		    errors.add(
		        "Error: The 'manual' command needs 1 argument. You've entered "
		            + " arguments. \n");
		    errors.add(
		        "Error: The '" + arguments + "' command could not be found in the manual.\n");

		    return errors.get(errorNumber);
		  }
	  
	public void testListContentsExit() {
	    FileSystem fs = new FileSystem(); 
	    fs = ls.executeCommand(fs,"exit");
	    // executed man command with exit command
	    assertEquals("Quits the program.\n", fs.getOutput());
	    // Checks to see if expected value is actual value		
	}
	
	public void testListContentsOnExistingPath() {
	    FileSystem fs = new FileSystem(); 
	    //Creates a new fileSystem
	    fs.setWd("/folder1/folder2/file1");
	    fs = ls.executeCommand(fs, "ls folder1");
	    assertEquals("", fs.getOutput());
	}
	
	public void testListContentsOnCurrentDirectory() {
	    FileSystem fs = new FileSystem(); 
	    //Creates a new fileSystem
	    fs = ls.executeCommand(fs, "ls c");	
	    fs = mkdir.executeCommand(fs, "a");
	    assertEquals("Checks the contents of the current directory", fs.getOutput());	    
	}
	

}
