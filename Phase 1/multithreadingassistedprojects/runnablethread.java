package multithreadingassistedprojects;

public class runnablethread implements Runnable
{
	public static int cnt = 0;
    public runnablethread(){
         
    }
    public void run() 
    {
        while(runnablethread.cnt <= 10)
        {
            try
            {
                System.out.println("Expl Thread: "+(++runnablethread.cnt));
                Thread.sleep(100);
            } 
            catch (InterruptedException iex)
            {
                System.out.println("Exception in thread: "+iex.getMessage());
            }
        }
    } 
    public static void main(String a[])
    {
        System.out.println("Starting Main Thread...");
        runnablethread mt = new runnablethread();
        Thread t = new Thread(mt);
        t.start();
        while(runnablethread.cnt <= 10){
            try{
                System.out.println("Main Thread: "+(++runnablethread.cnt));
                Thread.sleep(100);
            } catch (InterruptedException iex){
                System.out.println("Exception in main thread: "+iex.getMessage());
            }
        }
        System.out.println("End of Main Thread...");
    }
}
