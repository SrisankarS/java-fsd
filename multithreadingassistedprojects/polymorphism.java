package multithreadingassistedprojects;


public class polymorphism {
	class Multiply 
	{
	    public int multi(int x, int y) 
	    { 
	        return (x * y); 
	    } 
	    public int multi(int x, int y, int z) 
	    { 
	        return (x * y * z); 
	    } 
	    public double multi(double x, double y) 
	    { 
	        return (x * y); 
	    } 	
	    public static void main(String args[]) 
	    { 
	        Multiply s = new Multiply(); 
	        System.out.println(s.multi(34, 44)); 
	        System.out.println(s.multi(12, 20, 32)); 
	        System.out.println(s.multi(44.5, 22.564)); 
	    } 
	}
}
