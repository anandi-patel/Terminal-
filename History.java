package csc207;

import java.util.ArrayList;
import java.util.List;

/**
 * History object that stores and returns entries.
 *
 */
public class History {
  
  ArrayList<String> history;
  
  /**
   * Class constructor.
   */
  public History(){
    this.history = new ArrayList<String>();
  }
  
  /**
   * Used to add another entry (i.e. entered commands) to the list of commands in history.
   * 
   * @param entry The entry that the user wants added to history.
   */  
  public void addHistory(String entry){
    this.history.add(entry);
  }
  
  /**
   * Gets the last n commands, where n is some integer greater than 0.
   * 
   * @param n The number of last commands the user wants.
   * @return A list containing the last n entries in history.
   */  
  public List<String> getLastN(int n){
    return this.history.subList(history.size()-n, history.size());
  }
  
  /**
   * Gets the number of entries stored in history.
   * 
   * @return The number of entries stored in history.
   */    
  public int size(){
    return this.history.size();
  }

}
