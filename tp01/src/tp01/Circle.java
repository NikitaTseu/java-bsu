package tp01;

import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Circle extends Shape {
	private int r = 20;
	
	public Circle(int r, Point location) {
		this.r = r;
		this.location = location;
	}

	@Override
	public void draw() {

	}

	@Override
	public void move(int dx, int dy) {
		super.move(dx, dy);
	}

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

}
