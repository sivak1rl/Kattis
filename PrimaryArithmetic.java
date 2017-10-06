import java.util.Scanner;

public class PrimaryArithmetic
{

	public static void main(String[] args)
	{
		try (Scanner sc = new Scanner(System.in))
		{
			String line;
			while (!(line = sc.nextLine()).equals("0 0"))
			{
				Integer a, b;
				a = new Integer(line.split(" ")[0]);
				b = new Integer(line.split(" ")[1]);
				String as, bs;
				as = String.format("%010d", a);
				bs = String.format("%010d", b);
				as = new StringBuffer(as).reverse().toString();
				bs = new StringBuffer(bs).reverse().toString();
				boolean carry = false;
				int carries = 0;
				for (int i = 0; i < 10; i++)
				{
					int ac = as.charAt(i) - '0', bc = bs.charAt(i) - '0';
					if (carry)
					{
						ac += 1;
					}
					if (ac + bc >= 10)
					{
						++carries;
						carry = true;
					}
					else
					{
						carry = false;
					}
				}
				switch (carries)
				{
					case 0:
						System.out.println("No carry operation.");
						break;
					case 1:
						System.out.println("1 carry operation.");
						break;
					default:
						System.out.println(carries + " carry operations.");
						break;
				}
			}
		}
	}

}
