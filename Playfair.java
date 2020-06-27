import java.util.Scanner;

public class Playfair {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 'E' to encode.");
			System.out.println("Enter 'D' to dencode.");
			System.out.println("Enter 'Q' to quit.");
			char option = s.nextLine().trim().toUpperCase().charAt(0);

			if (option == 'E') {
				System.out.print("Enter keyword 1: ");
				String key1 = s.nextLine().trim().toUpperCase();
				char[][] mat1 = createFrontMatrix(key1);

				System.out.print("Enter keyword 2: ");
				String key2 = s.nextLine().trim().toUpperCase();
				char[][] mat2 = createBackMatrix(key2);

				System.out.println("Enter word to encode: ");
				String word = s.nextLine().trim().toUpperCase();
				if (word.length() % 2 == 1) {
					word = word.concat("X");
				}

				String encoded = encode(mat1, mat2, word);
				System.out.println("Encoded text: " + encoded + "\n");
			} else if (option == 'D') {
				System.out.print("Enter keyword 1: ");
				String key1 = s.nextLine().trim().toUpperCase();
				char[][] mat1 = createFrontMatrix(key1);

				System.out.print("Enter keyword 2: ");
				String key2 = s.nextLine().trim().toUpperCase();
				char[][] mat2 = createBackMatrix(key2);

				System.out.println("Enter text to decode: ");
				String word = s.nextLine().trim().toUpperCase();

				String decoded = encode(mat1, mat2, word);
				if (decoded.endsWith("X")) {
					decoded = decoded.substring(0, decoded.length() - 1);
				}
				System.out.println("Decoded word: " + decoded + "\n");
			} else if (option == 'Q') {
				break;
			} else
				System.out.println("Invalid Input");
		}
		s.close();
	}

	public static char[][] createFrontMatrix(String word) {
		char[][] matrix = new char[5][5];
		char curr_letter = 'A';
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if (word.equals("")) {
					if (letterUsed(matrix, curr_letter) || curr_letter == 'Q') {
						y--;
						curr_letter++;
						continue;
					}
					matrix[x][y] = curr_letter;
					curr_letter++;
				} else {
					char temp = word.charAt(0);
					if (letterUsed(matrix, temp)) {
						y--;
						word = word.substring(1);
						continue;
					}
					matrix[x][y] = temp;
					word = word.substring(1);
				}
			}
		}
		return matrix;
	}

	public static char[][] createBackMatrix(String word) {
		char[][] matrix = new char[5][5];
		char curr_letter = 'A';
		for (int x = 4; x >= 0; x--) {
			for (int y = 4; y >= 0; y--) {
				if (word.equals("")) {
					if (letterUsed(matrix, curr_letter) || curr_letter == 'Q') {
						y++;
						curr_letter++;
						continue;
					}
					matrix[x][y] = curr_letter;
					curr_letter++;
				} else {
					char temp = word.charAt(0);
					if (letterUsed(matrix, temp)) {
						y++;
						word = word.substring(1);
						continue;
					}
					matrix[x][y] = temp;
					word = word.substring(1);
				}
			}
		}
		return matrix;
	}

	public static boolean letterUsed(char[][] matrix, char letter) {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if (matrix[x][y] == letter) {
					return true;
				}
			}
		}
		return false;
	}

	public static String encode(char[][] mat1, char[][] mat2, String word) {
		String code = "";
		while (word.length() != 0) {
			int letter1_x = 0, letter1_y = 0, letter2_x = 0, letter2_y = 0;

			for (int x = 0; x < 5; x++) {
				for (int y = 0; y < 5; y++) {
					if (mat1[x][y] == word.charAt(0)) {
						letter1_x = x;
						letter1_y = y;
					}
					if (mat2[x][y] == word.charAt(1)) {
						letter2_x = x;
						letter2_y = y;
					}
				}
			}
			word = word.substring(2);

			char new_letter1 = mat1[letter2_x][letter1_y];
			char new_letter2 = mat2[letter1_x][letter2_y];
			code = code.concat(Character.toString(new_letter1));
			code = code.concat(Character.toString(new_letter2));
		}
		return code;
	}
}