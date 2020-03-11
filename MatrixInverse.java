
/*
This program is to fin the inverse of a matrix
This program uses 4 methods: getMinorMatrix, getCoFactorsMatrix, getTranspose, multipyDeterminant and display

main():
	gets the matrix in a specific format from the user
	gets the matrix in a two dimensional array form using the Determinant.getArray() and Determinant.getMatrixFromArray() methods
	if the determinant is not 0
		gets a minor matrix using the getMinorMatrix() method by passing the matrix
		gets a co-factor matrix using the getCoFactorMatrix() method by passing the minor matrix
		gets an adjugate matrix using the getTranspose() method by passing the co-factor matrix
		gets an inverse matrix using the multiplyDeterminant() method by passing the adjugate matrix and determinant
		displays the inverse matrix using the display() method
	else "No inverse as determinant is 0" is displayed
	
getMinorMatrix():
	the matrix is passed
	creates a two dimensional array to store the minor matrix
	creates a two dimensional array to find the determinants
	loops through the two dimensional array
		loops through the through the two dimensional array to assign values to the temporary matrix, skipping the current row and column values of the original matrix
		finds the determinant of the temporary matrix
		assigns the determinant to the new matrix of minors
	returns the matrix of minors
	
getCoFactorMatrix():
	the minor matrix is passed
	loops through the two dimensional matrix 
		multiplies the values by (-1) raised to the power of the row number plus the column number
	the matrix is returned
	
getTranspose():
	the co-factor matrix is passed
	creates a new two dimensional array to store the transpose matrix
	loops through the matrix
		assigns the specific row and column combination of the original matrix to the column and row combination of the transpose matrix
	returns the matrix

 multiplyDeterminant():
 	the determinant and transposed matrix is passed
 	prints "Inverse:"
 	loops through the two dimensional array and prints the matrix out
 	
Sample Input:	
	{{2,1,3},{4,7,3},{2,2,5}}
Sample Output:
	Inverse:
	 1.12  0.04 -0.69 
	
	-0.54  0.15  0.23 
	
	-0.23 -0.08  0.38 
	
Sample Input:
	{{1,2,3},{4,5,6},{7,8,9}}
Sample Output:
	No inverse as determinant is 0
*/
import java.util.Scanner;

public class MatrixInverse {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter matrix: ");
		// in {{1,2,3},{4,5,6},{7,8,9}} form
		String input = s.nextLine().trim();
		double[][] matrix = Determinant.getMatrixFromArray(Determinant.getArray(input));
		double determinant = Determinant.getDeterminant(matrix);

		if (determinant != 0) {
			double[][] minors = getMinorMatrix(matrix);
			double[][] cofact = getCoFactorsMatrix(minors);
			double[][] adjugate = getTranspose(cofact);
			double[][] inverse = multiplyDeterminant(adjugate, determinant);
			display(inverse);
		} else
			System.out.println("No inverse as determinant is 0");
		s.close();
	}

	public static double[][] getMinorMatrix(double[][] matrix) {
		double[][] newmat = new double[matrix.length][matrix.length];
		double[][] tempmat = new double[matrix.length - 1][matrix.length - 1];
		int xcount = 0, ycount = 0;
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix.length; y++) {
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix.length; j++)
						if (i != x && j != y)
							tempmat[xcount][ycount++] = matrix[i][j];
					if (i != x) {
						xcount++;
						ycount = 0;
					}
				}
				ycount = 0;
				xcount = 0;
				newmat[x][y] = Determinant.getDeterminant(tempmat);
			}
		}
		return newmat;
	}

	public static double[][] getCoFactorsMatrix(double[][] matrix) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix.length; y++) {
				matrix[x][y] = matrix[x][y] * (int) Math.pow(-1, x + y);
			}
		}
		return matrix;
	}

	public static double[][] getTranspose(double[][] matrix) {
		double[][] newmat = new double[matrix.length][matrix.length];
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix.length; y++) {
				newmat[x][y] = matrix[y][x];
			}
		}
		return newmat;
	}

	public static double[][] multiplyDeterminant(double[][] matrix, double mult) {
		for (int x = 0; x < matrix.length; x++)
			for (int y = 0; y < matrix.length; y++)
				matrix[x][y] = (1 / mult) * matrix[x][y];
		return matrix;
	}

	public static void display(double[][] inverse) {
		System.out.println("Inverse:");
		for (int x = 0; x < inverse.length; x++) {
			for (int y = 0; y < inverse.length; y++) {
				if (inverse[x][y] > 0)
					System.out.print(" ");
				System.out.printf("%.02f", inverse[x][y]);
				System.out.print(" ");
			}
			System.out.println("\n");
		}
	}
}
