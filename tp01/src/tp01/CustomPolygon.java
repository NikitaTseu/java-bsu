package tp01;

import java.awt.Graphics;
import java.awt.Point;

public class CustomPolygon extends PolyLine {
	
	public CustomPolygon(Point[] list, int n) {
		super(list, n);
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		Point end = this.getEdges()[this.getEdges().length - 1].getEnd(); 
		g.setColor(this.getBorderColor());
        g.drawLine(this.getLocation().x, this.getLocation().y, end.x, end.y);
	}
}
