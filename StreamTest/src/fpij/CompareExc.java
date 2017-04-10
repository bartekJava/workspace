package fpij;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CompareExc
{
	public static void printPeople(final String message, final List<Person> people)
	{
		System.out.println(message);
		people.forEach(System.out::println);
	}

	public static void main(String[] args)
	{
		final List<Person> people = Arrays.asList(
				new Person("John", 20), 
				new Person("Sara", 21),
				new Person("Jane", 21), 
				new Person("Greg", 35));

		List<Person> ascendingAge = 
				people.stream().sorted((person1, person2) -> person1.ageDifference(person2))
				.collect(Collectors.toList());
		printPeople("Sorted in ascending order by age: ", ascendingAge);
		
		

		
		

	}

}
