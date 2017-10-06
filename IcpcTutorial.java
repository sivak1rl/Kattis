import java.util.Scanner;

public class IcpcTutorial
{

	public static void main(String[] args)
	{
		try (Scanner sc = new Scanner(System.in))
		{
			int m = sc.nextInt(), n = sc.nextInt(), t = sc.nextInt();
			boolean exc = false;
			switch (t)
			{
				case 1:
					if (fact(n) > m)
					{
						exc = true;
					}
					break;
				case 2:
					if (Math.pow(2, n) < 0)
					{
						exc = true;
					}
					else if (Math.pow(2, n) > m)
					{
						exc = true;
					}
					break;
				case 3:
					if (Math.pow(n, 4) > m)
					{
						exc = true;
					}
					break;
				case 4:
					if (Math.pow(n, 3) > m)
					{
						exc = true;
					}
					break;
				case 5:
					if (Math.pow(n, 2) > m)
					{
						exc = true;
					}
					break;
				case 6:
					if (n * (Math.log(n) / Math.log(2)) > m)
					{
						exc = true;
					}
					break;
				case 7:
					if (n > m)
					{
						exc = true;
					}
					break;
				default:
					break;
			}
			System.out.println(exc ? "TLE" : "AC");
		}
	}

	static int fact(int i)
	{
		return i >= 13 ? Integer.MAX_VALUE : i <= 1 ? 1 : i * fact(i - 1);
	}

}
