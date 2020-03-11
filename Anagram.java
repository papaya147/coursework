import java.util.Scanner;

public class Anagram {
	public static void main() {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		boolean flag = false;
		for (int x = 2; x < 10; x++)
			if (checkAnagram(num, x)) {
				flag = true;
				System.out.print(x + " ");
			}
		if (!flag)
			System.out.println("NO");
		s.close();
	}

	public static boolean checkAnagram(int num, int mul) {
		int ana = num * mul;
		int[] num_array = new int[10], ana_array = new int[10];
		while (num != 0) {
			int temp = num % 10;
			num /= 10;
			num_array[temp]++;
		}
		while (ana != 0) {
			int temp = ana % 10;
			ana /= 10;
			ana_array[temp]++;
		}

		for (int x = 0; x < 10; x++)
			if (num_array[x] != ana_array[x])
				return false;
		return true;
	}
}
