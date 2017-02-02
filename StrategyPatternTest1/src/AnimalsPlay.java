
public class AnimalsPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal azor = new Dog();
		Animal sroka = new Bird();
		
		azor.setFlyingType(new ItFlys());
		
		System.out.println(azor.tryToFly());
		System.out.println(sroka.tryToFly());

	}

}
