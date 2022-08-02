package multithreadingassistedprojects;
class userexception extends Exception 
{ 
    public userexception(String s) 
    { 
        super(s); 
    } 
} 
public class handlemain {
	public static void main(String[] args) 
    { 
        try
        { 
            throw new userexception("temp"); 
        } 
        catch (userexception ex) 
        { 
            System.out.println("Caught"); 
            System.out.println(ex.getMessage()); 
        } 
    } 

}
