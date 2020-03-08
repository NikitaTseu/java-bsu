package tp01;

import java.awt.Color;

public abstract class Shape extends Figure {
	private Color bgColor = Color.WHITE;
	
	public Color getBgColor() {
		return bgColor;
	}
	
	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}
}