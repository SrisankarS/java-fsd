package Calculator;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		
		double n1, n2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers ");
		n1= sc.nextDouble();
		n2= sc.nextDouble();
		System.out.println("Select the operation(+,-,*,/,%)");
		char operator = sc.next().charAt(0);
		double ans = 0;
		
		switch(operator) {
		case '+': ans=n1+n2;break;
		case '-': ans=n1-n2;break;
		case '*': ans=n1*n2;break;
		case '/': ans=n1/n2;break;
		case '%': ans=n1%n2;break;
		default:
			System.out.println("Selected option is not there");
			break;
				
		}
		System.out.println("Calculated value= ");
		System.out.println();
		System.out.println(n1+" "+operator+" "+n2+"= "+ans);
		
	}

}
