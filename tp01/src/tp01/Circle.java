package tp01;

import java.awt.Point;

public class Circle extends Ellipse {
	public Circle(Point location, Point p) {
		super(location, p);
		this.setLocation(location);
		int r;
		r = (int) Point.distance(location.x, location.y, p.x, p.y);
		this.setH(r);
		this.setH(r);
	}
}
