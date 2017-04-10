package streamtest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParallelStream
{
	public static final List<String> names = Arrays.asList("Nate", "Barbara", "Ian", "Lucy");
	
	public static void pickName(final List<String> names, final String startingLetter)
	{
		final Optional<String> foundname =
		names.stream()
		.filter(name -> name.startsWith(startingLetter))
		.findFirst();
		
		System.out.println("A name starting with " + startingLetter + ": " + foundname.orElse("No name found"));
		
	}
	
	public static void main(String[] args)
	{
		pickName(names, "O");
	}
}