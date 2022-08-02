package dsasearchingsorting;

public class selectionsort {
	public static void selectionsort1(int[] arr){

        for(int i=0;i<arr.length-1;i++){

            int index =i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[index]){

                    index =j;
                }

            }
            int smallNumber = arr[index];
            arr[index]= arr[i];
            arr[i]= smallNumber;
        }

    }
	public static void main(String[] args) {

	    int[] arr = {5,3,4,7,1,6,9};
	    int l = arr.length;
	    System.out.println("Length of the String= "+ l);
	    selectionsort1(arr);
	    System.out.println("The sorted elements are:");
	    for(int i:arr){

	        System.out.println(i);
	         }
	     }
}
