package readwrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileWriterLambda implements AutoCloseable
{
	private final PrintWriter writer;
	
	private FileWriterLambda(final String fileName) throws IOException {
		writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
	}
	
	@Override
	public void close() throws IOException {
		writer.close();
		System.out.println("writer closed...");
	}
	
	public void writeToFile(final List<String> linesToWrite) throws IOException {
		linesToWrite.forEach(line -> writer.println(line));
	}
	
	
	public static void use(final String fileName, 
			final UseWriter<FileWriterLambda, IOException> block) {
		
		try(final FileWriterLambda writerLambda = new FileWriterLambda(fileName)){
			block.accept(writerLambda);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}


}
