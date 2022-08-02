package dsapracticeprojects;

public class lis {
	static int LIS(int arr[], int n)
    {
        int LIS[] = new int[n];
        int i, j, max = 0;
 
        /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++)
            LIS[i] = 1;
 
        /* Compute optimized LIS values in bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1)
                    LIS[i] = LIS[j] + 1;
 
        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < LIS[i])
                max = LIS[i];
 
        return max;
    }
 
    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + LIS(arr, n) + "\n");
    }
}
