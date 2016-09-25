package csc207;

public class File {
  
  String content;
  String name;
  
  public File(String content, String name){
    this.content = content;
    this.name = name;
  }
  
  public void changeContent(String newContent){
    this.content = newContent;
  }
  
  public String toString(){
    return this.content;
  }
  
  public void appendContent(String content){
    this.content+= content;
  }
  
  public String getName(){
    return this.name;
  }

}
