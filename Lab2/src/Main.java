import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Matrix m = new Matrix();
		
		System.out.println("�������� �������:");
		System.out.println();
		m.print();
		System.out.println();
		System.out.println("0 - ����� ������������ ������������������");
		System.out.println("1 - ����� ��������� ������������������");
		System.out.println("������� ��������:");
		
		Scanner in = new Scanner(System.in);
		int code = in.nextInt();
		
		if(code == 0) {
			System.out.println("����� ���������� ������������ ������������������:" + m.getUpSize());
		}
		else {
			if(code == 1) {
				System.out.println("����� ���������� ��������� ������������������:" + m.getDownSize());
			}
			else {
				System.out.println("�������� ���.");
			}
		}
	}
}
