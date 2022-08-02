package assistedprojects;

import java.util.regex.*;

public class regularexpression {
	public static void main(String[] args) {

		  String pttrn = "[a-z]+";
		  String chck = "Regular Expressions";
		  Pattern pt = Pattern.compile(pttrn);
		  Matcher ct = pt.matcher(chck);
		  
		  while (ct.find())
		        System.out.println( chck.substring( ct.start(), ct.end() ) );
		  }
}
