import java.util.Scanner;

public class PrimeSum {
	public static void main() {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		System.out.println(calcPrimeSum(num));
		s.close();
	}

	public static int calcPrimeSum(int num) {
		int count = 0;
		for (int x = 2; x < num / 2 + 1; x++) {
			if (isPrime(x) && isPrime(num - x)) {
				count++;
			}
		}
		return count;
	}

	public static boolean isPrime(int num) {
		for (int x = 2; x < num; x++) {
			if (num % x == 0) {
				return false;
			}
		}
		return true;
	}
}