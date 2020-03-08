package tp01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Figure {
	private Point location;
	private Color borderColor = Color.BLACK;

	public abstract void draw(Graphics g);
	
	public Point getDelta(Point p) {
		return new Point(location.x - p.x, location.y - p.y);
	}

	public void move(Point p) {
		location = p;
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
