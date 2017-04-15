package readwrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReaderTEMP
{
	private static ArrayList<String> listaLiniiTextu = new ArrayList<String>();
	
	public static void getFileInfo(String path)
	{
		listaLiniiTextu.clear();
		File file_1 = new File(path);
		
		try
		{
			BufferedReader getInfo = new BufferedReader(new FileReader(file_1));
			String liniaTextu = getInfo.readLine();
			
			while(liniaTextu != null)
			{
				listaLiniiTextu.add(liniaTextu);
				liniaTextu = getInfo.readLine();
			}
			
			getInfo.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Nie odnaleziono pliku.");
			return;
		}
		catch(IOException e)
		{
			System.out.println("An I/O exception occured");
			return;
		}
	}
	
	public static ArrayList<String> getList()
	{
		return listaLiniiTextu;
	}
}
