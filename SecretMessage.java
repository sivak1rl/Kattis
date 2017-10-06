import java.util.Scanner;

public class SecretMessage
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++)
		{
			String line = sc.nextLine();
			int newlen = (int) Math.ceil(Math.sqrt(line.length()));
			char[][] mat = new char[newlen][newlen];
			while (line.length() < newlen * newlen)
			{
				line += "*";
			}
			int count = 0;
			for (int j = newlen - 1; j > -1; j--)
			{
				for (int k = 0; k < newlen; k++)
				{
					mat[k][j] = line.charAt(count);
					count++;
				}
			}
			for (int j = 0; j < newlen; j++)
			{
				for (int k = 0; k < newlen; k++)
				{
					if (mat[j][k] != '*')
					{
						System.out.print(mat[j][k]);
					}
				}
			}

			System.out.println();
		}
		sc.close();
	}

}
