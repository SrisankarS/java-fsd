package assistedprojects;

public class arrays {
	public static void main(String[] args) 
	{

	//single-dimensional array
	int d[]= {1,2,3,4,5,6,7,8,9,13};
	for(int i=0;i<d.length;i++) 
	{
	System.out.println("Elements of array a: "+d[i]);
	}

	//multidimensional array
	int[][] c = {
	            {5, 6, 8, 3}, 
	            {2, 7, 4} 
	            };
	      
	      System.out.println("\nLength of row 1: " + c[0].length);
	      }
}
