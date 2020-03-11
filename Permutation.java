
/*
This program takes letters and gives all possible permutations for it
This programs has two methods: main and permute

main():
    takes the letters from the user and stores it in a character array
    calls permute and passes the letters
    
permute():
    takes two inputs - x and n - the two indexes to switch in the array
    if n is equal to the array's length
        prints the array in a string format
        returns back
    switches the values of the array
    calls the permute() function again passing x and (n+1)
    switches the values of the array back to the original

Sample Input:
    abcd
Sample Output:
    abcd
    abdc
    acbd
    acdb
    adcb
    adbc
    bacd
    badc
    bcad
    bcda
    bdca
    bdac
    cbad
    cbda
    cabd
    cadb
    cdab
    cdba
    dbca
    dbac
    dcba
    dcab
    dacb
    dabc
*/
import java.util.Scanner;

public class Permutation {
	static char lets[];
	static char copy[];

	public static void main() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter letters: ");
		lets = s.nextLine().trim().toCharArray();
		copy = lets;

		permute(0, 0);
		s.close();
	}

	public static void permute(int x, int n) {
		if (n == lets.length) {
			System.out.println(String.valueOf(lets));
			return;
		}
		for (x = n; x < lets.length; x++) {
			char temp = lets[x];
			lets[x] = lets[n];
			lets[n] = temp;

			permute(x, n + 1);

			temp = lets[x];
			lets[x] = lets[n];
			lets[n] = temp;
		}
	}
}