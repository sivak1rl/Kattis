import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author RSIVAK
 */
public class TouchScreenKeyboard
{

	static String[]	kb	= { "qwertyuiop", "asdfghjkl", "zxcvbnm" };

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int z = 0; z < n; z++)
		{
			String word = sc.next();
			int words = sc.nextInt();
			sc.nextLine();
			ArrayList<Keyword> arr = new ArrayList<Keyword>();
			for (int y = 0; y < words; y++)
			{
				String newWord = sc.nextLine();
				int weight = 0;
				for (int i = 0; i < newWord.length(); i++)
				{
					weight += findWeight(newWord.charAt(i), word.charAt(i));
				}
				arr.add(new Keyword(newWord, weight));
			}
			Collections.sort(arr);
			for (Keyword k : arr)
			{
				System.out.println(k);
			}
		}
		sc.close();
	}

	private static Integer findWeight(char c, char d)
	{
		int weight = 0;
		String cs = c + "", ds = d + "";
		if (kb[0].contains(cs))
		{
			if (kb[0].contains(ds))
			{
				weight += 0;
				weight += Math.abs(kb[0].indexOf(c) - kb[0].indexOf(d));
			}
			else if (kb[1].contains(ds))
			{
				weight += 1;
				weight += Math.abs(kb[0].indexOf(c) - kb[1].indexOf(d));
			}
			else
			{
				weight += 2;
				weight += Math.abs(kb[0].indexOf(c) - kb[2].indexOf(d));
			}
		}
		else if (kb[1].contains(cs))
		{
			if (kb[0].contains(ds))
			{
				weight += 1;
				weight += Math.abs(kb[1].indexOf(c) - kb[0].indexOf(d));
			}
			else if (kb[1].contains(ds))
			{
				weight += 0;
				weight += Math.abs(kb[1].indexOf(c) - kb[1].indexOf(d));
			}
			else
			{
				weight += 1;
				weight += Math.abs(kb[1].indexOf(c) - kb[2].indexOf(d));
			}
		}
		else
		{
			if (kb[0].contains(ds))
			{
				weight += 2;
				weight += Math.abs(kb[2].indexOf(c) - kb[0].indexOf(d));
			}
			else if (kb[1].contains(ds))
			{
				weight += 1;
				weight += Math.abs(kb[2].indexOf(c) - kb[1].indexOf(d));
			}
			else
			{
				weight += 0;
				weight += Math.abs(kb[2].indexOf(c) - kb[2].indexOf(d));
			}
		}
		return weight;
	}
}

class Keyword implements Comparable<Keyword>
{
	String	word;
	Integer	weight;

	public Keyword(String s, int w)
	{
		this.word = s;
		this.weight = w;
	}

	@Override
	public int compareTo(Keyword k2)
	{

		return this.weight.compareTo(k2.weight) != 0 ? this.weight
				.compareTo(k2.weight) : this.word.compareTo(k2.word);

	}

	@Override
	public String toString()
	{
		return this.word + " " + this.weight;
	}
}
