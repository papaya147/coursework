
/*
This program finds the difference between two dates
This program uses 3 functions: main, find365 and getMonthList

main():
	gets the users input of two dates
	finds the 365 values for their respective months and dates using the find365() method
	if the difference in days is negative, the sign is taken out
	a loop runs to add days if a leap year happens
	for every year in difference 365 days are added
	the result is printed
	
find365():
	a month list is loaded using the getMonthList() method
	a loop adds the month's days and finally the date itself to get a total number within 365
	the sum is returned
	
getMonthList():
	an array is manually typed with the number of days within each month and returned
	
Sample Input:
	30/12/2001
	18/4/2019
Sample Output:
	6830 days
	
Sample Input:
	10/1/1975
	30/12/2001
Sample Output:
	9851 days
*/
import java.util.Scanner;

public class DateDifference {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter date: ");
		String date1[] = s.nextLine().trim().split("/");
		System.out.println("Enter another date:");
		String date2[] = s.nextLine().trim().split("/");

		int day1_365 = find365(date1[0], date1[1]);
		int day2_365 = find365(date2[0], date2[1]);

		int day_diff = day1_365 - day2_365;
		day_diff = day_diff > 0 ? day_diff : -day_diff;

		int lower_year = Integer.parseInt(date1[2]) < Integer.parseInt(date2[2]) ? Integer.parseInt(date1[2])
				: Integer.parseInt(date2[2]);
		int upper_year = Integer.parseInt(date1[2]) > Integer.parseInt(date2[2]) ? Integer.parseInt(date1[2])
				: Integer.parseInt(date2[2]);

		for (int x = lower_year; x < upper_year; x++) {
			if (x % 4 == 0) {
				day_diff++;
			}
			day_diff += 365;
		}
		System.out.println(day_diff + " days");
		s.close();
	}

	public static int find365(String day, String month) {
		int d = Integer.parseInt(day);
		int m = Integer.parseInt(month);

		int days_in_month[] = getMonthList();
		int sum = 0;
		for (int x = 0; x < m - 1; x++)
			sum += days_in_month[x];

		return sum + d;
	}

	public static int[] getMonthList() {
		int months[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		return months;
	}
}
