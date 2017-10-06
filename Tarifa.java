import java.util.Scanner;

public class Tarifa
{

	public static void main(String[] args)
	{
		try (Scanner sc = new Scanner(System.in))
		{
			long x = sc.nextInt();
			long f = x;
			int n = sc.nextInt();
			for (int i = 0; i < n; i++)
			{
				int p = sc.nextInt();
				f -= p;
				f += x;
			}
			System.out.println(f);
		}
	}

}
