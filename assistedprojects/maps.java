package assistedprojects;

import java.util.*;

public class maps {
public static void main(String[] args) {
		   
	    
	    //Hashmap
	    HashMap<Integer,String> hshmp=new HashMap<Integer,String>();      
	        hshmp.put(11,"Ankit");    
	        hshmp.put(12,"Kunal");    
	        hshmp.put(13,"Manish");   
	         
	        System.out.println("\nThe elements of Hashmap are ");  
	        for(Map.Entry<Integer,String> m:hshmp.entrySet())
	        {    
	         System.out.println(m.getKey()+" "+m.getValue());    
	        }
	        
	       //HashTable
	         
	        Hashtable<Integer,String> hshtb=new Hashtable<Integer,String>();  
	        
	        hshtb.put(14,"Johny");  
	        hshtb.put(15,"Eleven");  
	        hshtb.put(16,"Jerry");  
	        hshtb.put(17,"Alex");  

	        System.out.println("\nThe elements of HashTable are ");  
	        for(Map.Entry<Integer,String> n:hshtb.entrySet()){    
	         System.out.println(n.getKey()+" "+n.getValue());    
	        }
	        
	        
	        //TreeMap
	        
	        TreeMap<Integer,String> treemp=new TreeMap<Integer,String>();    
	        treemp.put(18,"Sankar");    
	        treemp.put(19,"Sriram");    
	        treemp.put(20,"Aravind");       
	        
	        System.out.println("\nThe elements of TreeMap are ");  
	        for(Map.Entry<Integer,String> l:treemp.entrySet()){    
	         System.out.println(l.getKey()+" "+l.getValue());    
	        }    
	        
	     }  
}
