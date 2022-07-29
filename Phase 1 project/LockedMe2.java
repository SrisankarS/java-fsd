package phase1project;

import java.io.*;
import java.util.*;

class LockedMe2 {
  public static String absPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "phase1project" + File.separator + "files";
  
  public int mainMenu() throws Exception {
    System.out.println();
    System.out.println("|--------------------------------------------------|");
    System.out.println("|----------- LockedMe.com - MAIN MENU -------------|");
    System.out.println("|--------------------------------------------------|");
    System.out.println("|---------- Developer: Sri S. Sivakumar -----------|");
    System.out.println("|--------------------------------------------------|");
    System.out.println("| 1. List files in ascending order                 |");
    System.out.println("| 2. Business Level Operations (Add/Delete/Search) |");
    System.out.println("| 3. Exit application                              |");
    System.out.println("|--------------------------------------------------|");
    System.out.print("Enter your choice: ");

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int mainOption = Integer.parseInt(br.readLine());
    return mainOption;
  }

  public boolean checkFileExists(String f) {
    if(f != "") {
      File fco = new File(absPath + File.separator + f);
      if(fco.exists() && fco.isFile()) {
        return true;
      } else {
        System.out.println("Error: Filename does not exist");
        return false;
      }
    } else {
      System.out.println("Error: Invalid filename");
      return false;
    }
  }

  public boolean bloMenu() throws Exception {
    System.out.println("|--------------------------------------------------|");
    System.out.println("|------------ Business Level Operations -----------|");
    System.out.println("|--------------------------------------------------|");
    System.out.println("| 1. Add a file and its content to the directory   |");
    System.out.println("| 2. Delete a file from the directory              |");
    System.out.println("| 3. Search a file and show its content            |");
    System.out.println("| 4. Back to Main Menu                             |");
    System.out.println("|--------------------------------------------------|");
    System.out.print("Enter your choice: ");

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int bloOption = Integer.parseInt(br.readLine());
    String f;

    switch(bloOption) {
      case 1:
        System.out.print("Enter filename (with extension): ");
        f = br.readLine();
        if(f != "") {
          try {
            File fco = new File(absPath + File.separator + f);
            if (fco.createNewFile()) {
              System.out.println("Success: File created");
            } else {
              System.out.println("Info: File already exists");
            }
            System.out.print("Do you want to add contents (y/n) [n]: ");
            String a = br.readLine();
            if(a.equals("") || a.equals("n")) {
              System.out.println("Info: Skipping content addition");
              break;
            } else if(a.equals("y")) {
              System.out.print("Enter file content: ");
              String content = br.readLine();
              if(!content.equals("")) {
                try {
                  FileWriter fw = new FileWriter(absPath + File.separator + f);
                  fw.write(content);
                  fw.close();
                  System.out.println("Success: File content added");
                } catch (IOException e) {
                  System.out.println("Error: Cannot write file content");
                }
              } else {
                System.out.println("Warn: No content provided");
                System.out.println("Info: Skipping content addition");
              }
            } else {
              System.out.println("Warn: Invalid option");
              System.out.println("Info: Skipping content addition");
            }
          } catch (IOException e) {
            System.out.println("Error: Cannot create file");
          }
        } else {
          System.out.println("Error: Invalid filename");
        }
        break;
      case 2:
        System.out.print("Enter filename (with extension): ");
        f = br.readLine();
        if(this.checkFileExists(f)) {
          File fco = new File(absPath + File.separator + f);
          if(fco.delete()) {
            System.out.println("Success: File deleted");
          } else {
            System.out.println("Error: Issue while deleting file");
          }
        }
        break;
      case 3:
        System.out.print("Enter filename (with extension): ");
        f = br.readLine();
        if(this.checkFileExists(f)) {
          File fco = new File(absPath + File.separator + f);
          if(fco.length() != 0) {
            System.out.println("File content: ");
            try (BufferedReader fbr = new BufferedReader(new FileReader(absPath + File.separator + f))) {
              String line;
              while ((line = fbr.readLine()) != null) {
                System.out.println(line);
              }
            } catch (IOException e) {
              System.out.println("Error: Cannot read file");
            }
          } else {
            System.out.println("Info: File exits but content is empty");
          }
        }
        break;
      case 4:
        break;
      default:
        System.out.println("Error: Please enter a valid option.");
        break;
    }
    return false;
  }

  public static void main(String[] args) throws Exception {
    new File(absPath).mkdir();
    LockedMe2 lmObj = new LockedMe2();
    int mainOption = 0;
    while(mainOption >= 0) {
      mainOption = lmObj.mainMenu();
      switch(mainOption) {
        case 1:
          File folder = new File(absPath);
          String[] fileList = folder.list();
          if(fileList.length > 0) {
            Arrays.sort(fileList);
            System.out.println("File list: ");
            for(String entry : fileList) {
              System.out.println(entry);
            }
          } else {
            System.out.println("Info: No file exist for listing");
          }
          break;
        case 2:
          lmObj.bloMenu();
          break;
        case 3:
          System.exit(0);
        default:
          System.out.println("Error: Please enter a valid option.");
          break;
      }
    }
  }
}