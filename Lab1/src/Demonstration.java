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
		
		System.out.println("Введите угол поворота:");
		Scanner in = new Scanner(System.in);
		double angle = in.nextDouble();
		p2.rotate(angle);
		System.out.println("Координаты точки после поворота:");
		p2.printCoord();
		
		System.out.println("Введите координаты вектора сдвига:");
		double x = in.nextDouble();
		double y = in.nextDouble();
		p2.move(x, y);
		System.out.println("Координаты точки после сдвига:");
		p2.printCoord();
		
		System.out.println("Введите новые координаты для точки:");
		x = in.nextDouble();
		y = in.nextDouble();
		p2.setCoord(x, y);
		System.out.println("Координаты точки после обновления:");
		p2.printCoord();
	}
}
