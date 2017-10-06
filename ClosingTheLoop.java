import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Passed
 * 
 * @author RSIVAK
 */
public class ClosingTheLoop
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int z = 1; z <= n; z++)
		{
			int length = 0;
			int s = sc.nextInt();
			sc.nextLine();
			if (s == 1)
			{
				sc.nextLine();
				println("Case #" + z + ": 0");
				continue;
			}

			LinkedList<Integer> reds = new LinkedList<Integer>();
			LinkedList<Integer> blue = new LinkedList<Integer>();
			for (int y = 0; y < s; y++)
			{
				String part = sc.next();
				if (part.charAt(part.length() - 1) == 'R')
				{
					reds.add(new Integer(part.substring(0, part.length() - 1)));
				}
				else
				{
					blue.add(new Integer(part.substring(0, part.length() - 1)));
				}
			}
			Collections.sort(reds, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2)
				{
					return o2.compareTo(o1);
				}
			});
			Collections.sort(blue, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2)
				{
					return o2.compareTo(o1);
				}
			});
			length += (reds.poll() + blue.poll()) - 1;
			boolean rednext = reds.size() <= blue.size();
			while (rednext && !reds.isEmpty() || !rednext && !blue.isEmpty())
			{
				length += rednext ? reds.poll() : blue.poll();
				--length;
				rednext = !rednext;
			}
			length -= 1;
			println("Case #" + z + ": " + length);
		}

		sc.close();
	}

	private static <E> void println(E e)
	{
		System.out.println(e);
	}

}
