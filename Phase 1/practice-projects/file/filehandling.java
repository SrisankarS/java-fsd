package file;

//File io classes - fore read & write

import java.io.FileWriter;
import java.io.FileReader;

//Exceptions
import java.io.FileNotFoundException;
import java.io.IOException;


public class filehandling {
	//method - to write into file
	public static boolean writeFile (String fileName, String inputText)
	{
		//FileWriter varaible declaration
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(fileName,true);
			//Writing file char by char
			fileWriter.write("\n");
			for(int i=0; i < inputText.length();i++)
			{
				fileWriter.write(inputText.charAt(i));			
			}
			//File Write Success msg
			System.out.println("Writing to File...  "+fileName+" Success!");
			fileWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e.toString());
			return false;
		}
		return true;
	}
	//method - to read file
	public static boolean readFile (String fileName)
	{
		//initial value for filereader
		FileReader fileReader = null;
		//file position count
		int cnt;
		System.out.println("Reading file... "+fileName);
		
		//check if File is found or not
		try
		{
			fileReader = new FileReader (fileName);
			//Print file content till end of file
			while((cnt=fileReader.read())!=-1)
			{
				System.out.print((char)cnt);
			}
			fileReader.close();
		}
		catch(FileNotFoundException fe)
		{
			System.out.println("FileNotFoundException: "+ fe.toString());
			return false;
		}
		catch(IOException ioe)
		{
			System.out.println("FileNotFoundException: "+ ioe.toString());
			return false;
		}
		return true;
	}
	public static void main (String[] args)
	{
		//File Name
		String fileName = "sample.txt";
		
		//Sample text to write to fileName
		String inputText = "This is awesome Project. I am going to be a Full Stack Developer soon!!!!";
		//get read or write info: 1:read 2:write
		int count = 1;
		writeFile(fileName, inputText);
		readFile(fileName);
	}
}
