package csc207;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {
  
  protected String validChar = "[A-Za-z/0-9-]+"; 

  /**
   * The purpose of this method is to return the file system. As input 
   * parameters it takes in a FileSystem object and the number of 
   * arguments that have been entered. Then it returns the given FileSystem 
   * object.
   * 
   * @param fs The FileSystem object
   * @param arguments The number of arguments a user has entered
   */
  
  public FileSystem executeCommand(FileSystem fs, String arguments){
    return fs;
  }
  
  /**
   * The purpose of this method is to return the arguments given by the user. 
   * As input parameters it takes in the number of arguments that have been 
   * entered. Then it returns the given FileSystem object.
   * 
   * @param arguments The number of arguments a user has entered
   */  
  public String errorMessage(String arguments){
    return arguments; 
  }

  /**
   * The purpose of this method is to separate the arguments with spaces
   * and give the user a list of these arguments. As input parameters it takes
   * in the arguments and returns a list of the arguments where each item 
   * 
   * @param arguments The arguments a user has entered
   */      
  protected String[] getArgs(String arguments){
    return arguments.split(" ");
  }

  /**
   * The purpose of this method is to determine the number of arguments that
   * the user has given. The input parameter it takes in is the arguments the
   * user has entered. The function returns the number of arguments that the
   * user has entered.
   * 
   * @param arguments The number of arguments a user has entered
   */      
  public int getArgumentNumber(String arguments){
    
    //arguments are blank
    if(arguments.length() == 0){
      return 0;
    }
    
    //user entered something in for arguments
    else{
      
      Pattern p = Pattern.compile(" ");
      Matcher m = p.matcher(arguments);
      int count = 1;
      
      while (m.find()){
          count +=1;
      }
      
      return count;
    }
  }
}
