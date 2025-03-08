package qotd;

import java.io.*;
import java.util.*; 

public class Model {
  private Model() { 
    try { 
      this.reset(); 
    } catch (Exception e) {

    } 
  } 
  private static Model instance = new Model();
  public static Model getInstance() { 
    return instance; 
  }
  Integer nextAvailableId = 0;
  Map<Integer, Quote> a; 
  String pathToDatabase = "/nobackup/nnovales/c322-workspace/apache-tomcat-9.0.53/webapps/qotd/permanent/database"; 
  // String pathToTextFile = "/u/dgerman/c212-workspace/apache-tomcat-7.0.35/webapps/0425/permanent/database"; 
  synchronized void reset() throws Exception {
    FileInputStream fis = new FileInputStream(pathToDatabase);
    ObjectInputStream ois = new ObjectInputStream(fis);
    this.a = (HashMap<Integer, Quote>) ois.readObject();
    ois.close();
    this.nextAvailableId = (this.a.keySet()).size(); 
  }
  Quote randomQuote() {
    ArrayList<Quote> a = new ArrayList<Quote>(); 
    for (Integer key : this.a.keySet()) {
      a.add(this.a.get(key)); 
    }
    return a.get((int)(Math.random() * a.size()));
  } 
  Quote retrieveQuote(Integer id) {
    return a.get(id);
  } 
  ArrayList<Quote> retrieveAll() {
    ArrayList<Quote> a = new ArrayList<Quote>(); 
    for (Integer key : this.a.keySet()) {
      a.add(this.a.get(key)); 
    }
    return a;
  } 
  synchronized void delete(Integer id) {
    this.a.remove(id); 
  } 
  synchronized void addQuote(String author, String quote) {
    Integer id = nextAvailableId++; 
    this.a.put(id, new Quote(id, author, quote)); 
  } 
  synchronized void updateQuote(Integer id, Quote quote) {
    this.a.put(id, quote); 
  } 
  synchronized void save() throws Exception {
    FileOutputStream fout = new FileOutputStream(pathToDatabase);
    ObjectOutputStream oos = new ObjectOutputStream(fout);
    oos.writeObject(this.a);
  }
}