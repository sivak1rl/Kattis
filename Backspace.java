import java.util.Scanner;

public class Backspace
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder out = new StringBuilder();
		String in = sc.nextLine();
		for (int i = 0; i < in.length(); i++)
		{
			if (in.charAt(i) != '<')
			{
				out.append(in.charAt(i));
			}
			else
			{
				out.deleteCharAt(out.length() - 1);
			}
		}
		System.out.println(out);
		sc.close();
	}

}
