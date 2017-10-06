import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class TextMessagingOutrage
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 0; i < n; i++)
		{
			int p = sc.nextInt(), k = sc.nextInt(), l = sc.nextInt();
			int[][] pat = new int[k][p];
			LinkedList<Integer> frq = new LinkedList<Integer>();
			for (int j = 0; j < l; j++)
			{
				frq.add(sc.nextInt());
			}
			// Below is a comparator to sort in descending order. That's kind of
			// ugly.
			Collections.sort(frq, (Integer o1, Integer o2) -> o2.compareTo(o1));
			long keys = 0;
			for (int z = 0; z < p && frq.peek() != null; z++)
			{
				for (int y = 0; y < k && frq.peek() != null; y++)
				{
					pat[y][z] = frq.poll();
					keys += pat[y][z]*(z+1);
//pat[y][z] * (z + 1)
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + keys);
		}
		sc.close();
	}
}
