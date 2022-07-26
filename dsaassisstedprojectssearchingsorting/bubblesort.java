package dsasearchingsorting;

public class bubblesort {
	public static void bubblesort1(int[] arr)
    {
        int len = arr.length;
        int temp = 0;
        for(int i=0;i<len;i++)
        {
            for (int j=1;j<(len);j++)
            {
                if(arr[j-1]>arr[j]){
                temp = arr[j-1];
                arr[j-1]= arr[j];
                arr[j]= temp;

            }
        }

        }
    }
	public static void main(String[] args)
	{
	     int[] arr= {33,34,87,54,23,55,76,22,23,90};
	     bubblesort1(arr);
	     for(int i=0;i<arr.length;i++)
	     {
	        System.out.println(arr[i]);
	     }
	}
}
