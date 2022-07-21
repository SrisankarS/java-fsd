package multithreadingassistedprojects;

public class throwskeyword {
	 void division() throws ArithmeticException
     {
         int a=35,b=0,r;
         r = a / b;
         System.out.print("\n\tThe result is : " + r);
     }
      public static void main(String[] args)
     {
       throwskeyword t = new throwskeyword();
        try
       {
           t.division();
       }
       catch(ArithmeticException Ex)
       {
           System.out.print("\n\tError : " + Ex.getMessage());
       }
       System.out.print("\n\tEnd of program.");
     }
}
