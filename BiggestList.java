import java.util.Scanner;

public class BiggestList {
	static Scanner s = new Scanner(System.in);

	public static void main() {
		int sets = s.nextInt();
		int[] numbers = null, counts = null;
		for (int i = 0; i < sets; i++) {
			numbers = getInput();
			counts = new int[numbers.length];
			System.out.print("Case " + (i + 1) + ":");
			for (int x = 0; x < numbers.length; x++) {
				counts[x] = getCount(x, numbers);
			}
			int max = 0;
			for (int x = 0; x < counts.length; x++) {
				if (counts[x] > max) {
					max = counts[x];
				}
			}
			System.out.println(max);
			System.out.println();
		}
	}

	public static int[] getInput() {
		int[] nums = new int[s.nextInt()];
		s = new Scanner(System.in);
		String line = s.nextLine().trim();
		String[] strnums = line.split(" ");
		for (int x = 0; x < strnums.length; x++) {
			try {
				nums[x] = Integer.parseInt(strnums[x]);
			} catch (Exception e) {
				System.err.println("Invalid Input");
			}
		}
		s.close();
		return nums;
	}

	public static int getCount(int start, int[] numbers) {
		int count = 0;
		int node = numbers[start];
		while (node != -1) {
			count++;
			if (count > 1000) {
				return 0;
			}
			try {
				node = numbers[node];
			} catch (Exception e) {
				System.err.println("Invalid input");
			}
		}
		return count + 1;
	}
}