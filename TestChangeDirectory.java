package csc207;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestChangeDirectory {
	
	FileSystem fs = new FileSystem();
	ChangeDirectory cd = new ChangeDirectory();
	
	@Test //test if too many arguments are given
	public void testChangeDirectoryWithManyArguments() {
	    fs.setWd("/folder1/folder2/file1");
	    fs = cd.executeCommand(fs, "cd folder10");
	    assertEquals("Error: The 'cd' command can only have 1 command. "
	    		+ "You've entered 2 arguments.\n", fs.getOutput());   		
	}
	
	 @Test //test if invalid argument in entered
	  public void testChangeDirectoryWithInvalidArgument() {
	    FileSystem fs = new FileSystem(); //new fileSystem
	    fs = cd.executeCommand(fs,"$@"); 
	    //output should be an error since a valid argument is needed
	    assertEquals("Error: '$@' is an invalid path. Characters including "
	        + "\"!@$&*()?:[]\"<>'`|={}\\/\" are not allowed in paths.\n"
	        , fs.getOutput()); 
	    // checked to see if expected value is actual value
	    
	  }
	@Test //test if correct argument is given
	public void testChangeToParentDirectory() {
		fs.setWd("/folder1/folder2/file1");
		assertEquals("", fs.getOutput());
	}

}
