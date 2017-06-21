package patterns.singleton;

public class SingletonOCP {

	private static volatile SingletonOCP instance;

	public static SingletonOCP getInstance() {
		if (instance == null) {
			synchronized (SingletonOCP.class) {
				if (instance == null) {
					instance = new SingletonOCP();
				}
			}
		}
		return instance;
	}

}
