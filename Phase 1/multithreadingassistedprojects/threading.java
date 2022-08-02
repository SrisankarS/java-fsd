package multithreadingassistedprojects;

public class threading extends Thread
{
	public void run()
	  {
	      System.out.println("Concurrent thread started running..");
	  }
	  public static void main( String[] args)
	  {
	      threading t = new  threading();
	      t.start();
	  }
}
