package assistedprojects;

public class typecasting {
	public static void main(String[] args) {
	    
	    //implicit conversion
	    System.out.println("Implicit Type Casting");
	    char a='B';
	    System.out.println("Value of a: "+a);
	    
	    int b=a;
	    System.out.println("Value of b: "+b);
	    
	    long c=a;
	    System.out.println("Value of c: "+c);
	    
	    double d=a;
	    System.out.println("Value of d: "+d);
	    
	    long e=a;
	    System.out.println("Value of e: "+e);
	    
	        
	    System.out.println("\n");
	    
	    System.out.println("Explicit Type Casting");
	    //explicit conversion
	    
	    double x=4.76845;
	    int y=(int)x;
	    System.out.println("Value of x: "+x);
	    System.out.println("Value of y: "+y);
	    
	  }
}
