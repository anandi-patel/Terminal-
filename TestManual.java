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

public class TestManual {

  Manual man = new Manual();
  
  @Test // if user does not enter an argument
  public void testManualNoArguments() {
    FileSystem fs = new FileSystem();  
    // created new file system
    fs = man.executeCommand(fs,"");    
    // executed man command but did not enter any argument
    assertEquals("Error: The 'manual' command needs 1 argument. You've entered "
        + "0 arguments. \n", fs.getOutput()); 
    // checked to see if expected value is actual value
  }
  
  @Test // if user enters more than one argument 
  public void testManualMultipleArguments() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"mkdir cd");
    // executed man command but entered more than one argument
    assertEquals("Error: The 'manual' command needs 1 argument. You've entered "
        + "2 arguments. \n", fs.getOutput());
    // checked to see if expected value is actual value
  }
  
  @Test // if user enters and invalid argument
  public void testManuaInvalidArguments() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"mdr");
    // executed man command with invalid argument 
    assertEquals("Error: The 'mdr' command could not be found in the manual.\n"
        , fs.getOutput());
    // checked to see if expected value is actual value
  }
  
  @Test // if user enters exit command as an argument
  public void testManualExit() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"exit");
    // executed man command with exit command
    assertEquals("Quits the program.\n", fs.getOutput());
    // checked to see if expected value is actual value
  }

  @Test // if user enters mkdir command as an argument
  public void testManualMakeDirectory() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"mkdir");
    assertEquals("Creates a directory\n", fs.getOutput());
  }
  
  @Test // if user enters cd command as an argument
  public void testManualChangeDirectory() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"cd");
    assertEquals("Changes the current working directory to the given directory "
        + "name.\n", fs.getOutput());
  }
  
  @Test // if user enters ls command as an argument
  public void testManualListConent() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"ls");
    assertEquals("If there is no path given, then a list of the contents of the"
        + " current working directory is given." +  
        "If there is a path given, then it prints a list of the contents of the"
        + " specified directory.\n", fs.getOutput());
  }
  
  @Test // if user enters pwd command as an argument
  public void testManualPrintWorkingDirectory() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"pwd");
    assertEquals("Print current directory path;\n", fs.getOutput());
  }
  
  @Test // if user enters pushd command as an argument
  public void testManualPushDirectory() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"pushd");
    assertEquals("Saves the current directory specified;\n", fs.getOutput());
  }
  
  @Test // if user enters popd command as an argument
  public void testManualPopDirectory() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"popd");
    assertEquals("Deletes the latest saved directory.\n", fs.getOutput());
  }
  
  @Test // if user enters history command as an argument
  public void testManualHistory() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"history");
    assertEquals("Prints out the previous commands entered.The number specified"
        + " is the number of previous commands printed started from the latest "
        + "command entered.\n", fs.getOutput());
  }
  
  @Test // if user enters cat command as an argument
  public void testManualDisplayContent() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"cat");
    assertEquals("Displays the contents of the file on the shell.\n", 
        fs.getOutput());
  }
  
  @Test // if user enters echo command as an argument
  public void testManualEcho() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"echo");
    assertEquals("If there is no file name given, then the string given is "
        + "printed on the shell." + "The file consists the given string.\n", 
        fs.getOutput());
  }
  
  @Test // if user enters man command as an argument
  public void testManualMan() {
    FileSystem fs = new FileSystem(); 
    fs = man.executeCommand(fs,"man");
    assertEquals("Formats and displays the annual pages on the given command.\n"
        , fs.getOutput());
  }
  
  
  
}


