
/*
This program is a tweaked version of a guessing game
This program has three functions: main, checkWord, getTotalTries

main():
	prints a random number from 3 to 5
	gets the users input with the number of letters expressed in the random number generated
	the word is then checked using checkWord() to make sure no repeated letters exist and checked for the length
	if the word passes both conditions then the user can start guessing
		the total number of tries is decided by the getTotalTries() method
		the users input is taken
		if the user gets the correct word "Congrats! The word is " with the word is displayed
		two variables bullcount and cowcount are created
		if the users input's letters match the original word's letters, the bullcount is incremented
		if the user input's letters exist in the original word, the cowcount is incremented
		the number of bulls and cows is displayed
		the user gets more turns until he/she run out of them
		
checkWord():
	the word is looped through and cross validated for any repetition of a letter
	if there exists a repetition, false is returned, else true
	
getTotalTurns():
	if the word length is 3, 5 is returned
	if the word length is 4, 10 is returned
	if the word length is 5, 15 is returned
	
Sample Input:
	Length: 4
	Enter word: take
Sample Output:
	Guess 1: 
	from
	Bulls: 0, Cows: 0
	Guess 2: 
	boat
	Bulls: 0, Cows: 2
	Guess 3: 
	moat
	Bulls: 0, Cows: 2
	Guess 4: 
	moss
	Bulls: 0, Cows: 0
	Guess 5: 
	bake
	Bulls: 3, Cows: 0
	Guess 6: 
	bike
	Bulls: 2, Cows: 0
	Guess 7: 
	make
	Bulls: 3, Cows: 0
	Guess 8: 
	take
	Congrats! The word is take.
*/
import java.util.Scanner;

public class CowsBulls {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int wordlength = (int) (Math.random() * 3) + 3;
		System.out.println("Length: " + wordlength);

		System.out.println("Enter word: ");
		String word = s.nextLine().trim();

		if (checkWord(word) && word.length() == wordlength) {
			int count = 0;
			while (count < getTotalTries(wordlength)) {
				System.out.println("Guess " + (count + 1) + ": ");
				String guess = s.nextLine().trim();
				if (guess.equals(word)) {
					System.out.println("Congrats! The word is " + word + ".");
					break;
				} else {
					int bullcount = 0, cowcount = 0;
					for (int x = 0; x < word.length(); x++)
						if (word.charAt(x) == guess.charAt(x))
							bullcount++;
					for (int x = 0; x < word.length(); x++)
						for (int y = 0; y < guess.length(); y++)
							if (word.charAt(x) == guess.charAt(y) && x != y)
								cowcount++;
					System.out.println("Bulls: " + bullcount + ", Cows: " + cowcount);
				}
				count++;
			}
		} else
			System.out.println("Invalid Word");

		s.close();
	}

	public static boolean checkWord(String word) {
		boolean flag = true;
		for (int x = 0; x < word.length(); x++)
			for (int y = 0; y < word.length(); y++)
				if (word.charAt(x) == word.charAt(y) && x != y)
					flag = false;
		return flag;
	}

	public static int getTotalTries(int length) {
		switch (length) {
		case 3:
			return 5;
		case 4:
			return 10;
		case 5:
			return 15;
		}
		return 0;
	}
}
