
/*
This program is for identifying digit words
This program has 4 functions: main, loadDigits, checkNumber, checkAllFlags

main():
	takes in the users input and makes it into upper case
	assigns the digits in English to the variable digit using the loadDigits() method
	the word is checked using the checkNumber() method
	
loadDigits():
	the array is manually assigned the values of the numbers
	
checkNumber():
	the word is checked with every number and an array of flags are assigned whether the letters correspond
	the array is checked whether it has all true elements using the checkAllFlags() method
	if all the flags are true then the number is printed as a digit
	else it checks with the next number
	if none of the numbers match then "NO" is printed
	
checkAllFlags():
	takes the check variable as the first flag
	if the flags are not the same false is returned
	the first check variable is returned
	
Sample Input:
	pounce
Sample Output:
	1
	
Sample Input:
	tiger
Sample Output:
	NO
*/
import java.util.Scanner;

public class DigitWords {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter word:");
		String word = s.nextLine().trim().toUpperCase();
		String digit[] = loadDigits();
		checkNumber(digit, word);
		s.close();
	}

	public static String[] loadDigits() {
		String nums[] = new String[10];
		nums[0] = "ZERO";
		nums[1] = "ONE";
		nums[2] = "TWO";
		nums[3] = "THREE";
		nums[4] = "FOUR";
		nums[5] = "FIVE";
		nums[6] = "SIX";
		nums[7] = "SEVEN";
		nums[8] = "EIGHT";
		nums[9] = "NINE";
		return nums;
	}

	public static void checkNumber(String[] digit, String word) {
		boolean total_flag = false;
		for (int x = 0; x < 10; x++) {
			boolean flag[] = new boolean[digit[x].length()];
			int count = 0;
			for (int i = 0; i < word.length(); i++)
				if (word.charAt(i) == digit[x].charAt(count))
					flag[count++] = true;

			if (checkAllFlags(flag)) {
				System.out.println(x);
				total_flag = true;
			}
		}
		if (!total_flag) {
			System.out.println("NO");
		}
	}

	public static boolean checkAllFlags(boolean[] flag) {
		boolean b = flag[0];
		for (int x = 0; x < flag.length; x++) {
			if (flag[x] != b) {
				return false;
			}
		}
		return b;
	}
}
