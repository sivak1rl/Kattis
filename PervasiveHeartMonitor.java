import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PervasiveHeartMonitor
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder line = new StringBuilder();
		ArrayList<Person> people = new ArrayList<Person>();
		int count = 0;
		Pattern namePattern = Pattern.compile("([a-zA-Z]+\\s?)+");
		Pattern numPattern = Pattern.compile("[0-9]+\\.?[0-9]*");
		String name = "";
		while (sc.hasNextLine())
		{
			line = new StringBuilder(sc.nextLine());
			Matcher nameMatcher = namePattern.matcher(line);
			Matcher numMatcher = numPattern.matcher(line);
			while (nameMatcher.find())
			{
				name += nameMatcher.group() + " ";
			}
			name.trim();
			double[] heartRates = new double[25];
			while (numMatcher.find())
			{
				heartRates[count++] = Double.parseDouble(numMatcher.group());
			}
			people.add(new Person(name, heartRates, count));
			name = new String();
			count = 0;
		}
		for (Person p : people)
		{
			System.out.println(p.toString());
		}
		sc.close();
	}

	/**
	 * @param numbers
	 *            The list of numbers to average
	 * @param count
	 *            The logical size of the array <code>numbers</code>
	 * @return The average of <code>numbers</code>
	 */
	public static double calcAverage(double[] numbers, int count)
	{
		double sum = 0;
		for (int i = 0; i < count; i++)
		{
			sum += numbers[i];
		}
		return sum / count;
	}
}

class Person
{
	private String	name;
	private double	heartRate;

	public Person(String name, double[] heartRates, int count)
	{
		this.name = name;
		this.heartRate = PervasiveHeartMonitor.calcAverage(heartRates, count);
	}

	public String getName()
	{
		return this.name;
	}

	public double getHeartRate()
	{
		return this.heartRate;
	}

	@Override
	public String toString()
	{
		return String.format("%.6f %s", this.heartRate, this.name);
	}
}
