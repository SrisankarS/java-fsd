package multithreadingassistedprojects;

public class throwkeyword 
{
	public static void main(String[] args)
    {

        int a=23,b=0,r;

        try
        {
            if(b==0)        
                throw(new ArithmeticException("Can't divide by zero."));
            else
            {
                r = a / b;
                System.out.print("\n\tThe result is : " + r);
            }
        }
        catch(ArithmeticException ex)
        {
            System.out.print("\n\tError : " + ex.getMessage());
        }

        System.out.print("\n\tEnd of program.");
    }
}
