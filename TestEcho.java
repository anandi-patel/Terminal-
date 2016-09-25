package csc207;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEcho {
  Echo Echo = new Echo();
  
  @Test // test invalid argument
  public void testInvaildArgument() {
    FileSystem fs = new FileSystem(); 
    //new fileSystem
    fs = Echo.executeCommand(fs,"5 wrong"); 
    assertEquals("Error: The first parameter of command 'echo' needs to "
        + "be surrounded with double quotes.\n",fs.getOutput()); 
  }
  @Test // test incorrect argument
  public void testIncorrectArgument() {
    FileSystem fs = new FileSystem(); 
    //new fileSystem
    fs = Echo.executeCommand(fs,""); 
    assertEquals("Error: The 'echo' command needs atleast 1 argument. You've entered "
        + 0 + " arguments.\n",fs.getOutput()); 
  }

}
