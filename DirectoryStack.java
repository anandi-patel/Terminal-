package csc207;

import java.util.ArrayList;

public class DirectoryStack {
  
  ArrayList<String> directoryStack;
  /**
   * Constructs an object which contains a list of strings that stores the
   * name of directories.
   * 
   */  
  public DirectoryStack(){
    this.directoryStack = new ArrayList<String>();
    
  }
  
  /**
   * The purpose of this method is to add a directory to the directory stack.
   * The input parameter it takes in is the name of the directory. It does not
   * return anything.
   * 
   * @param directory The name of the directory.
   */
  
  public void push(String directory){
    directoryStack.add(directory);
  }
  
  /**
   * The purpose of this method is to remove a directory to the 
   * directoryStack. It returns the name of the directory that has been 
   * removed.
   * 
   * @return directory The name of the removed directory.
   */
  
  public String pop(){
    String directory = this.directoryStack.remove(this.directoryStack.size()-1);
    return directory;
  }

  /**
   * The purpose of this method is to return the size of the directoryStack.
   * 
   * @return directory The name of the removed directory.
   */  
  public int getSize(){
    return this.directoryStack.size();
  }

}
