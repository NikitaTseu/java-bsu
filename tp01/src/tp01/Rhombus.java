package tp01;

import java.awt.Graphics;
import java.awt.Point;

public class Rhombus extends Shape {

	private int xpoints[] = new int[4];
	private int ypoints[] = new int[4];

	public Rhombus(Point[] points) {
		this.setLocation(points[0]);
		for (int i = 1; i < 3; i++) {
			xpoints[i - 1] = points[i].x;
			ypoints[i - 1] = points[i].y;
		}
		xpoints[2] = xpoints[0];
		ypoints[2] = ypoints[0] + 2 * (this.getLocation().y - ypoints[0]);
		xpoints[3] = xpoints[1] - 2 * (xpoints[1] - this.getLocation().x);
		ypoints[3] = ypoints[1];
	}

	public void move(Point p) {
		super.move(p);
		for (int i = 0; i < 4; i++) {
			xpoints[i] += getDelta(p).x;
			ypoints[i] += getDelta(p).y;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.getBorderColor());
		g.drawPolygon(xpoints, ypoints, 4);
		g.setColor(this.getBgColor());
		g.fillPolygon(xpoints, ypoints, 4);
	}
}
