package tp01;

import java.awt.Graphics;
import java.awt.Point;

public class RegularPolygon extends Shape {

	private int n;
	private int xpoints[];
	private int ypoints[];

	public RegularPolygon(Point location, Point p, int n) {
		this.setLocation(location);
		this.n = n;
		int r = (int) location.distance(p);
		
		for (int i = 0; i < n; i++) {
			xpoints[i] = (int) (r * Math.cos(2 * Math.PI * i / n)) + location.x;
			ypoints[i] = (int) (r * Math.cos(2 * Math.PI * i / n)) + location.y;
		}
	}

	public void move(Point p) {
		super.move(p);
		for (int i = 0; i < n; i++) {
			xpoints[i] += getDelta(p).x;
			ypoints[i] += getDelta(p).y;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.getBorderColor());
		g.drawPolygon(xpoints, ypoints, n);
		g.setColor(this.getBgColor());
		g.fillPolygon(xpoints, ypoints, n);
	}
}
