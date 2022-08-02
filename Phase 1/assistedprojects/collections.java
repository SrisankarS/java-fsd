package assistedprojects;

import java.util.*;

public class collections {
	public static void main(String[] args) {
	    //creating arraylist
	    System.out.println("Array List");
	    ArrayList<String> state=new ArrayList<String>();   
	        state.add("Tamil Nadu");//
	        state.add("Andhra Pradesh");         
	        System.out.println(state);  
	    
	        //creating vector
	        System.out.println("\n");
	        System.out.println("Vector");
	        Vector<Integer> vect = new Vector();
	        vect.addElement(25); 
	        vect.addElement(13); 
	        System.out.println(vect);
	    
	        //creating linkedlist
	        System.out.println("\n");
	        System.out.println("Linked List");
	        LinkedList<String> studentnames=new LinkedList<String>();  
	        studentnames.add("Manav");  
	        studentnames.add("Kapil");          
	        Iterator<String> itr=studentnames.iterator();  
	        while(itr.hasNext()){  
	         System.out.println(itr.next());  
	         
	         //creating hashset
	         System.out.println("\n");
	         System.out.println("Hash Set");
	         HashSet<Integer> set=new HashSet<Integer>();  
	         set.add(108);  
	         set.add(103);  
	         set.add(105);
	         set.add(102);
	         System.out.println(set);
	         
	         //creating linkedhashset
	         System.out.println("\n");
	         System.out.println("Linked Hash Set");
	         LinkedHashSet<Integer> sets=new LinkedHashSet<Integer>();  
	         sets.add(10);  
	         sets.add(12);  
	         sets.add(16);
	         sets.add(18);         
	         System.out.println(sets);
	          } 
	        }  
}
