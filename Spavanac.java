import java.util.Scanner;

public class Spavanac
{

	public static void main(String[] args)
	{
		int h, m;
		try (Scanner sc = new Scanner(System.in))
		{
			h = sc.nextInt();
			m = sc.nextInt();
		}
		if (m < 45)
		{
			--h;
			if (h < 0) {
				h += 24;
			}
			m += 60;
		}
		m -= 45;
		System.out.println(h + " " + m);

	}

}
