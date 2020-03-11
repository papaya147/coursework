
/*
This program is for finding a determinant of a matrix
This program uses four functions: main, getArray, getMatrixFromArray and getDeterminant

main():
	gets the users input in a specific format
	gets the information in a desired array format using getArray() method
	gets the matrix form using the getMatrixFromArray() method
	finds the determinant using the findDeterminan() method
	prints the determinant
	
getArray():
	the users input is passed to this function
	the values are then separated by "," and assigned to an array
	the "{" and "}" characters are replaced with "" and assigned to an integer array
	the array is returned
	
getMatrixFromArray():
	the formed array is passed to this function
	a two dimensional array is formed taking the square root of the original array as a length
	the two dimensional array is assigned all the values of the original array
	the two dimensional array is returned
	
getDeterminant():
	the matrix is passed to this method
	if the length of the matrix is 2 then the determinant is found for it and returned
	else a new two dimensional array is created with one less space than the matrix
	a sum variable is created to hold the determinant
	the first row of the original matrix is looped through
		the new matrix is assigned the values of the old matrix excluding the rows and columns of the first row element taken at the moment
		the sum is added with the (-1) to the power of the loop variable multiplied with the first row element multiplied with calling getDeterminant() passing the new matrix
	the sum is returned
	
Sample Input:
	{{6,3,9},{5,7,4},{7,2,1}}
Sample Output:
	Determinant: -288
	
Sample Input:
	{{5,6,3,5},{3,1,4,65},{72,12,11,56},{45,5,2,98}}
Sample Output:
	Determinant: 166867
*/
import java.util.Scanner;

public class Determinant {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter matrix:");
		String input = s.nextLine().trim();

		double array[] = getArray(input);
		double matrix[][] = getMatrixFromArray(array);
		double determinant = getDeterminant(matrix);

		System.out.println("Determinant: " + determinant);

		s.close();
	}

	public static double[] getArray(String input) {
		String elements[] = input.split(",");
		double array[] = new double[elements.length];
		for (int x = 0; x < elements.length; x++)
			array[x] = Integer.parseInt(elements[x].replaceAll("[{,}]", ""));
		return array;
	}

	public static double[][] getMatrixFromArray(double[] array) {
		int dim = (int) Math.sqrt(array.length);
		double[][] matrix = new double[dim][dim];
		int count = 0;
		for (int x = 0; x < dim; x++)
			for (int y = 0; y < dim; y++)
				matrix[x][y] = array[count++];
		return matrix;
	}

	public static double getDeterminant(double[][] matrix) {
		if (matrix.length == 2)
			return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];

		double[][] newmat = new double[matrix.length - 1][matrix.length - 1];
		int sum = 0, ycount = 0;
		for (int x = 0; x < matrix.length; x++) {
			for (int i = 1; i < newmat.length + 1; i++) {
				for (int j = 0; j < matrix.length; j++)
					if (j != x)
						newmat[i - 1][ycount++] = matrix[i][j];
				ycount = 0;
			}
			sum += Math.pow(-1, x) * matrix[0][x] * getDeterminant(newmat);
		}

		return sum;
	}
}
