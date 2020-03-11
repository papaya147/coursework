
/*
This program is to factorise any fraction into Egyptian fractions
This program uses 1 function: main

main():
	takes a fraction from the user
	splits the numerator and denominator
	finds the decimal value of the fraction
	loops while the Egyptian fractions sum is not equal to the decimal value
	x is assigned as 2
	adds 1/x to the sum
	if the sum is greater than the decimal, 1/x is subtracted
	else "1/x" is printed
	x is incremeted
	
Sample Input:
	7/9
Sample Output:
	7/9 = 1/2 + 1/4 + 1/36 
	
Sample Input:
	3/20
Sample Output:
	3/20 = 1/7 + 1/140 
*/
import java.util.Scanner;

public class EgyptianFractions {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter fraction: ");
		String frac[] = s.nextLine().trim().split("/");
		double numer = Double.parseDouble(frac[0]);
		double denom = Double.parseDouble(frac[1]);
		double decimal = numer / denom;

		System.out.print((int) numer + "/" + (int) denom + " = ");

		double sum = 0;
		boolean flag = false;
		double x = 2;
		while (decimal != sum) {
			sum += 1 / x;
			if (sum > decimal) {
				sum -= 1 / x;
			} else {
				if (flag)
					System.out.print("+ 1/" + (int) x + " ");
				else {
					flag = true;
					System.out.print("1/" + (int) x + " ");
				}
			}
			x++;
		}
		s.close();
	}
}
