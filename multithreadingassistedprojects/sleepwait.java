package multithreadingassistedprojects;

public class sleepwait {
	private static Object lck = new Object();
    public static void main(String[] args) throws InterruptedException
    {
        Thread.sleep(1000);
        System.out.println("Thread '" + Thread.currentThread().getName() + "' is woken after sleeping for 1 sec");
        synchronized (lck) 
        {
            lck.wait(1000);
            System.out.println("Object '" + lck + "' is woken after" + " waiting for 1 second");
        }
    }
}
