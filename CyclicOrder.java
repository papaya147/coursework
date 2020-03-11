import java.util.Scanner;

public class CyclicOrder {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of players:");
		int n = s.nextInt();
		System.out.println("Enter turns:");
		int t = s.nextInt();

		char players[] = getPlayers(n);
		int count[] = new int[n];
		int deleted[] = new int[0];
		int x = -1;
		int copyt;
		do {
			copyt = t + x;
			outer: for (int y = x; y < copyt; y++) {
				for (int i = 0; i < deleted.length; i++)
					if ((y + 1) % n == deleted[i]) {
						copyt++;
						x++;
						continue outer;
					}
				count[++x % n]++;
			}

			System.out.println("\n\n------- End of Round -------\n");

			outer: for (int i = 0; i < n; i++) {
				for (int j = 0; j < deleted.length; j++)
					if (i == deleted[j])
						continue outer;
				System.out.print(players[i] + " ");
			}

			System.out.println();

			outer: for (int i = 0; i < n; i++) {
				for (int j = 0; j < deleted.length; j++)
					if (i == deleted[j])
						continue outer;
				System.out.print(count[i] + " ");
			}

			deleted = addDeletedPlayer(deleted, x % n);

			System.out.println(
					"\n\n-------After eliminating player " + players[deleted[deleted.length - 1]] + "-------\n");

			outer: for (int i = 0; i < n; i++) {
				for (int j = 0; j < deleted.length; j++)
					if (i == deleted[j])
						continue outer;
				System.out.print(players[i] + " ");
			}

			System.out.println();

			outer: for (int i = 0; i < n; i++) {
				for (int j = 0; j < deleted.length; j++)
					if (i == deleted[j])
						continue outer;
				System.out.print(count[i] + " ");
			}
		} while (countsEqual(count, deleted));

		System.out.println("\n\n------- End of Game -------");
		s.close();
	}

	public static char[] getPlayers(int n) {
		char[] players = new char[n];
		for (int x = 0; x < n; x++)
			players[x] = (char) ('A' + x);
		return players;
	}

	public static boolean countsEqual(int[] count, int[] deleted) {
		int chk = 0;
		int array[] = new int[count.length - deleted.length];
		outer: for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < deleted.length; j++)
				if (i == deleted[j])
					continue outer;
			array[chk++] = count[i];
		}

		int temp = array[0];
		boolean flag = false;
		for (int x = 0; x < array.length; x++) {
			if (array[x] != temp) {
				flag = true;
			}
		}
		return flag;
	}

	public static int[] addDeletedPlayer(int[] deleted, int index) {
		int newarray[] = new int[deleted.length + 1];
		int x;
		for (x = 0; x < deleted.length; x++)
			newarray[x] = deleted[x];
		newarray[x] = index;
		return newarray;
	}
}