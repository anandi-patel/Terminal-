package csc207;

import java.util.ArrayList;

public class ListContents extends Command {

  public ListContents() {

  }
  
  /**
   * The purpose of this method is to return the FileSystem. As input parameters it 
   * takes in the number of arguments that have been entered. Then it returns the
   * given FileSystem object.
   * 
   * @param fs The File System
   * @param arguments The number of arguments a user has entered
   */  
  
  public FileSystem executeCommand(FileSystem fs, String arguments) {
    String output = "";
    
    // no arguments given
    if (getArgumentNumber(arguments) == 0) {
      output = this.getErrorMessage(arguments, 0);
    } else {
      String[] paths = this.getArgs(arguments);
      for (String path : paths) {

        // paths uses valid characters
        if (path.matches(this.validChar)) {
          // do something
        }

        // invalid characters used
        else {
          output += this.getErrorMessage(path, 1);
        }
      }

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
  
  protected String getErrorMessage(String arguments, int errorNumber) {

    ArrayList<String> errors = new ArrayList<String>();
    errors
        .add("Error: The 'ls' command needs atleast 1 argument. You've entered "
            + getArgumentNumber(arguments) + " arguments. \n");
    errors.add("Error: '" + arguments
        + "' is an invalid path. Characters including \"!@$&*()?:[]\"<>'`|={}\\/\" are not allowed in paths.\n");

    return errors.get(errorNumber);
  }

}
