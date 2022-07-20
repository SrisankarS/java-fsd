package emailid;

import java.util.ArrayList;
import java.util.Scanner;

public class emailid {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    try {
      ArrayList<String> mail = new ArrayList<String>();
      mail.add("sri@gmail.com");
      mail.add("abhi@gmail.com");
      mail.add("manav@gmail.com");
      mail.add("kumar@gmail.com");
      mail.add("abhishek@gmail.com");
      System.out.println("Enter User E-Mail ID: ");
      String userID = input.nextLine();
      //check user mail id is found or not
      if (mail.contains(userID)) {
        System.out.println();
        System.out.println("email ID " + userID + " found");
      } 
      else {
        System.out.println("email ID " + userID + " Not found");

      }
    } finally {
      input.close();
    }
  }
}
