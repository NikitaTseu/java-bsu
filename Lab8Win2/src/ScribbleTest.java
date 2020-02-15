import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ScribbleTest extends JFrame
{
	Scribble scr;
    public ScribbleTest(String s)
    {
        super(s);
        Container content = getContentPane();
        scr = new Scribble(600, 600);
        JScrollPane scroll = new JScrollPane(scr);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(500, 400));
        content.add(scroll, BorderLayout.CENTER);

        JPanel p = new JPanel();
        content.add(p, BorderLayout.SOUTH);

        JButton b1 = new JButton("Red");
        p.add(b1);
        b1.addActionListener(scr);

        JButton b2 = new JButton("Green");
        p.add(b2);
        b2.addActionListener(scr);

        JButton b3 = new JButton("Blue");
        p.add(b3);
        b3.addActionListener(scr);
        
        JButton b4 = new JButton("Open");
        p.add(b4);
        b4.addActionListener(scr);
        
        JButton b5 = new JButton("Save");
        p.add(b5);
        b5.addActionListener(scr);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new ScribbleTest("Scribble");
    }
}
