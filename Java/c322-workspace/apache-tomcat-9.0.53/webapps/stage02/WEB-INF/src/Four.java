package rctmpx;

import java.io.*;
import java.util.*;

public class Four {
  public static void main(String[] args) throws Exception {

    Scanner a = new Scanner(new File(args[0]));

    Integer id = 0;

    Map<Integer, Task> b = new HashMap<Integer, Task>();
    while (a.hasNextLine()) {
      Task c = new Task( id, a.nextLine() );
      b.put(id++, c);
    }
    System.out.println( b );

    FileOutputStream fout = new FileOutputStream("../../permanent/database");
    ObjectOutputStream oos = new ObjectOutputStream(fout);
    oos.writeObject(b);


  }
}