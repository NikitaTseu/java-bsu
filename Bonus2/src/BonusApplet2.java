import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BonusApplet2 extends JApplet implements MouseListener, MouseMotionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private int appSize = 600, x = 20, y = 30;
	private boolean ctrlPressed = false;
	private String msg = "Hello World!";
  
    public void init() {
    	this.setSize(appSize, appSize);
    	this.setFocusable(true);
    	addMouseListener(this);
    	addKeyListener(this);
    	addMouseMotionListener(this);
        setVisible(true);
    }
    
    public void paint(Graphics g)
    {
    	g.drawString(msg, x, y);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    	this.getGraphics().clearRect(0, 0, appSize, appSize);
    	x = e.getX();
    	y = e.getY();
    	this.getGraphics().drawString(msg, x, y);
    }
    
    @Override
	public void mouseDragged(MouseEvent e) {
    	showStatus("Mouse position: (" + e.getX() + ";" + e.getY() + ")");
    	if(ctrlPressed) {
    		this.getGraphics().clearRect(0, 0, appSize, appSize);
    		x = e.getX();
        	y = e.getY();
        	this.getGraphics().drawString(msg, x, y);
    	}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		showStatus("Mouse position: (" + e.getX() + ";" + e.getY() + ")");
	}
    
    @Override
    public void mouseEntered(MouseEvent e) {
    	showStatus("Mouse position: (" + e.getX() + ";" + e.getY() + ")");
    }

    @Override
    public void mouseExited(MouseEvent e) {
    	showStatus("Mouse exited.");
    }
   
	@Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
			ctrlPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
			ctrlPressed = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {	
		if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
			msg = msg.substring(0, msg.length() - 1);
		}
		char c = e.getKeyChar();
		if(Character.isAlphabetic(c) || Character.isDigit(c)) {
			msg += c;
		}
		this.getGraphics().clearRect(0, 0, appSize, appSize);
		this.getGraphics().drawString(msg, x, y);
	}
}