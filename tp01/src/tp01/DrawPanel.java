package tp01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
   
	private static final long serialVersionUID = 1L;
	private Point startPoint;
    private Point endPoint;
    private JPanel panel;
    private List<Figure> figureList = new ArrayList<Figure>();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public DrawPanel() {
        panel = this;
        startPoint = new Point();
        endPoint = new Point();
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                startPoint.x = e.getX();
                startPoint.y = e.getY();


                System.out.println("start: " + startPoint);

            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Palette palette = new Palette();
                Graphics graphicsPanel = e.getComponent().getGraphics();
                endPoint.x = e.getX();
                endPoint.y = e.getY();
                Color color = ((Palette) SwingUtilities.getRoot(panel)).getBckColor();
                graphicsPanel.setColor(color);
                graphicsPanel.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                System.out.println("end: " + endPoint);

            }


        });

    }
    public void draw(){}

}
