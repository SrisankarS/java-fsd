package phase1project;

import java.io.*;
import java.util.*;

public class LockedMe {
	public int mainMenu() throws Exception
	  {
	    System.out.print("\n--------------------------" 
	      + "\nMAIN MENU (LokedMe.com)"
	      + "\n--------------------------"
	      + "\nDeveloper: Sri Sankar S."
	      + "\n--------------------------"
	      + "\n1. Add File"
	      + "\n2. Delete File"
	      + "\n3. Search File"
	      + "\n4. List the Files (sorted)"
	      + "\n5. Exit"
	      + "\n--------------------------"
	      + "\nEnter your option: ");

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int mainOption = Integer.parseInt(br.readLine());
	    return mainOption;
	  }

	  public List<String> subMenu(int mainOption) throws Exception
	  {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    List<String> userIn = new ArrayList<String>();
	    List<Integer> fileRequestOption = new ArrayList<Integer>()
	    {
	      {
	        add(1);
	        add(2);
	        add(3);
	      }
	    };

	    System.out.print("Enter Username: ");
	    String u = br.readLine();
	    userIn.add(u);

	    if(fileRequestOption.contains(mainOption)) {
	      System.out.print("Enter Filename: ");
	      String f = br.readLine();
	      userIn.add(f);
	    }

	    return userIn;
	  }

	  public static void main(String[] args) throws Exception
	  {
	    Hashtable<String, ArrayList<String>> userFileMap = new Hashtable<String, ArrayList<String>>();

	    ArrayList<String> userGen = new ArrayList<String>()
	    {
	      {
	        add("alex");
	        add("brad");
	        add("fred");
	        add("john");
	        add("sven");
	      }
	    };

	    ArrayList<String> fileGen = new ArrayList<String>()
	    {
	      {
	        add("fand11");
	        add("gran23");
	        add("hamd73");
	        add("zang42");
	        add("loft51");
	      }
	    };
	    Collections.sort(fileGen);

	    for(int i=0; i < userGen.size(); i++)
	    {
	      userFileMap.put(userGen.get(i), fileGen);
	    }

	    LockedMe lm = new LockedMe();
	    int mainOption = 0;

	    while(mainOption >= 0) {
	      mainOption = lm.mainMenu(); 
	      List<String> subOptions;
	      String u, f;

	      switch(mainOption) 
	      {
	        case 1:
	          subOptions = lm.subMenu(mainOption);
	          u = subOptions.get(0);
	          f = subOptions.get(1);
	          
	          if(userFileMap.containsKey(u)) {
	            ArrayList<String> userFileList = userFileMap.get(u);
	            if(userFileList.contains(f)) {
	              System.out.println("\nInfo: File (" + f + ") already exist within the user (" + u + ") list.");
	            }
	            else 
	            {
	              userFileMap.get(u).add(f);
	              Collections.sort(userFileMap.get(u));
	              System.out.println("\nSuccess: File (" + f + ") added to user (" + u + ") list.");
	            }
	          }
	          else 
	          {
	            System.out.println("\nException: User (" + u + ") does not exist.");
	          }
	          break;
	        case 2:
	          subOptions = lm.subMenu(mainOption);
	          u = subOptions.get(0);
	          f = subOptions.get(1);

	          if(userFileMap.containsKey(u)) {
	            ArrayList<String> userFileList = userFileMap.get(u);
	            if(userFileList.contains(f)) {
	              userFileMap.get(u).remove(f);
	              Collections.sort(userFileMap.get(u));
	              System.out.println("\nSuccess: File (" + f + ") deleted from user (" + u + ") list.");
	            }
	            else 
	            {
	              System.out.println("\nInfo: File (" + f + ") does not exist within the user (" + u + ") list.");
	            }
	          }
	          else 
	          {
	            System.out.println("\nException: User (" + u + ") does not exist.");
	          }
	          break;
	        case 3:
	          subOptions = lm.subMenu(mainOption);
	          u = subOptions.get(0);
	          f = subOptions.get(1);

	          if(userFileMap.containsKey(u)) {
	            ArrayList<String> userFileList = userFileMap.get(u);
	            if(userFileList.contains(f)) {
	              System.out.println("\nSuccess: File (" + f + ") exist within the user (" + u + ") list.");
	            }
	            else 
	            {
	              System.out.println("\nException: File (" + f + ") does not exist within the user (" + u + ") list.");
	            }
	          }
	          else 
	          {
	            System.out.println("\nException: User (" + u + ") does not exist.");
	          }
	          break;
	        case 4:
	          subOptions = lm.subMenu(mainOption);
	          u = subOptions.get(0);

	          if(userFileMap.containsKey(u)) {
	            System.out.println("User (" + u + ") files: " + userFileMap.get(u).toString());
	          }
	          else 
	          {
	            System.out.println("\nException: User (" + u + ") does not exist.");
	          }
	          break;
	        case 5:
	          System.exit(0);
	        default:
	          System.out.println("Exception: Please enter a valid option.");
	          break;
	      }
	    }
	  }
}
