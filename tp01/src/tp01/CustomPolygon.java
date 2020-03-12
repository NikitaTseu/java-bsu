package tp01;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class CustomPolygon extends Shape {
	private int n;
	private int[] xpoints;
	private int[] ypoints;
	List<Point> points = new ArrayList<Point>();

	public CustomPolygon(List<Point> list, int n) {
		this.n = n;
		for (int i = 0; i < n; i++) {
			points.add(list.get(i));
		}
		
		setPointArrays();
	}

	private void setPointArrays() {
		xpoints = new int[n + 1];
		ypoints = new int[n + 1];

		for (int i = 0; i < n; i++) {
			xpoints[i] = points.get(i).x;
			ypoints[i] = points.get(i).y;
		}
		
		xpoints[n] = points.get(0).x;
		ypoints[n] = points.get(0).y;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.getBgColor());
		g.fillPolygon(xpoints, ypoints, n);
		g.setColor(this.getBorderColor());
		g.drawPolygon(xpoints, ypoints, n);
	}
}
