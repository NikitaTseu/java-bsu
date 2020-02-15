import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class Scribble extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{
    protected int lastX, lastY, w, h;
    protected JFrame f;
    protected Color currColor = Color.RED;
    
   protected BufferedImage bi1;
    
    static class ALine {
    	int x1, x2;
    	int y1, y2;
    	Color color;
		public ALine(int x1, int y1, int x2, int y2, Color color) {
			super();
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
			this.color = color;
		}
		public int getX1() {
			return x1;
		}
		public void setX1(int x1) {
			this.x1 = x1;
		}
		public int getX2() {
			return x2;
		}
		public void setX2(int x2) {
			this.x2 = x2;
		}
		public int getY1() {
			return y1;
		}
		public void setY1(int y1) {
			this.y1 = y1;
		}
		public int getY2() {
			return y2;
		}
		public void setY2(int y2) {
			this.y2 = y2;
		}
		public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			this.color = color;
		}
    	
    	
    }
    
    List<ALine> lines = new LinkedList<>();

    public Scribble(int width, int height)
    {
    	w = width;
    	h = height;
        this.setSize(width, height);
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setBackground(new Color(255, 255, 255));
        Border standart = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(standart);
        bi1 = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension(w, h);
    }

    public void mouseReleased(MouseEvent me) {}
    public void mouseClicked(MouseEvent me) {}
    public void mouseMoved(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}
    
    public void mousePressed(MouseEvent me)
    {
        lastX = me.getX();
        lastY = me.getY();
    }
    
    public void mouseDragged(MouseEvent me)
    {
        Graphics2D g = (Graphics2D)this.getGraphics();
        Graphics2D g1 = (Graphics2D)bi1.getGraphics();
        g.setColor(currColor);
        g1.setColor(currColor);
        g.drawLine(lastX, lastY, me.getX(), me.getY());
        g1.drawLine(lastX, lastY, me.getX(), me.getY());
        lines.add(new ALine(lastX, lastY, me.getX(), me.getY(), currColor));
        lastX = me.getX();
        lastY = me.getY();
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	repaint();
    	lines.forEach(line -> {
    		g.setColor(line.color);
    		g.drawLine(line.x1, line.y1, line.x2, line.y2);
    	});
    }

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        
        if(s.equals("Red"))
            currColor = Color.RED;
        else if(s.equals("Blue"))
            currColor = Color.BLUE;
        else if(s.equals("Green"))
            currColor = Color.GREEN;
        else if(s.equals("Save")) {
            JFileChooser fc = new JFileChooser();
            if ( fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
                try ( FileWriter fw = new FileWriter(fc.getSelectedFile()) ) {
                    ImageIO.write(bi1, "png", fc.getSelectedFile());
                }
                catch ( IOException ex ) {
                	ex.printStackTrace();
                }
            }
        }
        else if(s.equals("Open")) {
			try { 
				File open = new File("imageOpen.png");
				bi1 = ImageIO.read(open);
				boolean res = this.getGraphics().drawImage(bi1, 0, 0, null);
				System.out.println(res);
				paintComponent(this.getGraphics());
				// repaint();
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
        }
    }

}
