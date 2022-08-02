package dsaassisstedprojects;

public class main {
	public static void main(String[] args) {
        arrayrotation r = new arrayrotation();
                int arr[] = { 11,12,13,14,15,16,17 }; 
                r.arrotate(arr, 5); 
                for(int i=0;i<arr.length;i++){
                        System.out.print(arr[i]+" ");
                }
    }
}
