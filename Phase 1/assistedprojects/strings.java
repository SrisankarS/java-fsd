package assistedprojects;

public class strings {
	public static void main(String[] args) {
	    //methods of strings
	    System.out.println("Methods of Strings");
	    
	    String Sl=new String("Hello");
	    System.out.println(Sl.length());

	    //substring
	    String sb=new String("Welcome");
	    System.out.println(sb.substring(2));

	    //String Comparison
	    String S3="Peace";
	    String S4="Peaec";
	    System.out.println(S3.compareTo(S4));

	    //IsEmpty
	    String S5="";
	    System.out.println(S5.isEmpty());

	    //toLowerCase
	    String S6="READ";
	    System.out.println(S6.toLowerCase());
	    
	    //replace
	    String S7="Peabe";
	    String replace=S7.replace('b', 'c');
	    System.out.println(replace);

	    //equals
	    String a="Welcome to Strings";
	    String b="WeLcOmE tO sTrinGs";
	    System.out.println(a.equals(b));
	 
	    System.out.println("\n");
	    System.out.println("Creating String buffer");
	    //Creating StringBuffer and append method
	    StringBuffer s=new StringBuffer("Program in stringbuffer");
	    s.append("Enjoy learning");
	    System.out.println(s);

	    //insert method
	    s.insert(0, 'w');
	    System.out.println(s);

	    //replace method
	    StringBuffer sbb = new StringBuffer("Hello");
	    sbb.replace(0, 2, "hEl");
	    System.out.println(sbb);

	    //delete method
	    sbb.delete(0, 1);
	    System.out.println(sbb);
	    
	    //StringBuilder
	    System.out.println("\n");
	    System.out.println("Creating String builder");
	    StringBuilder sbu=new StringBuilder("Joyful");
	    sbu.append("Learning");
	    System.out.println(sbu);

	    System.out.println(sbu.delete(0, 1));

	    System.out.println(sbu.insert(1, "Welcome"));

	    System.out.println(sbu.reverse());
	        
	    //conversion  
	    System.out.println("\n");
	    System.out.println("Conversion of Strings to String Buffer and String Builder");
	    
	    String str = "Hello"; 
	        
	        // conversion from String object to StringBuffer 
	        StringBuffer sbrv = new StringBuffer(str); 
	        sbrv.reverse(); 
	        System.out.println("String to String Buffer");
	        System.out.println(sbrv); 
	          
	        // conversion from String object to StringBuilder 
	        StringBuilder sbl = new StringBuilder(str); 
	        sbl.append("world"); 
	        System.out.println("String to StringBuilder");
	        System.out.println(sbl);                  
	  }
}
