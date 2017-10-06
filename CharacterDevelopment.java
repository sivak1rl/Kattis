import java.math.BigInteger;
import java.util.Scanner;

public class CharacterDevelopment
{
	public static void main(String args[]) throws InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		BigInteger sol = BigInteger.ZERO;
		for (int n = i; n > 1; n--)
		{
			sol = sol.add(binomial(i, n));
		}
		System.out.println(sol);
		sc.close();
	}

	static BigInteger binomial(final int N, final int K)
	{
		BigInteger ret = BigInteger.ONE;
		for (int k = 0; k < K; k++)
		{
			ret = ret.multiply(BigInteger.valueOf(N - k)).divide(
					BigInteger.valueOf(k + 1));
		}
		return ret;
	}

}
