import java.util.Scanner;

public class Stickers {
	static int[] stickers;

	public static void main() {
		Scanner s = new Scanner(System.in);
		int lim = s.nextInt();
		int[] fixed = new int[10];
		s.close();
		s = new Scanner(System.in);
		for (int i = 0; i < lim; i++) {
			String[] strnums = s.nextLine().trim().split(" ");
			stickers = new int[strnums.length];
			for (int x = 0; x < strnums.length; x++) {
				stickers[x] = Integer.parseInt(strnums[x]);
			}
			for (int x = 0; x < stickers.length; x++) {
				fixed[x] = stickers[x];
			}
			int model_num = 1;
			while (checkNumber(model_num, fixed)) {
				model_num++;
			}
			System.out.println(Integer.toString(model_num - 1).length());
		}
		s.close();
	}

	public static boolean checkNumber(int num, int[] fixed) {
		if (num != 1)
			for (int x = 0; x < 10; x++) {
				stickers[x] += fixed[x];
			}
		int[] repeat = new int[10];
		boolean flag = true;
		for (int x = 0; x < stickers.length; x++) {
			int num_length = Integer.toString(num).length();
			int replace_num_length = Integer.toString(num).replace(Integer.toString(x), "").length();
			repeat[x] = num_length - replace_num_length;
		}
		for (int x = 0; x < 10; x++) {
			stickers[x] -= repeat[x];
			if (stickers[x] < 0) {
				flag = false;
			}
		}
		return flag;
	}
}