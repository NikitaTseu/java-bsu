package tp01;

import java.awt.Point;

public class LineSegment extends Figure {
	protected Point start;
	protected Point end;

	public LineSegment(Point start, Point end) {
		this.start = start;
		this.end = end;

		location.x = (start.x + end.x) / 2;
		location.y = (start.y + end.y) / 2;
	}

	public void move(int dx, int dy) {
		super.move(dx, dy);
		start.x += dx;
		start.y += dy;
		end.x += dx;
		end.y += dy;
	};

	public void draw() {
		
	};
}
