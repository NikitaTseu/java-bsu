import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	
	String[] words1 = {"Париж", "Амстердам", "Брюгге", "Хельсинки", "Мадрид", "Рекъявик", "Берн"};
    String[] words2 = {"Копенгаген", "Варшава", "Венеция", "Лондон", "Женева", "Минск", "Лиссабон"};
    
    public static void main(String[] args) {
        new Main("Lab9Win3"); 
    }

    public Main(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("First task", new Tab1());
        tabbedPane.addTab("Second task", new Tab2());
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        add(tabbedPane);
        pack();
        setVisible(true);
    }

    class Tab1 extends JPanel implements ActionListener{
		private static final long serialVersionUID = 1L;
		JButton toRight, toLeft;
		JPanel centralPanel;
		DefaultListModel lModel, rModel;
		JList leftlist, rightlist;

		public Tab1() {
        	setLayout(new BorderLayout());
        	
        	toRight = new JButton(new ImageIcon("images/rightButtonIcon.png"));
            toLeft = new JButton(new ImageIcon("images/leftButtonIcon.png"));
            toRight.addActionListener(this);
            toLeft.addActionListener(this);
            
            centralPanel = new JPanel();
            centralPanel.setLayout(new BorderLayout());
            centralPanel.add(toRight, BorderLayout.NORTH);
            centralPanel.add(toLeft, BorderLayout.SOUTH);
            add(centralPanel, BorderLayout.CENTER);

            lModel = new DefaultListModel();
            rModel = new DefaultListModel();
            leftlist = new JList(lModel);
            rightlist = new JList(rModel);

            for (int i = 0; i < words1.length; i++) {
            	lModel.addElement(words1[i]);
            }

            for (int i = 0; i < words2.length; i++) {
            	rModel.addElement(words2[i]);
            }

            add(leftlist, BorderLayout.WEST);
            add(rightlist, BorderLayout.EAST);
            add(new JScrollPane(leftlist, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.WEST);
            add(new JScrollPane(rightlist, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.EAST);
            pack();
        }
		
		 public void actionPerformed(ActionEvent e) {
         	if(e.getSource() == toRight) {
         		 if (!leftlist.isSelectionEmpty()) {
                 	rModel.addElement(leftlist.getSelectedValue());
                	lModel.remove(leftlist.getSelectedIndex());
                 }
         	}
         	if(e.getSource() == toLeft) {
         		if (!rightlist.isSelectionEmpty()) {
         			lModel.addElement(rightlist.getSelectedValue());
         			rModel.remove(rightlist.getSelectedIndex());
                }
        	}
         }
    }

    class Tab2 extends JPanel {
        public Tab2() {
        	JPanel p = new JPanel();
            ButtonGroup radioGroup = new ButtonGroup();
            ImageIcon[] icons = new ImageIcon[4];
            icons[0] = new ImageIcon("images/Icon1.png");
            icons[1] = new ImageIcon("images/Icon2.png");
            icons[2] = new ImageIcon("images/Icon3.png");
            icons[3] = new ImageIcon("images/Icon4.png");

            for (int i = 0; i < 3; i++) {
                JRadioButton temp = new JRadioButton(icons[0]);
                temp.setSelectedIcon(icons[1]);
                temp.setRolloverIcon(icons[2]);
                //temp.setRolloverSelectedIcon(icons[2]);
                temp.setPressedIcon(icons[3]);
                radioGroup.add(temp);
                p.add(temp);
            }
            this.add(p);
        }
    }
}