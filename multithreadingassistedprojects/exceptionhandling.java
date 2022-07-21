package multithreadingassistedprojects;

class exceptionhandle extends Exception{
	   String st1;
	   exceptionhandle(String st2) {
	  st1=st2;
	   }
	   public String toString(){ 
	  return ("Exception Occurred: "+st1) ;
	   }
	}
public class exceptionhandling extends Exception
{
	public static void main(String[] args){
		  try{
		    System.out.println("Starting of try block");
		    // I'm throwing the custom exception using throw
		    throw new exceptionhandle("Error");
		  }
		  catch(exceptionhandle exp){
		    System.out.println("Catch Block") ;
		    System.out.println(exp) ;
		  }
		   }
}
