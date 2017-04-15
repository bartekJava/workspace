package readwrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileWriterTEMP
{
	public static void writeToFile(String filename, ArrayList<String> infoToWrite)
	{
		File file = new File(filename);
		try
		{
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for(int i = 0; i<infoToWrite.size(); i++)
			{
				output.println(infoToWrite.get(i));
			}
			
			output.close();
			
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			System.out.println("An I/O exception occured");
		}
	}
}
