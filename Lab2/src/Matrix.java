import java.util.Scanner;

public class Matrix {
	int [][] matrix;
	int n;
	
	Matrix(){
		System.out.println("¬ведите размерность матрицы:");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		matrix = new int [n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = (int)( Math.random() * n);
				if((int)( Math.random() * 2) == 0) {
					matrix[i][j] *= (-1);
				}
			}
		}
	}
	
	void print() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	int getUpSize() {
		int counter = 1, maxcounter = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i != n-1 || j != n-1) {
					if(j == n-1) {
						if(matrix[i][j] < matrix[i+1][0]) {
							counter++;
						}
						else {
							maxcounter = Math.max(maxcounter, counter);
							counter = 1;
						}
					}
					else {
						if(matrix[i][j] < matrix[i][j+1]) {
							counter++;
						}
						else {
							maxcounter = Math.max(maxcounter, counter);
							counter = 1;
						}
					}
				}
			}
		}
		return maxcounter;
	}

	int getDownSize() {
		int counter = 1, maxcounter = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i != n-1 || j != n-1) {
					if(j == n-1) {
						if(matrix[i][j] > matrix[i+1][0]) {
							counter++;
						}
						else {
							maxcounter = Math.max(maxcounter, counter);
							counter = 1;
						}
					}
					else {
						if(matrix[i][j] > matrix[i][j+1]) {
							counter++;
						}
						else {
							maxcounter = Math.max(maxcounter, counter);
							counter = 1;
						}
					}
				}
			}
		}
		return maxcounter;
	}
}
