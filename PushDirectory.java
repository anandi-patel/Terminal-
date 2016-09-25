package csc207;

import java.util.ArrayList;

public class PushDirectory extends Command{
  
  public PushDirectory() {

  }
  /**
   * The purpose of this method is to add the new directory to the 
   * directoryStack. As input parameters it takes in a FileSystem and 
   * the name of the directory that is saved. It returns the FileSystem
   * object.
   * 
   * @param fs The FileSystem object
   * @param arguments The number of arguments a user has entered
   */  
  public FileSystem executeCommand(FileSystem fs, String arguments) {

    String output = "";
    
    //correct number of arguments - NEED TO FIX - CHECK IF PATH IS VALID FIRST
    if (getArgumentNumber(arguments) == 1) {
      
   // paths uses valid characters
      if (arguments.matches(this.validChar)) {
        fs.addToStack(arguments);
      }

      // invalid characters used
      else {
        output += this.getErrorMessage(arguments, 1);
      }
      
    } 
    
    //incorrect number of arguments - raises error
    else {
      output = this.getErrorMessage(arguments, 0);
    }

    fs.setOutput(output);
    return fs;

  }
  
  /**
   * The purpose of this method is to determine the number of arguments that
   * the user has given. The input parameter it takes in is the arguments the
   * user has entered. The function returns the number of arguments that the
   * user has entered.
   * 
   * @param arguments The number of arguments a user has entered
   */ 
  
  public String getErrorMessage(String arguments, int errorNumber) {

    ArrayList<String> errors = new ArrayList<String>();
    errors.add("Error: The 'pushd' command requires 1 argument. You've entered "
            + getArgumentNumber(arguments) + " argument(s).\n");
    errors.add("Error: '" + arguments
        + "' is an invalid path. Characters including \"!@$&*()?:[]\"<>'`|={}\\/\" are not allowed in paths.\n");

    return errors.get(errorNumber);
  }

}
