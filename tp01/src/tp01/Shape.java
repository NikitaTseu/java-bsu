package tp01;

import java.awt.Color;
import java.awt.Point;

public abstract class Shape extends Figure {
	protected Color bgColor = Color.WHITE;
	
	public abstract boolean contains(Point p);
	
	public Color getBgColor() {
		return bgColor;
	}
	
	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}
}
