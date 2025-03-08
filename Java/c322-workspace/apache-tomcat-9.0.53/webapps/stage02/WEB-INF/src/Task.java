package rctmpx;

public class Task implements java.io.Serializable {
  private Integer id;
  private String task;
  public Task(Integer id, String task) {
    this.id = id;
    this.task = task;
  }
  public String toString() {
    return "(" + this.id + ": [" + this.task + "])";
  }
  public Integer id() { return this.id; }
  public String task() { return this.task; }
  public static void main(String[] args) {
    Task a = new Task(1, "Go to Chicago.");
    Task b = new Task(2, "Come back from Chicago");
    System.out.println( a );
    System.out.println( b );
    System.out.println( b.task() );
    System.out.println( a.id() );

  }
}