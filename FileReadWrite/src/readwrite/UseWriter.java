package readwrite;

@FunctionalInterface
public interface UseWriter<T, X extends Throwable> {
	void accept(T instance) throws X;
}
