package assistedprojects;

public class innerclass {
	private String mesg="I am an Engineer"; 
	   
	   class inner
	   {  
	    void goal()
	    {
	    System.out.println(mesg+", I am going to be a full stack developer");
	    }  
	   }  


	  public static void main(String[] args) {

	    innerclass ob=new innerclass();
	    innerclass.inner in=ob.new inner();  
	    in.goal();  
	  }
}
