package tp01;

import java.awt.Point;

public class Polygon extends Shape {

	private int n = 3;
	private int r = 20;
	private int xpoints[];
	private int ypoints[];

	public Polygon(int n, int r, Point location) {
		this.n = n;
		this.r = r;
		this.location = location;

		for (int i = 0; i < n; i++) {
			xpoints[i] = (int) (r * Math.cos(2 * Math.PI * i / n)) + location.x;
			ypoints[i] = (int) (r * Math.cos(2 * Math.PI * i / n)) + location.y;
		}
	}

	public boolean contains(Point p) {
		java.awt.Polygon pol = new java.awt.Polygon(xpoints, ypoints, n);
		return pol.contains(p);
	}

	public void move(int dx, int dy) {
		super.move(dx, dy);
		for (int i = 0; i < n; i++) {
			xpoints[i] += dx;
			ypoints[i] += dy;
		}
	}

	@Override
	public void draw() {

	}
}
