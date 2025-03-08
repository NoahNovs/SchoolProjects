package qotd;

import java.io.*;
import java.util.*;

public class Four {
  public static void main(String[] args) throws Exception {

    Scanner a = new Scanner(new File(args[0]));

    Integer id = 0; 

    Map<Integer, Quote> b = new HashMap<Integer, Quote>();
    while (a.hasNextLine()) {
      Quote c = new Quote( id, a.nextLine(), a.nextLine() ); 
      b.put(id++, c);
    }
    System.out.println( b );

    FileOutputStream fout = new FileOutputStream("../../permanent/database");
    ObjectOutputStream oos = new ObjectOutputStream(fout);
    oos.writeObject(b);


  }
}