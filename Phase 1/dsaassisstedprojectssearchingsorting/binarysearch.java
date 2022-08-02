package dsasearchingsorting;

public class binarysearch {
	public static void binarysearch1(int[] arr, int start, int key, int length)
	{

        int middlevalue = (start+length)/2;
        while(start<=length)
        {
        	if(arr[middlevalue]<key)
        	{
        		start = middlevalue + 1;
            } 
        	else if(arr[middlevalue]==key)
        	{
               System.out.println("Element is found at index :"+middlevalue);
               break;
            }else 
            {

            length=middlevalue-1;
            }
            middlevalue = (start+length)/2;
        }
            if(start>length){

                System.out.println("Element is not found");
            }

	}
	public static  void main(String[] args){


        int[] arr = {23,12,66,87,98};
        int key = 66;
        int arrlength = arr.length;
        binarysearch1(arr,0,key,arrlength);
    }
}
