import java.util.HashMap;
import java.util.Scanner;

public class Babelfish
{

	public static void main(String[] args)
	{
		try (Scanner sc = new Scanner(System.in))
		{
			String line;
			HashMap<String, String> dict = new HashMap<String, String>();
			while (!(line = sc.nextLine()).equals(""))
			{
				dict.put(line.split(" ")[1], line.split(" ")[0]);
			}
			while(sc.hasNext()) {
				line = sc.nextLine();
				if(dict.containsKey(line)) {
					System.out.println(dict.get(line)); 
				} else {
					System.out.println("eh");
				}
			}
		}
	}

}
