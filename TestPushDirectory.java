package csc207;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPushDirectory {
  
  PushDirectory pushd = new PushDirectory();
  

  @Test //test if no arguments are given
  public void testPushWithNoArgument() {
    FileSystem fs = new FileSystem(); //new fileSystem
    fs = pushd.executeCommand(fs,""); 
    //output should be an error since an argument is needed
    assertEquals("Error: The 'pushd' command requires 1 argument. "
        + "You've entered 0 argument(s).\n", fs.getOutput()); 
    // checked to see if expected value is actual value
    
  }
  
  @Test //test if more than one argument is given
  public void testPushWithManyArguments() {
    FileSystem fs = new FileSystem(); //new fileSystem
    fs = pushd.executeCommand(fs,"movies tv"); 
    //output should be an error since only one argument is needed
    assertEquals("Error: The 'pushd' command requires 1 argument. "
        + "You've entered 2 argument(s).\n", fs.getOutput()); 
    // checked to see if expected value is actual value
    
  }
  
  @Test //test if invalid argument in entered
  public void testPushWithInvalidArgument() {
    FileSystem fs = new FileSystem(); //new fileSystem
    fs = pushd.executeCommand(fs,"$@"); 
    //output should be an error since a valid argument is needed
    assertEquals("Error: '$@' is an invalid path. Characters including "
        + "\"!@$&*()?:[]\"<>'`|={}\\/\" are not allowed in paths.\n"
        , fs.getOutput()); 
    // checked to see if expected value is actual value
    
  }
/*  
  @Test //test if proper argument is entered 
  public void testPushWithArgument1() {
    FileSystem fs = new FileSystem(); //new fileSystem
    fs = pushd.executeCommand(fs,"soccer"); //
    assertEquals(); 
    // checked to see if expected value is actual value
    
  } 
*/   
  


}
  