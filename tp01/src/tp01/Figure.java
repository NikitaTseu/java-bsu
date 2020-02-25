package tp01;

import java.awt.Color;
import java.awt.Point;

public abstract class Figure {
	protected Point location = new Point(10, 10);
	protected Color borderColor = Color.BLACK;

	public abstract void draw();

	public void move(int dx, int dy) {
		location.x += dx;
		location.y += dy;
		
		draw();
	}
	
	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public void setLocation(Point newLoc) {
		location = newLoc;
	};

	public Point getLocation() {
		return location;
	};
}
