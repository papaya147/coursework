import java.util.Scanner;

public class Shirts {
	static int min = 100;

	public static void main() {
		Scanner s = new Scanner(System.in);
		String shirts = s.nextLine().trim();
		reorder(shirts, "");
		System.out.println(min);
		s.close();
	}

	public static void reorder(String shirts, String order) {
		if (shirts.equals("1234567")) {
			if (order.length() < min) {
				min = order.length();
			}
		}
		if (endsSame(order)) {
			return;
		}
		reorder(shirts.substring(1, 4) + shirts.charAt(0) + shirts.substring(4, 7), order + "A");
		reorder(shirts.substring(0, 3) + shirts.charAt(6) + shirts.substring(3, 6), order + "B");
		reorder(shirts.charAt(3) + shirts.substring(0, 3) + shirts.substring(4, 7), order + "C");
		reorder(shirts.substring(0, 3) + shirts.substring(4, 7) + shirts.charAt(3), order + "D");
	}

	public static boolean endsSame(String word) {
		int length = word.length();
		if (length < 4) {
			return false;
		} else {
			for (int x = 65; x < 69; x++) {
				int repl_length = word.replace(Character.toString((char) x), "").length();
				if (length - repl_length == 4) {
					return true;
				}
			}
			return false;
		}
	}
}