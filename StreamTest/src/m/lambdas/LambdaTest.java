package m.lambdas;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaTest
{
	public static void main(String[] args){
		
		List<Integer> integerList = null;
		
		int sum = integerList.stream()
				.mapToInt(Integer::intValue)
				.sum();
		
		
		OptionalInt max = IntStream.rangeClosed(1,5)
				.map(i -> i + 1)
				.max();
		
		
		
//		Examples of Stream Processing
		
//		A stream that contains only computing books:
		Stream<Book> computingBooks = library.stream()
		.filter(b -> b.getTopic() == COMPUTING);
		
//		A stream of book titles:
		Stream <String> bookTitles = library.stream()
		.map(Book::getTitle);
		
//		A stream of Book, sorted by title:
		Stream<Book> booksSortedByTitle = library.stream()
		.sorted(Comparator.comparing(Book::getTitle));
		
//		Use this sorted stream to create a stream of authors, in order of book title,
//		with duplicates removed:
		Stream<String> authorsInBookTitleOrder = library.stream()
		.sorted(Comparator.comparing(Book::getTitle))
		.flatMap(book -> book.getAuthors().stream())
		.distinct();
		
//		A stream yielding the 􀃥rst 100 books in alphabetical order of title:
		Stream<Book> readingList = library.stream()
		.sorted(Comparator.comparing(Book::getTitle))
		.limit(100);
		
//		A stream with the rest:
		Stream<Book> remainderList = library.stream()
		.sorted(Comparator.comparing(Book::getTitle))
		.skip(100);
		
//		The earliest-published book in my library:
		Optional<Book> oldest = library.stream()
		.min(Comparator.comparing(Book::getPubDate));
		
//		The set of titles of the books in my library:
		Set<String> titles = library.stream()
		.map(Book::getTitle)
		.collect(Collectors.toSet());
		
		
		int totalAuthorships = library.stream()
				.mapToInt(b -> b.getAuthors().size())
				.sum();
		
		
		Stream<String> authorStream = library.stream()
				.flatMap(b -> b.getAuthors().stream());
		
		
		int totalPageCount = library.stream()
				.flatMapToInt(b -> IntStream.of(b.getPageCounts()))
				.sum();
		
		
		Stream<Book> booksSortedByTitle = library.stream()
				.sorted(Comparator.comparing(Book::getTitle));
		
		
		Stream<Book> booksSortedByAuthorCount = library.stream()
				.sorted(Comparator.comparing(Book::getAuthors,
				Comparator.comparing(List::size)));
		
		
		Stream<String> authorsInBookTitleOrder = library.stream()
				.sorted(Comparator.comparing(Book::getTitle))
				.flatMap(book -> book.getAuthors().stream())
				.distinct();
		
		
		Stream<Book> readingList = library.stream()
				.sorted(Comparator.comparing(Book::getTitle))
				.limit(100);
		
		
		Stream<Book> remainderList = library.stream()
				.sorted(Comparator.comparing(Book::getTitle))
				.skip(100);
		
		
		boolean withinShelfHeight = library.stream()
				.filter(b -> b.getTopic() == HISTORY)
				.allMatch(b -> b.getHeight() < 19);
		
		
		Optional<Book> anyBook = library.stream()
				.filter(b -> b.getAuthors().contains("Herman Melville"))
				.findAny();
		
		
		BufferedReader br = new BufferedReader(new FileReader("Mastering.tex"));
		Optional<String> line = br.lines()
		.filter(s -> s.contains("findFirst"))
		.findFirst();
		
		
		IntSummaryStatistics pageCountStatistics = library.stream()
				.mapToInt(b -> IntStream.of(b.getPageCounts()).sum())
				.summaryStatistics();
				System.out.println(pageCountStatistics);
				
				
		Optional<Book> oldest = library.stream()
		.min(Comparator.comparing(Book::getPubDate));
		
		
		Optional<String> firstTitle = library.stream()
				.map(Book::getTitle)
				.min(Comparator.naturalOrder());
		
		
		Optional<String> firstTitle = library.stream()
				.map(Book::getTitle)
				.min(Comparator.reverseOrder());
		
		
		Set<String> titles = library.stream()
				.map(Book::getTitle)
				.collect(Collectors.toSet());
		
		
		Map<String,Year> titleToPubDate = library.stream()
				.collect(toMap(Book::getTitle, Book::getPubDate));
		
		
		Map<String,Year> titleToPubDate = library.stream()
				.collect(toMap(Book::getTitle,
				Book::getPubDate,
				(x, y) -> x.isAfter(y) ? x : y));
		
		
		int totalPageCount = library.stream()
				.mapToInt(Book::getPageCount)
				.sum();
		
		
//		A map classifying books by topic:
			Map<Topic,List<Book>> booksByTopic = library.stream()
			.collect(groupingBy(Book::getTopic));
			
//			An ordered map from book titles to publication date of latest edition:
			Map<String,Year> titleToPubDate = library.stream()
			.collect(toMap(Book::getTitle,
			Book::getPubDate,
			BinaryOperator.maxBy(naturalOrder()),
			TreeMap::new));
			
//			A map partitioning books into 􀃥ction (mapped to true) and non-􀃥ction ( false):
			Map<Boolean,List<Book>> fictionOrNon = library.stream()
			.collect(partitioningBy(b -> b.getTopic() == FICTION));
			
//			A map associating each topic with the book on that topic having the most authors:
			Map<Topic,Optional<Book>> mostAuthorsByTopic = library.stream()
			.collect(groupingBy(Book::getTopic,
			maxBy(comparing(b -> b.getAuthors().size()))));
			
//			A map associating each topic with the total number of volumes on that topic:
			Map<Topic,Integer> volumeCountByTopic = library.stream()
			.collect(groupingBy(Book::getTopic,
			summingInt(b -> b.getPageCounts().length)));
			
//			The topic with the most books:
			Optional<Topic> mostPopularTopic = library.stream()
			.collect(groupingBy(Book::getTopic, counting()))
			.entrySet().stream()
			.max(Map.Entry.comparingByValue())
			.map(Map.Entry::getKey);
			
//			A map from each topic to the concatenation of all the book titles on that topic:
			Map<Topic,String> concatenatedTitlesByTopic = library.stream()
			.collect(groupingBy(Book::getTopic,
			mapping(Book::getTitle, joining(";"))));
			
			
			String concatenatedTitles = library.stream()
					.map(Book::getTitle)
					.collect(joining("::"));
			
			
//			list of strings, each containing all the authors’
//			names for a single book:
			List<String> authorsForBooks = library.stream()
			.map(b -> b.getAuthors().stream()
			.collect(joining(", ", b.getTitle() + ": ", "")))
			.collect(toList());
			
			
			Map<String,Year> titleToPubDate = library.stream()
					.collect(toMap(Book::getTitle,
					Book::getPubDate,
					(x, y) -> x.isAfter(y) ? x : y,
					TreeMap::new));
			
			
			NavigableSet<String> sortedTitles = library.stream()
					.map(Book::getTitle)
					.collect(toCollection(TreeSet::new));
			
			
			BlockingQueue<Book> queueInPubDateOrder = library.stream()
					.sorted(Comparator.comparing(Book::getPubDate))
					.collect(toCollection(LinkedBlockingQueue::new));
			
			
			Map<Topic,List<Book>> booksByTopic = library.stream()
					.collect(groupingBy(Book::getTopic));
			
			
//			this code would map true to a list of my fction books and false
//			to a list of the non-fction ones:
			Map<Boolean,List<Book>> fictionOrNonFiction = library.stream()
			.collect(partitioningBy(b -> b.getTopic() == FICTION ||
			b.getTopic() == SCIENCE_FICTION));
			
			
			Map<Topic,Long> distributionByTopic = library.stream()
					.collect(groupingBy(Book::getTopic, Collectors.counting()));
			
			
//			mapping
//			that would contain, for each topic, the book with the greatest number of authors:
			Map<Topic,Optional<Book>> mostAuthorsByTopic = library.stream()
			.collect(groupingBy(Book::getTopic,
			maxBy(comparing(b -> b.getAuthors().size()))));
			
			
			Map<Topic,Integer> volumeCountByTopic = library.stream()
					.collect(groupingBy(Book::getTopic,
					summingInt(b -> b.getPageCounts().length)));
			
			
			Map<Topic,Double> averageHeightByTopic = library.stream()
					.collect(groupingBy(Book::getTopic,
					averagingDouble(Book::getHeight)));
			
			
			Map<Topic,IntSummaryStatistics> volumeStats = library.stream()
					.collect(groupingBy(Book::getTopic,
					summarizingInt(b -> b.getPageCounts().length)));
			
			
			Map<Topic,String> concatenatedTitlesByTopic = library.stream()
					.collect(groupingBy(Book::getTopic,
					mapping(Book::getTitle, joining(";"))));
			
			
			
			
			
//			Finding the most popular topic in library—that is, the
//			one with the greatest number of books.
			Stream<Map.Entry<Topic,Long>> entries = library.stream()
					.collect(groupingBy(Book::getTopic, counting()))
					.entrySet().stream();
			
			Optional<Topic> mostPopularTopic = entries
					.max(Map.Entry.comparingByValue())
					.map(Map.Entry::getKey);
			
//			We can imitate the fluent style of pipeline processing by chaining the two pipelines
//			together:
			Optional<Topic> mostPopularTopic = library.stream()
			.collect(groupingBy(Book::getTopic, counting()))
			.entrySet().stream()
			.max(Map.Entry.comparingByValue())
			.map(Map.Entry::getKey);
			
			
//			the code to find the most popular topics is:
				Optional<Set<Topic>> mostPopularTopics = library.stream()
				.collect(groupingBy(Book::getTopic, counting()))
				.entrySet().stream()
				.collect(groupingBy(Map.Entry::getValue,
				mapping(Map.Entry::getKey, toSet())))
				.entrySet().stream()
				.max(Map.Entry.comparingByKey())
				.map(Map.Entry::getValue);
				
				
		
			List<String> titles = library.stream()
					.map(Book::getTitle)
					.collect(collectingAndThen(toList(),
					Collections::unmodifiableList));
			
			
//			stream of strings, each
//			containing all the authors’ names for a single book:
			Stream<String> concatenatedAuthors = library.stream()
			.map(b -> b.getAuthors().stream().collect(joining()));
			
			
//			a mapping from each
//			letter to the concatenation of all book titles beginning with that letter:
			Map<Character, String> collect1 = library.stream()
			.map(Book::getTitle)
			.collect(groupingBy(t -> t.charAt(0), joining(";")));
			
			
			Comparator<Book> htComparator = Comparator.comparing(Book::getHeight);
			Map<Topic,Optional<Book>> maxHeightByTopic = library.stream()
			.collect(groupingBy(Book::getTopic,
			reducing(BinaryOperator.maxBy(htComparator))));
			
			
//			number of volumes in each topic of the library:
			Map<Topic,Integer> volumesByTopic = library.stream()
			.collect(groupingBy(Book::getTopic,
			reducing(0, b -> b.getPageCounts().length, Integer::sum)));
			
			
			
			
//			simulation of indexed streams:
//				output:
//				Fundamentals of Chinese Fingernail Image: 1:256
//				Compilers: Principles, Techniques and Tools: 1:1009
//				Voss: 1:478
//				Lord of the Rings: 1:531, 2:416, 3:624
			library.stream()
			.map(book -> {
			int[] volumes = book.getPageCounts();
			return
			IntStream.rangeClosed(1, volumes.length)
			.mapToObj(i -> i + ":" + volumes[i - 1])
			.collect(joining(", ", book.getTitle() + ": ", ""));
			})
			.forEach(System.out::println);
			
			
			
			PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("**/test*.txt");
			
			
			
			
			Predicate tolkien = b -> b.getAuthors().contains("Tolkien");
			Predicate lotr = b -> b.getTitle().contains("Lord");
			Predicate old = b -> b.getPubDate().isBefore(Year.of(1960));
			boolean firstLotrEdn = library.stream()
			.filter(tolkien.and(lotr).and(old))
			.findAny().isPresent();
			
			
			

	}

}
