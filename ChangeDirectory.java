package csc207;

import java.util.ArrayList;

public class ChangeDirectory extends Command {
	
  public ChangeDirectory() {

  }
  
  /**
   * The purpose of this method is to change the current working directory to a
   * given file or directory. As input parameters, it takes in a File System 
   * object and the name of a file or directory. The current working directory
   * is then changed to the given directory.
   * 
   * @param File System Object
   * @param The name of the file or directory that the current working 
   * directory will be changed too.
   */
  public FileSystem executeCommand(FileSystem fs, String arguments) {

    String output = "";

    // correct number of args
    if (getArgumentNumber(arguments) == 1) {
      
      // paths uses valid characters
      if (arguments.matches(this.validChar)) {
        fs.setWd(arguments);
      }

      // invalid characters used
      else {
        output = this.getErrorMessage(arguments, 1);
      }
    }

    // incorrect args
    else {
      output = this.getErrorMessage(arguments, 0);
    }
    
    fs.setOutput(output);
    return fs;
  }
  
  /**
   * The purpose of this method is to display an informative error message to 
   * the user. As input parameters it takes in the number of arguments entered
   * by the user and the errorNumber. If the user enters more then one argument
   * into cd then the error message regarding multiple arguments is displayed. 
   * If the user enters an invalid path (i.e. a path with incorrect characters)
   * then the invalid path error message is displayed.
   * @param arguments The arguments given by the user.
   * @param errorNumber The number of the error message to the corresponding
   * error.
   * @return errors.get(errorNumber) The corresponding error message to the 
   * given error number.
   */
  
  protected String getErrorMessage(String arguments, int errorNumber) {

    ArrayList<String> errors = new ArrayList<String>(); 
    errors
        .add("Error: The 'cd' command can only have 1 command. You've entered "
            + getArgumentNumber(arguments) + " arguments.\n");
    errors.add(
        "Error: '" + arguments + "' is an invalid path. Characters including \"!@$&*()?:[]\"<>'`|={}\\/\" are not allowed in paths.\n");

    return errors.get(errorNumber);
  }

}
