package assistedprojects;

abstract class Anonymousinnerclass 
{
     public abstract void display();
}

public class anonymousinnerclass {
	public static void main(String[] args) {
		  Anonymousinnerclass l = new Anonymousinnerclass() 
		  {

		           public void display() {
		              System.out.println("Anonymous Inner Class");
		           }
		        };
		        l.display();
		     }
}
