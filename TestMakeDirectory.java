package csc207;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TestMakeDirectory {

	FileSystem fs = new FileSystem();
	MakeDirectory mkdir = new MakeDirectory();
	
	@Test //test if too many arguments are given
	public void testMakeDirectoryNoArguments() {
	    fs = mkdir.executeCommand(fs, "");
	    assertEquals("Error: The 'mkdir' command needs atleast 1 argument. "
	    		+ "You've entered 0 arguments.\n", fs.getOutput());   		
	}
	
	 @Test //test if invalid argument in entered
	  public void testMakeDirectoryWithInvalidArgument() {
	    FileSystem fs = new FileSystem(); //new fileSystem
	    fs = mkdir.executeCommand(fs,"$@"); 
	    //output should be an error since a valid argument is needed
	    assertEquals("Error: '$@' is an invalid path. Characters including "
	        + "\"!@$&*()?:[]\"<>'`|={}\\/\" are not allowed in paths.\n"
	        , fs.getOutput()); 
	    // checked to see if expected value is actual value
	    
	  }
	

}
