import java.util.Scanner;

public class Demonstration{
	public static void main(String[] args) throws Exception {
		System.out.println("Point demonstration:");
		Point p1 = new Point();
		Point p2 = new Point(0, 0);
		
		try {
			p1.printCoord();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		p2.printCoord();
		
		System.out.println("������� ���� ��������:");
		Scanner in = new Scanner(System.in);
		double angle = in.nextDouble();
		p2.rotate(angle);
		System.out.println("���������� ����� ����� ��������:");
		p2.printCoord();
		
		System.out.println("������� ���������� ������� ������:");
		double x = in.nextDouble();
		double y = in.nextDouble();
		p2.move(x, y);
		System.out.println("���������� ����� ����� ������:");
		p2.printCoord();
		
		System.out.println("������� ����� ���������� ��� �����:");
		x = in.nextDouble();
		y = in.nextDouble();
		p2.setCoord(x, y);
		System.out.println("���������� ����� ����� ����������:");
		p2.printCoord();
	}
}
