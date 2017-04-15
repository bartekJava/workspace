package readwrite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReadWriteTest
{
	public static void main(String[] args)
	{
		List<String> lines = new ArrayList<>();
		lines.add("This is the first line.");
		lines.add("This is the second line.");
		lines.add("This is the third line.");
		
		FileWriterLambda.use("test.txt", writer -> writer.writeToFile(lines));
		
		
		Path path = Paths.get("test2.txt");
		
		
		try
		{
			Files.write(path, lines, StandardOpenOption.CREATE);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try
		{
			Stream<String> data = Files.lines(path);
			data.forEach(System.out::println);
			List<String> listedLines = data.collect(Collectors.toList());
			data.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
