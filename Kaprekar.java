
/*
This program takes an input and shows whether its a kaprekar number or not
This program has only one method - main

main():
	takes an input from the user
	the number is squared and converted to a string datatype
	if the length of the squared number is divisible by two
		the squared number is split into two parts - the squared number divided in two halves
		if the two parts add up to the original number
			prints "kaprekar number"
		else
			prints "not a kaprekar number"
	else
		the squared number is split in four parts - the squared number divided in two parts with different middle points
		if the corresponding squared number parts add up to the original number
			prints "kaprekar number"
		else
			prints "not a kaprekar number"
		
Sample Input:
	47
Sample Output:
	Not a Kaprekar number
	
Sample Input:
	99
Sample Output:
	Kaprekar number!
*/
import java.util.Scanner;

public class Kaprekar {
	public static void main() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number: ");
		long num = s.nextInt();
		long numsq = num * num;

		String numsqstr = new String(Long.toString(numsq));

		if (numsqstr.length() % 2 == 0) {
			int part1 = Integer.parseInt(numsqstr.substring(0, numsqstr.length() / 2));
			int part2 = Integer.parseInt(numsqstr.substring(numsqstr.length() / 2));
			if (part1 + part2 == num && part2 != 0) {
				System.out.println("Kaprekar number!");
			} else {
				System.out.println("Not a Kaprekar number");
			}
		} else {
			int part1 = Integer.parseInt(numsqstr.substring(0, numsqstr.length() / 2));
			int part2 = Integer.parseInt(numsqstr.substring(numsqstr.length() / 2));
			int part3 = Integer.parseInt(numsqstr.substring(0, numsqstr.length() / 2 + 1));
			int part4 = Integer.parseInt(numsqstr.substring(numsqstr.length() / 2 + 1));
			if (part1 + part2 == num && part2 != 0) {
				System.out.println("Kaprekar number!");
			} else if (part3 + part4 == num && part4 != 0) {
				System.out.println("Kaprekar number!");
			} else {
				System.out.println("Not a Kaprekar number");
			}
		}
		s.close();
	}
}
