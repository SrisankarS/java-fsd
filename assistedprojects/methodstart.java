package assistedprojects;

public class methodstart {
	public int multiplication(int a,int b) 
	  {
	    int z=a*b;
	    return z;
	  }
	  public static void main(String[] args) 
	  {
	      methodstart b=new methodstart();
	      int ans= b.multiplication(25,2);
	      System.out.println("Multiplied value :"+ans);
	  }
}
