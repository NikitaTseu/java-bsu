package tp01;

import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {

	private int h, w;

	public Rectangle(Point a1, Point a2) {
		Point p1 = (Point) a2.clone();
		Point p2 = (Point) a2.clone();
		if (p1.y < p2.y) {
			if (p1.x > p2.x) {
				int tmp = p1.x;
				p1.x = p2.x;
				p2.x = tmp;
			}
			w = (int) (p2.x - p1.x);
			h = (int) (p2.y - p1.y);
			this.setLocation(new Point(p1.x + w, p1.y + h));
		} else {
			if (p2.x > p1.x) {
				int tmp = p2.x;
				p2.x = p1.x;
				p1.x = tmp;
			}
			w = (int) (p1.x - p2.x);
			h = (int) (p1.y - p2.y);
			this.setLocation(new Point(p2.x + w, p2.y + h));
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.getBorderColor());
		g.drawRect(this.getLocation().x - w, this.getLocation().y - h, w, h);
		g.setColor(this.getBgColor());
		g.fillRect(this.getLocation().x - w, this.getLocation().y - h, w, h);
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}
}
