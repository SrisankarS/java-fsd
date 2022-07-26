package dsaassisstedprojects;

public class stackdsa {
	 static final int mx = 1000; 
     int set; 
     int a[] = new int[mx];  
     boolean empty() 
     { 
             return (set < 0); 
     } 
     stackdsa() 
     { 
             set = -1; 
     } 
     boolean push(int x) 
     { 
             if (set >= (mx-1)) 
             { 
                     System.out.println("Stack Overflow"); 
                     return false; 
             } 
             else
             { 
                     a[++set] = x; 
                     System.out.println(x + " pushed into stack"); 
                     return true; 
             } 
     } 
     int pop() 
     { 
             if (set < 0) 
             { 
                     System.out.println("Stack Underflow"); 
                     return 0; 
             } 
             else
             { 
                     int s = a[set--]; 
                     return s; 
             } 
     } 
 
     public static void main(String args[])
     {
             stackdsa stk = new stackdsa(); 
             stk.push(15); 
             stk.push(50); 
             stk.push(10); 
             System.out.println(stk.pop() + " Popped from stack"); 
     }
}
