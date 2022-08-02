package multithreadingassistedprojects;

interface first 
{  
    default void show() 
    { 
        System.out.println("Default First"); 
    } 
} 
interface second 
{  
    default void show() 
    { 
        System.out.println("Default Second"); 
    } 
}  
public class diamond implements first, second 
{  
	public void show() 
    {  
        first.super.show(); 
        second.super.show(); 
    } 
    public static void main(String[] args) 
    { 
        diamond ob = new diamond(); 
        ob.show(); 
    } 

}
