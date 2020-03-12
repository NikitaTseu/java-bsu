package tp01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {

	//private DrawPanel drawPanel; // it's me
	private Palette mainPalette; // it's my parent Panel
	private List<Figure> figureList = new ArrayList<Figure>();
	private List<Point> pointBuffer = new ArrayList<Point>();

	private int bufferLimit = 2;
	private int n = 3;

	public DrawPanel(Palette palette) {
		//this.drawPanel = this;
		this.mainPalette = palette;

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// check current mode
				if (mainPalette.isDrawMode()) {
					// add a new point to buffer
					pointBuffer.add(new Point(e.getX(), e.getY()));
					
					// in this case we should create and draw a new figure
					if (pointBuffer.size() == bufferLimit) {
						Figure newFigure = createFigure();
						figureList.add(newFigure);
						clearPointBuffer();
					}
					redraw();
				}
			}
		});

	}
	
	private Figure createFigure() {
		Figure newFigure = null;

		switch (mainPalette.getFigureType()) {
		case LINE:
			newFigure = new Line(pointBuffer.get(0), pointBuffer.get(1));
			break;

		case RAY:
			newFigure = new Ray(pointBuffer.get(0), pointBuffer.get(1));
			break;

		case LINESEGMENT:
			newFigure = new LineSegment(pointBuffer.get(0), pointBuffer.get(1));
			break;

		case TRIANGLE:
			newFigure = new Triangle(pointBuffer);
			break;

		case RHOMBUS:
			newFigure = new Rhombus(pointBuffer.get(0), pointBuffer.get(1));
			break;
			
		case ELLIPSE:
			newFigure = new Ellipse(pointBuffer.get(0), pointBuffer.get(1));
			break;
			
		case CIRCLE:
			newFigure = new Circle(pointBuffer.get(0), pointBuffer.get(1));
			break;
			
		case RECTANGLE:
			newFigure = new Rectangle(pointBuffer.get(0), pointBuffer.get(1));
			break;
			
		case REGULARPOLYGON:
			newFigure = new RegularPolygon(pointBuffer.get(0), pointBuffer.get(1), n);
			break;
			
		case POLYLINE:
			newFigure = new PolyLine(pointBuffer, bufferLimit);
			break;
			
		case CUSTOMPOLYGON:
			newFigure = new CustomPolygon(pointBuffer, bufferLimit);
			break;

		default:
			break;
		}
		
		// setting colors for the new figure
		if (newFigure instanceof Shape) {
			((Shape) newFigure).setBgColor(mainPalette.getBgColor());
		}
		newFigure.setBorderColor(mainPalette.getBrColor());
		
		return newFigure;
	}

	public void clearPointBuffer() {
		pointBuffer.clear();
		redraw();
	}

	public void redraw() {
		Graphics g = this.getGraphics();
		g.setColor(Color.WHITE);
		g.clearRect(-10000, -10000, 20000, 20000);
		
		for (int i = 0; i < figureList.size(); i++) {
			figureList.get(i).draw(g);
		}
		for (int i = 0; i < pointBuffer.size(); i++) {
			g.setColor(Color.BLACK);
			g.drawOval(pointBuffer.get(i).x - 2, pointBuffer.get(i).y - 2, 4, 4);
			g.fillOval(pointBuffer.get(i).x - 2, pointBuffer.get(i).y - 2, 4, 4);
		}
	}

	

	public void setBufferLimit(int bufferLimit) {
		this.bufferLimit = bufferLimit;
	}
	
	public void setN(int n) {
		this.n = n;
	}
}
