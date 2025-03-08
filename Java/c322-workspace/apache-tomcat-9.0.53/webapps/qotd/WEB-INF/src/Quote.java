package qotd;

public class Quote implements java.io.Serializable {
  private Integer id; 
  private String author;
  private String quote;
  public Quote(Integer id, String author, String quote) {
    this.id = id; 
    this.author = author; 
    this.quote = quote; 
  }
  public String toString() {
    return "(" + this.id + ": [" + this.author + ", " + this.quote + "])"; 
  } 
  public Integer id() { return this.id; } 
  public String author() { return this.author; } 
  public String quote() { return this.quote; } 
}