package tp01;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

public class PolyLine extends Figure {
	private LineSegment[] edges;

	public PolyLine(List<Point> list, int n) {
		edges = new LineSegment[n - 1];
		for (int i = 0; i < n - 1; i++) {
			edges[i] = new LineSegment(list.get(i), list.get(i + 1));
			edges[i].setBorderColor(this.getBorderColor());
		}
		this.setLocation(list.get(0));
	}

	@Override
	public void move(Point p) {
		super.move(p);
		for (LineSegment edge : edges) {
			edge.move(p);
		}
	}

	@Override
	public void draw(Graphics g) {
		for (LineSegment edge : edges) {
			edge.draw(g);
		}
	}

	public LineSegment[] getEdges() {
		return edges;
	}

	public void setEdges(LineSegment[] edges) {
		this.edges = edges;
	}

}
