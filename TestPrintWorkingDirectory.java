package csc207;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPrintWorkingDirectory {
  
  PrintWorkingDirectory pwd = new PrintWorkingDirectory();
  
  @Test //testing command when user enters argumetns
  public void testPrintCorrectWdWithArgs(){
    FileSystem fs = new FileSystem(); //new fileSystem
    fs.setWd("/testfolder/folder");
    fs = pwd.executeCommand(fs, "argument1"); 
    //output should be an error since pwd doesn't accept arguments
    assertEquals("Error: The 'pwd' command does not accept any commands."
        + " You've entered 1 argument(s). \n", fs.getOutput()); 
    //check to make sure the output is what i expected
    
    
  }
  
  @Test //testing command when user enters no arguments
  public void testPrintCorrectWdWithNoArgs() {
    FileSystem fs = new FileSystem(); 
    fs.setWd("/folder1/folder2/file1");
    fs = pwd.executeCommand(fs, ""); 
    assertEquals("/folder1/folder2/file1\n", fs.getOutput()); 
    //made sure the output was equal to what I expected
      
  }
  
  @Test //another test if user enters no arguments
  public void testPrintCorrectWdWithNoArgs1() {
    FileSystem fs = new FileSystem(); 
    fs.setWd("/movies/1994/PulpFiction"); 
    fs = pwd.executeCommand(fs, ""); 
    //executed the pwd command
    assertEquals("/movies/1994/PulpFiction\n", fs.getOutput()); 
    //made sure the output was equal to what I expected
      
  }
  
  @Test //another test if user enters no arguments
  public void testPrintCorrectWdWithNoArgs2() {
    FileSystem fs = new FileSystem(); 
    fs.setWd("/movies/1989/DieHard"); 
    fs = pwd.executeCommand(fs, ""); 
    assertEquals("/movies/1989/DieHard\n", fs.getOutput()); 
      
  }
}
