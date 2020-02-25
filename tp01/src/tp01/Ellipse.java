package tp01;

import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Shape {
	private int h, w;
	
	public Ellipse(Point p1, Point p2) {
		if(p1.y < p2.y) {
			if(p1.x > p2.x) {
				int tmp = p1.x;
				p1.x = p2.x;
				p2.x = tmp;
			}
			location = p1;
			w = p2.x - p1.x;
			h = p2.y - p1.y;
		}
		else {
			if(p2.x > p1.x) {
				int tmp = p2.x;
				p2.x = p1.x;
				p1.x = tmp;
			}
			location = p2;
			w = p1.x - p2.x;
			h = p1.y - p2.y;
		}
	}

	@Override
	public boolean contains(Point p) {
		java.awt.Shape e = new Ellipse2D.Double(h, w, location.x, location.y);
		return e.contains(p);
	}
	
	public void move(int dx, int dy) {
		super.move(dx, dy);
	}
	
	@Override
	public void draw() {
		
	}
}
