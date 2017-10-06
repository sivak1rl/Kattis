import java.util.Scanner;

public class ls
{
	static String	pattern;

	public static void main(String[] args)
	{
		try (Scanner sc = new Scanner(System.in))
		{
			pattern = sc.nextLine();
			int n = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < n; i++)
			{
				String file = sc.nextLine();
				if (match(file))
				{
					System.out.println(file);
				}
			}
		}
	}

	static boolean match(String file)
	{
		;
		return false;
	}
}
