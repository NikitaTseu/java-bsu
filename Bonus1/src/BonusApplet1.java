import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BonusApplet1 extends JApplet implements MouseListener {
	private static final long serialVersionUID = 1L;
	
	private int N = 5, bSize = 100;
    private Color colorContainer;
    
    public void init() {
    	this.setName("BonusApplet1");
    	
    	this.setSize(new Dimension(bSize * N, bSize * N));
        setLayout(new GridLayout(N, N));
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                JButton b = new JButton();
                b.addMouseListener(this);
                add(b);
            }
        setVisible(true);
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        JButton tmp = ((JButton)e.getSource());
        colorContainer = tmp.getBackground();
        tmp.setBackground(new Color(120, 234, 229));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton tmp = ((JButton)e.getSource());
        tmp.setBackground(colorContainer);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JButton tmpButton = ((JButton)e.getSource());
        tmpButton.setText("Clicked!");
        showStatus("Clicked!");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JButton tmp = ((JButton)e.getSource());
        tmp.setText("");
        showStatus("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
}