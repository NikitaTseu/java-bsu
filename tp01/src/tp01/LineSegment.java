package tp01;

import java.awt.Graphics;
import java.awt.Point;

public class LineSegment extends Figure {
	private Point end;

	public LineSegment(Point start, Point end) {
		this.setLocation(start);
		this.end = end;
	}

	public void move(Point p) {
		super.move(p);
		end.x += getDelta(p).x;
		end.y += getDelta(p).y;
	};

	public void draw(Graphics g) {
		g.setColor(this.getBorderColor());
        g.drawLine(this.getLocation().x, this.getLocation().y, end.x, end.y);
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	};
}
