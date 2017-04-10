package fpij;

public class StaticTest
{
	public static int silnia(int number){
		if(number == 1)
		{
			return number;
		}
		else
		{
			return number * silnia(number-1);
		}
	}

	public static void main(String[] args)
	{
		System.out.println(silnia(50));

	}

}
