package csc207;

import java.util.List;

public class FileSystem {
  
  String wd;
  String output;
  DirectoryStack directoryStack;
  History history;
  Directory root;
  
  /**
   * Constructs an object which contains a directoryStack object, and a History
   * object, a string for the working directory and a string for the output. 
   * The History object will keep track of the commands that the user has 
   * entered. The DirectoryStack object will keep track of the saved 
   * directories.
   * The string for the working directory will contain the path the user is 
   * currently in and the string for the output will contain the messages that
   * will be displayed to the user.
   * 
   */
  
  public FileSystem(){
    this.wd = "/";
    this.output = "";
    this.directoryStack = new DirectoryStack();
    this.history = new History();
    this.root = new Directory("root");
  }
  
  /**
   * The purpose of is to set the working directory
   * 
   * @param wd The string representing the working directory.
   */
  
  public void setWd(String wd){
    this.wd = wd;
  }
  
  /**
   * The purpose of is to set the output message.
   * 
   * @param output The string representing the output message.
   */
  
  public void setOutput(String output){
    this.output = output;
  }
  
  /**
   * The purpose of is to add the directory given to the directoryStack.
   * 
   * @param dir The string representing the directory.
   */

  public void addToStack(String dir){
    this.directoryStack.push(dir);
  }
  
  /**
   * The purpose of is to return the size of the directoryStack.
   * 
   * @return directoryStack.getSize() The size of the directoryStack.
   */
  
  public int getStackSize(){
    return this.directoryStack.getSize();
  }
  
  /**
   * The purpose of is to get the most recent directory that was added
   * to the directory stack.
   * 
   * @return directoryStack.pop() The string representing the most recent added
   * directory to the directoryStack.
   */

  public String getFromStack(){
    return this.directoryStack.pop();
  }
  
  /**
   * The purpose of is to return the output message.
   * 
   * @return output The string representing the output message.
   */  

  public String getOutput(){
    return this.output;
  }
  
  /**
   * The purpose of is to return the name of the working directory.
   * 
   * @return wd The string representing the working directory.
   */  
  
  public String getWd(){
    return this.wd;
  }
  
  /**
   * The purpose of this method is to return the commands that have been 
   * previously entered. The number of commands returned is given by the user.
   * As an input parameter it takes in the number of commands previously
   * entered that the user wants.
   * 
   * @param n The number of commands the user wants displayed.
   * @return history.getLastN() A list representing the previously entered
   * commands.
   */  
  
  public List<String> getHistory(int n){
    return this.history.getLastN(n);
  }
  
  /**
   * The purpose of is to return the size of the History object.
   * 
   * @return history.size() The size of history
   */  
  
  public int getHistorySize(){
    return this.history.size();
  }
  
  /**
   * The purpose of is to add an entry to the History object history.
   * 
   * @param entry The entry to be added to the history object.
   */    

  public void addToHistory(String entry){
    this.history.addHistory(entry);
  }
  
  public boolean pathExists(List<String> path){
	  return this.root.pathExists(path);
  }
  
  public void mkdir(List<String> path){
	  this.root.makeDirectory(path);
  }
  
  public void list(List<String> path){
	  this.root.list(path);
  }

}
