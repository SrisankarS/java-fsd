package assistedprojects;

public class innerclass2 {
	private String mesg="Inner Classes Development";

	 void display()
	 {  
	   class inner
	   {  
	     void mesg()
	     {
	       System.out.println(mesg);
	     }  
	  }  
	  
	  inner i=new inner();  
	  i.mesg();  
	 }  

	 
	public static void main(String[] args)
	 {
	  innerclass2  obj = new innerclass2 ();  
	  obj.display();  
	  }
}
