import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Matrix m = new Matrix();
		
		System.out.println("»сходна€ матрица:");
		System.out.println();
		m.print();
		System.out.println();
		System.out.println("0 - поиск возрастающей последовательности");
		System.out.println("1 - поиск убывающей последовательности");
		System.out.println("¬ведите значение:");
		
		Scanner in = new Scanner(System.in);
		int code = in.nextInt();
		
		if(code == 0) {
			System.out.println("ƒлина наибольшей возрастающей последовательности:" + m.getUpSize());
		}
		else {
			if(code == 1) {
				System.out.println("ƒлина наибольшей убывающей последовательности:" + m.getDownSize());
			}
			else {
				System.out.println("Ќеверный код.");
			}
		}
	}
}
