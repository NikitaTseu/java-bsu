package tp01;

import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {

	private int h, w;

	public Rectangle(Point p1, Point p2) {
		if (p1.x > p2.x) {
			int tmp = p1.x;
			p1.x = p2.x;
			p2.x = tmp;
		}

		if (p1.y > p2.y) {
			int tmp = p1.y;
			p1.y = p2.y;
			p2.y = tmp;
		}

		this.setLocation(p1);

		w = (int) (p2.x - p1.x);
		h = (int) (p2.y - p1.y);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.getBgColor());
		g.fillRect(this.getLocation().x, this.getLocation().y, w, h);
		g.setColor(this.getBorderColor());
		g.drawRect(this.getLocation().x, this.getLocation().y, w, h);
	}
}
