import java.util.Scanner;

public class Shipments {
	public static void main() {
		Scanner s = new Scanner(System.in);
		int lim = s.nextInt();
		for (int i = 0; i < lim; i++) {
			int unit = 0;
			int amt = s.nextInt();
			s = new Scanner(System.in);
			char[] food = s.nextLine().trim().toCharArray();
			for (int x = 0; x < amt; x++) {
				if (x == 0 || x == 1) {
					if (x == 0)
						unit++;
					else if (x == 1 && food[x] == food[x - 1])
						unit++;
					else
						unit += 2;
				} else {
					if (food[x] == food[x - 1]) {
						if (food[x] == food[x - 2])
							unit++;
						else
							unit += 2;
					} else {
						if (food[x] == food[x - 2] || food[x - 1] == food[x - 2])
							unit += 2;
						else
							unit += 3;
					}
				}
			}
			System.out.println("Mine " + (i + 1) + ": " + unit);
		}
		s.close();
	}
}