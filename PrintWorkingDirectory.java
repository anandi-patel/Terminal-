package csc207;

import java.util.ArrayList;

public class PrintWorkingDirectory extends Command {

  public PrintWorkingDirectory() {

  }
  /**
   * The purpose of this method is to check that the number of 
   * arguments entered is correct. As input parameters, the function takes
   * in a FileSystem and the name of a directory or file. The function returns
   * the path of the absolute directory.
   * 
   * @param arguments The number of arguments a user has entered
   * @return fs The FileSystem
   */    

  public FileSystem executeCommand(FileSystem fs, String arguments) {

    String output = "";
    if (getArgumentNumber(arguments) == 0) {
      output = fs.getWd() + "\n";
    } else {
      output = this.getErrorMessage(arguments, 0);
    }

    fs.output = output;
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
    errors.add(
        "Error: The 'pwd' command does not accept any commands. You've entered "
            + getArgumentNumber(arguments) + " argument(s). \n");

    return errors.get(errorNumber);
  }

}
