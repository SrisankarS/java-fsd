package dsaassisstedprojects;
import java.util.*;
public class queuedsa {
	public static void main(String[] args) 
    {
		Queue<Integer> Q = new LinkedList<Integer>();

    // Add numbers to end of Queue
    Q.add(9843546);
    Q.add(1342354);
    Q.add(6373544);
    Q.add(1452434);

    // print queue
    System.out.println("Queue: " + Q);

    // print head and deletes the head
    System.out.println("Queue's head: " + Q.remove());

    // print head and deleted the head
    System.out.println("Queue's head: " + Q.remove());
    }
}

