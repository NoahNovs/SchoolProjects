package rctmpx;

import java.io.*;
import java.util.*;

public class Model {
  private Model() {
    try {
      this.reset(); // load from database
    } catch (Exception e) {

    }
  }
  private static Model instance = new Model(); // at compile time, singleton
  public static Model getInstance() {
    return instance;
  }
  Integer nextAvailableId = 0;
  Map<Integer, Task> a;
  String pathToDatabase = "/nobackup/nnovales/c322-workspace/apache-tomcat-9.0.53/webapps/stage02/permanent/database";
  synchronized void reset() throws Exception {
    FileInputStream fis = new FileInputStream(pathToDatabase);
    ObjectInputStream ois = new ObjectInputStream(fis);
    this.a = (HashMap<Integer, Task>) ois.readObject();
    ois.close();
    this.nextAvailableId = (this.a.keySet()).size();
  }
  Task retrieveTask(Integer id) {
    return a.get(id);
  }
  ArrayList<Task> retrieveAll() {
    ArrayList<Task> a = new ArrayList<Task>();
    for (Integer key : this.a.keySet()) {
      a.add(this.a.get(key));
    }
    return a;
  }
  synchronized void delete(Integer id) {
    this.a.remove(id);
  }
  synchronized void addTask(String task) {
    Integer id = nextAvailableId++;
    this.a.put(id, new Task(id, task));
  }
  synchronized void save() throws Exception {
    FileOutputStream fout = new FileOutputStream(pathToDatabase);
    ObjectOutputStream oos = new ObjectOutputStream(fout);
    oos.writeObject(this.a);
  }
}