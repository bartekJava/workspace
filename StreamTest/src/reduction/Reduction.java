package reduction;

import java.util.stream.IntStream;

public class Reduction
{
	public static void main(String[] args){
		
		int sumResult = IntStream.of(1,2,3)
				.sum();
		
		
//		If the convenience method sum were not available, we could write code using the second overload of reduce:
		int sum = IntStream.of(1,2,3)
		.reduce(0, (a, b) -> a + b);
		
		
//		New functions can be similarly defined: for example,
//		the following code computes the factorial of a variable intArg:
		int intArgFactorial = IntStream.rangeClosed(1, intArg)
		.reduce(1, (a, b) -> a * b);
		
		
		Stream<BigInteger> biStream = LongStream.of(1,2,3)
				.mapToObj(BigInteger::valueOf);
				Optional<BigInteger> bigIntegerSum = biStream
				.reduce(BigInteger::add);
		
		
				
//		total number of volumes in library:
		int totalVolumes = library.stream()
				.reduce(0,
				(sum, book) -> sum + book.getPageCounts().length,
				Integer::sum);
//		or:
		int totalVolumes = library.stream()
				.mapToInt(b -> b.getPageCounts().length)
				.sum();
		

	}

}
