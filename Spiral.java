
/*
This program prints a spiral matrix with a given input, the center being the number squared
This program has only one method: main

main():
    gets the users input and stores its square
    makes an aray to store all the numbers
    the value starts at 1
    two variables x and y are made to store the current index
    loops while the number to be stored in the array is lesser or equal to the input squared
        if the array space has no element, the value is stored
        the value is incremented
        y is incremented
        if the y is greater than the width, the index is decremented
    loops while the number to be stored in the array is lesser or equal to the input squared
        if the array space has no element, the value is stored
        the value is incremented
        x is incremented
        if the x is greater than the height, the index is decremented
    loops while the number to be stored in the array is lesser or equal to the input squared
        if the array space has no element, the value is stored
        the value is incremented
        y is decremented
        if the y is lesser than 0, the index is incremented
    loops while the number to be stored in the array is lesser or equal to the input squared
        if the array space has no element, the value is stored
        the value is incremented
        x is decremented
        if the x is lesser than 0, the index is incremented
    
    the array is printed with a formatting
    
Sample Input:
    8
Sample Output:
    01 02 03 04 05 06 07 08 
    28 29 30 31 32 33 34 09 
    27 48 49 50 51 52 35 10 
    26 47 60 61 62 53 36 11 
    25 46 59 64 63 54 37 12 
    24 45 58 57 56 55 38 13 
    23 44 43 42 41 40 39 14 
    22 21 20 19 18 17 16 15 
    
Sample Input:
    9
Sample Output:
    01 02 03 04 05 06 07 08 09 
    32 33 34 35 36 37 38 39 10 
    31 56 57 58 59 60 61 40 11 
    30 55 72 73 74 75 62 41 12 
    29 54 71 80 81 76 63 42 13 
    28 53 70 79 78 77 64 43 14 
    27 52 69 68 67 66 65 44 15 
    26 51 50 49 48 47 46 45 16 
    25 24 23 22 21 20 19 18 17 
*/
import java.util.*;

public class Spiral {
	public static void main() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of rows:");
		int rows = s.nextInt();
		int num[][] = new int[rows][rows];
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < rows; y++) {
				num[x][y] = 0;
			}
		}

		int value = 1;
		int x = 0, y = 0;
		int rows2 = rows * rows;

		while (value <= rows2) {
			while (y < rows) {
				if (num[x][y] == 0) {
					num[x][y] = value;
					value++;
				}
				y++;
				try {
					if (num[x][y] != 0) {
						y--;
						break;
					}
				} catch (Exception e) {
				}
			}

			if (y == rows)
				y = rows - 1;

			while (x < rows) {
				if (num[x][y] == 0) {
					num[x][y] = value;
					value++;
				}
				x++;
				try {
					if (num[x][y] != 0) {
						x--;
						break;
					}
				} catch (Exception e) {
				}
			}

			if (x == rows)
				x = rows - 1;

			while (y >= 0) {
				if (num[x][y] == 0) {
					num[x][y] = value;
					value++;
				}
				y--;
				try {
					if (num[x][y] != 0) {
						y++;
						break;
					}
				} catch (Exception e) {
				}
			}

			if (y == -1)
				y++;

			while (x >= 0) {
				if (num[x][y] == 0) {
					num[x][y] = value;
					value++;
				}
				x--;
				try {
					if (num[x][y] != 0) {
						x++;
						break;
					}
				} catch (Exception e) {
				}
			}

			if (x == -1)
				x++;

			rows--;
		}

		for (int i = 0; i < Math.sqrt(rows2); i++) {
			for (int j = 0; j < Math.sqrt(rows2); j++) {
				System.out.printf("%02d ", num[i][j]);
			}
			System.out.println();
		}
		s.close();
	}
}