package csc207;

import java.util.ArrayList;

public class DisplayContents extends Command {

  public DisplayContents() {

  }
  /**
   * The purpose of this method is to display the contents of a fileSystem
   * object. As input parameters, it takes in a FileSystem object and the
   * arguments entered by the user. It returns the FileSystem object. 
   * 
   * @param fs The fileSystem object.
   * @param arguments The arguments the user has entered.
   * @return fs The fileSystem object.
   */
  public FileSystem executeCommand(FileSystem fs, String arguments) {

    String output = "";

    // correct number of args
    if (getArgumentNumber(arguments) == 1) {
      // paths uses valid characters
      if (arguments.matches(this.validChar)) {
        // do something
      }

      // invalid characters used
      else {
        output += this.getErrorMessage(arguments, 1);
      }
    }

    // incorrect number of args
    else {
      output = this.getErrorMessage(arguments, 0);
    }
    
    fs.setOutput(output);
    return fs;
  }
  /**
   * The purpose of this method is to display an informative error message to 
   * the user. As input parameters it takes in the number of arguments entered
   * by the user and the errorNumber. It returns the error message that is 
   * associated with the given errorNumber.
   * @param arguments The arguments given by the user.
   * @param errorNumber The number of the error message to the corresponding
   * error.
   * @return errors.get(errorNumber) The corresponding error message to the 
   * given error number.
   */
  protected String getErrorMessage(String arguments, int errorNumber) {

    ArrayList<String> errors = new ArrayList<String>();
    errors.add("Error: The 'cat' command needs 1 argument. You've entered "
        + getArgumentNumber(arguments) + " arguments. \n");
    errors.add("Error: '" + arguments
        + "' is an invalid path. Characters including \"!@$&*()?:[]\"<>'`|={}\\/\" are not allowed in paths.\n");

    return errors.get(errorNumber);
  }

}
