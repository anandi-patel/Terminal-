package csc207;

import java.util.ArrayList;

public class Echo extends Command{
  
  public Echo(){
    
  }

  /**
   * The purpose of this method is to check that the user has entered the
   * correct number and type of argument and then removes '\', '+' and '.'.
   * As input parameters this method takes in a FileSystem object and the
   * arguments given by the user. It returns 
   * @param fs The FileSystem object.
   * @param arguments The arguments given by the user.
   * @return fs The FileSystem object.
   */  
  public FileSystem executeCommand(FileSystem fs, String arguments){
    
    String output = "";
    
    //no args given
    if(getArgumentNumber(arguments) == 0 || getArgumentNumber(arguments)>2){
      output = this.getErrorMessage(arguments, 0);
    }
    //one arg given
    else if (getArgumentNumber(arguments) == 1){
      
      //one argument is the correct form
      if (arguments.matches("\\\".+\\\"")){
        output = arguments.substring(1, arguments.length()-1) + "\n";
      }
      
      //incorrect form of argument
      else{
        output = this.getErrorMessage(arguments, 1); 
      }
      
    }
    //two args given
    else{
      
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
    errors.add("Error: The 'echo' command needs atleast 1 argument. You've entered "
        + getArgumentNumber(arguments) + " arguments. \n");
    errors.add("Error: The first parameter of command 'echo' needs to be surrounded with double quotes.\n");

    return errors.get(errorNumber);
  }

}
