
/*
This program is to decrypt a message that the user enters
This program uses 3 functions: main, decode and loseQQ

main():
	gets the users input
	get the shift value from the user
	decodes the message using decode() method
	prints the decoded message with replacing all 'QQ' with ''
	
decode():
	the encrypted message is passed
	all of the spaces are replaced with ""
	the message is looped through
		if the character at a given position added with the shift is lesser than 'Z'
			the character plus the shift is added to the final decrypted message
		else the character plus the shift's remainder with 91 ('Z'+1) is found
			the remainder plus 'A' is added to the final message
	the decrypted message is returned
	
Sample Input:
	UHINBY LKKQCH HYLKK
	shift: 7
Sample Output:
	ANOTHER WINNER
	
Sample Input:
	RUIJGG EVGGBK SAGG
	shift: 11
Sample Output:
	BEST OF LUCK
*/
import java.util.Scanner;

public class Encryption {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter input:  ");
		String input = s.nextLine().trim();
		System.out.println("Enter shift: ");
		int shift = s.nextInt();

		String decoded = decode(input, shift);
		System.out.println("Decoded message: " + decoded.replaceAll("QQ", " "));

		s.close();
	}

	public static String decode(String text, int shift) {
		String decoded = "";
		text = text.replaceAll(" ", "");
		for (int x = 0; x < text.length(); x++) {
			if (text.charAt(x) + shift - 1 <= 'Z')
				decoded += (char) (text.charAt(x) + shift - 1);
			else {
				int temp = ((int) text.charAt(x) + shift - 1) % 91;
				decoded += (char) ('A' + temp);
			}
		}
		return decoded;
	}
}
