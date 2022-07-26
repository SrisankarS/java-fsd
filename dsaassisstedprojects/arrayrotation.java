package dsaassisstedprojects;

public class arrayrotation {
	public void arrotate(int[] num, int n) {
        if(n > num.length) 
            n=n%num.length;
    int[] res = new int[num.length];
    for(int i=0; i < n; i++){
                res[i] = num[num.length-n+i];
    }
    int j=0;
        for(int i=n; i<num.length; i++){
                res[i] = num[j];
                j++;
        }
    System.arraycopy( res, 0, num, 0, num.length );
}
}
