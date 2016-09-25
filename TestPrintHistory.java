package csc207;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPrintHistory {
  PrintHistory PrintHistory = new PrintHistory();

  @Test // test 0 as optional argument
  public void testZeroArgument() {
    FileSystem fs = new FileSystem(); 
    //new fileSystem
    fs.addToHistory("pwd");
    fs.addToHistory("popd");
    fs = PrintHistory.executeCommand(fs,"0"); 
    assertEquals("",fs.getOutput()); 
    
  }
  @Test // test 1 as optional argument
  public void testOneArgument() {
    FileSystem fs = new FileSystem(); 
    //new fileSystem
    fs.addToHistory("pwd");
    fs.addToHistory("popd");
    fs = PrintHistory.executeCommand(fs,"1"); 
    assertEquals("popd\n",fs.getOutput()); 
  }
  @Test // test nothing as optional argument
  public void testNoArgument() {
    FileSystem fs = new FileSystem(); 
    //new fileSystem
    fs.addToHistory("pwd");
    fs.addToHistory("popd");
    fs = PrintHistory.executeCommand(fs,""); 
    assertEquals("history"+'\n'+ "popd" + '\n'+ "pwd", fs.getOutput()); 

 }
  @Test // test incorrect number of arguments
  public void testIncorrectArgument() {
    FileSystem fs = new FileSystem(); 
    //new fileSystem
    fs.addToHistory("pwd");
    fs.addToHistory("popd");
    fs = PrintHistory.executeCommand(fs,"3 4"); 
    assertEquals("Error: The 'history' command only accepts a maximum of 1 "
        + "argument. You've entered 2 arguments. \n", fs.getOutput()); 
 }
  @Test // test string as optional argument
  public void testInvalidArgument() {
    FileSystem fs = new FileSystem(); 
    //new fileSystem
    fs.addToHistory("pwd");
    fs.addToHistory("popd");
    fs = PrintHistory.executeCommand(fs,"yes"); 
    assertEquals( "Error: The 'history' command only accepts one optional "
        + "argument of the form 'x', where x is some number. You've entered '"
        + "yes" + "'.\n", fs.getOutput());
 }
}