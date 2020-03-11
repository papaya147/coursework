
/*
This program checks whether the number is a bipartite one, if not it will find the lowest multiple of the number that is bipartite
This program also displays the number in its "m s n t" form
This program has 3 methods - main, chkBipartite and reduce

main():
    gets the input from the user
    if the number is bipartite using the chkBipartite() method
        the number is reduced into "m s n t" form using the reduce() method
        the result is printed
    else
    the number is added to the users input and checked for bipartite

chkBipartite():
    an array is created for the number
    's' is taken as the first number in the input
    't' is taken as the last
    if s is equal to t, false is returned
    else
        the start of the number is checked for 's'
        a count variable for 's' is incremented
        when the letter is not 's', the loop is broken
        
        the end of the number is checked for 't'
        a count variable for 't' is incremented
        when the letter is not 't', the loop is broken
    returns the sum of the counts compared to the arrays length (if the sum of the counts = arrays length, returns true, else, false)
    
reduce():
    creates an array for 'm and 'n', which are the counts of 's' and 't' respectively
    creates an array to store the number
    loops through the array of the number
        if the array space is equal to 's'
            the value for 'm' is incremented
        else
            the value for 'n' is incremented
    returns the 'm' and 'n' array
*/
import java.util.Scanner;

public class Bipartite {
	static int s = 0, t = 0;

	public static void main() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number: ");
		long num = s.nextInt();
		long orignum = num;

		while (true)
			if (chkBipartite(num)) {
				System.out.println(num);
				int[] mn = reduce(num);
				System.out.println(mn[0] + " " + s + " " + mn[1] + " " + t);
				break;
			} else
				num += orignum;
		s.close();
	}

	public static boolean chkBipartite(long n) {
		String array[] = Long.toString(n).split("");
		int scount = 0;
		int tcount = 0;
		s = (int) n;
		while (s > 10)
			s /= 10;
		t = (int) n % 10;
		if (s == t)
			return false;
		for (int x = 0; x < array.length; x++)
			if (Integer.parseInt(array[x]) == s)
				scount++;
			else
				break;
		for (int x = array.length - 1; x >= 0; x--)
			if (Integer.parseInt(array[x]) == t)
				tcount++;
			else
				break;
		return tcount + scount == array.length;
	}

	public static int[] reduce(long n) {
		int mn[] = new int[2];
		mn[0] = 0;
		mn[1] = 0;
		String array[] = Long.toString(n).split("");
		for (int x = 0; x < array.length; x++)
			if (Integer.parseInt(array[x]) == s)
				mn[0]++;
			else
				mn[1]++;
		return mn;
	}
}