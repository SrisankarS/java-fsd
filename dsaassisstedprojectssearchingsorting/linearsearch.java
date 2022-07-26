package dsasearchingsorting;
import java.util.Scanner;
public class linearsearch {
	public static int linearsearching(int arr[], int n) {

	    int arrlength = arr.length;
	    for (int i = 0; i < arrlength - 1; i++) 
	    {
	     if (arr[i] == n) {

	            return i;
	     }
	    }
	    return -1;
	    }
	public static void main(String[] args)
	{

        int[] arr = {44,32,45,32,13,65};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to be searched");
        int searchvalue = sc.nextInt();
            int result = (int) linearsearching(arr,searchvalue);

            if(result==-1){

                System.out.println("Element not in the array");
            } else {

                System.out.println("Element found at "+result+" and the search key is "+arr[result]);
            }


        }
}
