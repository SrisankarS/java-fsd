package dsapracticeprojects;

public class longestinscreasingsubsequence {
	static int max; // stores the LIS
	 
    static int _lis(int arr[], int n)
    {
        // base case
        if (n == 1)
            return 1;
 
        int r, maxend= 1;
 
        for (int i = 1; i < n; i++) {
            r = _lis(arr, i);
            if (arr[i - 1] < arr[n - 1] && r + 1 > maxend)
                maxend = r + 1;
        }

        if (max < maxend)
            max = maxend;
 
        // Return length of LIS ending with arr[n-1]
        return maxend;
    }
 
    // The wrapper function for _lis()
    static int lis(int arr[], int n)
    {
        max = 1;
        _lis(arr, n);
        return max;// returns max
    }
 
    public static void main(String args[])
    {
        int arr[] = {12,34,21,54,23,54,67,88};
        int n = arr.length;
        System.out.println("Length of lis is "+ lis(arr, n) + "\n");
    }
}

