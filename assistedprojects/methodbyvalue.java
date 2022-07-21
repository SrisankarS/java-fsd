package assistedprojects;

public class methodbyvalue 
{
	double val=12.6;
	double operation(double val) 
	{
	  val =val*10/100;
	  return(val);
	}
    public static void main(String args[]) 
    {
      methodbyvalue e = new methodbyvalue();
      System.out.println("Before operation value of data is "+e.val);
      e.operation(100);
      System.out.println("After operation value of data is "+e.val);
      }
}
