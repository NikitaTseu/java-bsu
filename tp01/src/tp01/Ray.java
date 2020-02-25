package tp01;

import java.awt.Point;

public class Ray extends LineSegment {
	private float a, b;

	public Ray(Point start, Point end) {
		super(start, end);

		a = (start.y - end.y) / (start.x - end.x);
		b = start.y - a * start.x;
	}
	
	public void move(int dx, int dy) {
		super.move(dx, dy);
	}
	
	@Override
	public void draw() {
		
	}
}
