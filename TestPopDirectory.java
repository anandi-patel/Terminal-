// **********************************************************
// Assignment2:
// Student1: Sayantan Chattopadhyay
// UTOR user_name:chatto14
// UT Student #:1000818145
// Author:Sayantan Chattopadhyay
//
// Student2: Leah Furyk
// UTOR user_name: furyklea
// UT Student #: 1001308373
// Author: Leah Furyk
//
// Student3: Shrey Jain
// UTOR user_name: jainshre
// UT Student #: 999835558
// Author: Shrey Jain
//
// Student4: Anandi Patel
// UTOR user_name: patela65
// UT Student #: 1001558897
// Author: Anandi Patel
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC 207 and understand the consequences.
// *********************************************************
package csc207;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestPopDirectory {

  PopDirectory popd = new PopDirectory();
  
  
  @Test // if popd is called when stack is empty
  public void testPopOnEmptyStack() {
    FileSystem fs = new FileSystem(); 
    //new fileSystem
    fs = popd.executeCommand(fs,""); 
    //pop command is executed
    assertEquals("Error: The directory stack is empty so nothing can be popped."
        + "\n", fs.getOutput()); 
    //check to make sure the output is an error as stack is empty
    
  }
  
  @Test //popd when stack is not empty
  public void testPopOnNonEmptyStack1() {
    FileSystem fs = new FileSystem(); 
    fs.addToStack("movies");
    fs.addToStack("1994");
    fs.addToStack("PulpFiction");
    // creates a stack that is now not empty
    fs = popd.executeCommand(fs,"");
    assertEquals("PulpFictionjjj",fs.getWd());
    // check to make sure working directory is changed to what was popped
    
    
  }
  
  @Test //another nonempty stack test for popd
  public void testPopOnNonEmptyStack2() {
    FileSystem fs = new FileSystem(); 
    fs.addToStack("movies");
    fs.addToStack("1994");
    fs.addToStack("LionKing");
    fs = popd.executeCommand(fs,"");
    assertEquals("LionKing",fs.getWd());
    
  }
  
  @Test
  public void testPopOnNonEmptyStack3() {
    FileSystem fs = new FileSystem(); 
    fs.addToStack("movies");
    fs.addToStack("1994");
    fs.addToStack("ShawshankRedemption");
    fs = popd.executeCommand(fs,"");
    assertEquals("ShawshankRedemption",fs.getWd());
    
  }
  
  @Test
  public void testPopOnNonEmptyStack4() {
    FileSystem fs = new FileSystem(); 
    fs.addToStack("1994");
    fs.addToStack("ForrestGump");
    fs = popd.executeCommand(fs,"");
    assertEquals("ForrestGump",fs.getWd());
    
  }
  
}
