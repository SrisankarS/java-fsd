package dsaassisstedprojects;

public class rangequery {
	static int k = 16;
    static int N = 100000; 
    static long tbl[][] = new long[N][k + 1]; 
    static void buildSparsetbl(int arr[], int n) 
    { 
        for (int i = 0; i < n; i++) 
            tbl[i][0] = arr[i]; 
        for (int j = 1; j <= k; j++) 
            for (int i = 0; i <= n - (1 << j); i++) 
                tbl[i][j] = tbl[i][j - 1] + tbl[i + (1 << (j - 1))][j - 1]; 
    } 
    static long query(int L, int R) 
    {
        long ans = 0; 
        for (int j = k; j >= 0; j--)  
        { 
            if (L + (1 << j) - 1 <= R)  
            { 
                ans = ans + tbl[L][j];
                L += 1 << j; 
            } 
        } 
        return ans; 
    }
    public static void main(String args[]) 
    { 
        int arr[] = { 5,7,9,2,3,4 }; 
        int n = arr.length; 
        buildSparsetbl(arr, n); 
        System.out.println(query(0, 5)); 
        System.out.println(query(3, 5)); 
        System.out.println(query(2, 4)); 
    } 
}
