package finding.my.books;

public class FindingMyBooks
{
	Supplier<Deque<DispRecord>> supplier = ArrayDeque::new;
	
	
	
	BiConsumer<Deque<DispRecord>,Book> accumulator =
			(dqLeft, b) -> {
			int disp = dqLeft.isEmpty() ? 0 :
			dqLeft.getLast().totalDisp();
			dqLeft.add(new DispRecord(b.getTitle(),
			disp,
			Arrays.stream(b.getPageCounts()).sum()));
			};
			
			
			
			BinaryOperator<Deque<DispRecord>> combiner =
					(left, right) -> {
					if (left.isEmpty()) return right;
					int newDisp = left.getLast().totalDisp();
					List<DispRecord> displacedRecords = right.stream()
					.map(dr -> new DispRecord(
					dr.title, dr.disp + newDisp, dr.length))
					.collect(toList());
					left.addAll(displacedRecords);
					return left;
					};
					
			
					
					Function<Deque<DispRecord>,Map<String,Integer>> finisher =
							ddr -> ddr.parallelStream().collect(
							toConcurrentMap(dr -> dr.title, dr -> dr.disp));
							
							
							
							Map<String,Integer> displacementMap = library.stream()
									.collect(Collector.of(supplier, accumulator, combiner, finisher));
			
			
			
	

}
