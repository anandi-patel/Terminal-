package csc207;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDisplayContents {
  
  DisplayContents cat = new DisplayContents();

  @Test // If user has entered invalid argument
  public void testDisplayContentsWithIncorrectPath() {
    FileSystem fs = new FileSystem(); 
    fs = cat.executeCommand(fs,"[].txt");
    assertEquals("Error: '" + "[].txt"+ "' is an invalid path. Characters including \"!@$&*()?:[]\"<>'`|={}\\/\" are not allowed in paths.\n", fs.getOutput());   
    
  }
  
  @Test // If user has entered wrong number of arguments ( zero arguments)
  public void testDisplayContentsWithIncorrectArg() {
    FileSystem fs = new FileSystem();
    String str = new String("");
    fs = cat.executeCommand(fs, str);
    assertEquals("Error: The 'cat' command needs 1 argument. You've entered " +
        0 + " arguments. \n", fs.getOutput());   
    

 }
  @Test // If user has entered wrong number of arguments (one arguments)
  public void testDisplayContentsWithCorrectArgs() {
    FileSystem fs = new FileSystem(); 
    // need to fix this
    fs.addToStack("a.txt");
    fs = cat.executeCommand(fs,"a.txt");
    assertEquals("abbas", fs.getOutput());  
}
}
