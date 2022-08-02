package multithreadingassistedprojects;

public class finallykeyword {
	public static void main(String[] args)
    {
        int a=34,b=0,r=0;
        try
        {
            r = a / b;
        }
        catch(ArithmeticException Ex)
        {
            System.out.print("\n\tError : " + Ex.getMessage());
        }
        finally
        {
            System.out.print("\n\tThe result is : " + r);
        }
    }
}
