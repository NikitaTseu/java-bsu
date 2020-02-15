import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


public class MainWindow extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    
    protected int base, step, length;
    protected Exponential eSeries;
    protected Linear lSeries;
    protected Series[] curS;
	
	protected JButton bSave, bApply;
	protected ButtonGroup group1;
	protected JRadioButton btnL, btnE;
	protected JTextField tf1, tf2, tf3, tfSum, tfFile;
	protected JTextArea txtArea;
	protected JScrollPane scroll;

	public void addComponentsToPane(Container pane) { 
		pane.setBackground(new Color(255, 248, 210));
		pane.setLayout(new GridBagLayout()); 
		
	    GridBagConstraints cMain = new GridBagConstraints(); 
	    cMain.fill = GridBagConstraints.BOTH;
	    cMain.anchor = GridBagConstraints.WEST;
	    cMain.insets = new Insets(5, 5, 5, 5);
		
		JPanel pRadio = new JPanel(); //радиокнопки
		JPanel pInform = new JPanel(); // информация о прогрессии
		JPanel pSettings = new JPanel(); //все настройки
		JPanel pText = new JPanel(); // вывод прогрессии
		JPanel pSum = new JPanel(); // панель с суммой
		JPanel pFile = new JPanel(); // работа с файлом
		
		pRadio.setBackground(new Color(224, 255, 255));
		pInform.setBackground(new Color(224, 255, 255));
		pSettings.setBackground(new Color(224, 255, 255));
		pText.setBackground(new Color(224, 255, 255));
		pSum.setBackground(new Color(224, 255, 255));
		pFile.setBackground(new Color(224, 255, 255));
		
		Border standart = BorderFactory.createLineBorder(Color.gray, 1);
		pRadio.setBorder(standart);
		pSettings.setBorder(standart);
		pText.setBorder(standart);
		pSum.setBorder(standart);
		pFile.setBorder(standart);
		
		btnL = new JRadioButton("Linear");
		btnE = new JRadioButton("Exponential");
		btnL.setBackground(new Color(224, 255, 255));
		btnE.setBackground(new Color(224, 255, 255));
		group1 = new ButtonGroup();
		group1.add(btnL);
		group1.add(btnE);
		btnL.setSelected(true);
		
		pRadio.setLayout(new GridBagLayout()); 
		GridBagConstraints cRadio = new GridBagConstraints(); 
	    cRadio.fill = GridBagConstraints.BOTH;
	    cRadio.anchor = GridBagConstraints.WEST;
	    cRadio.insets = new Insets(2, 5, 5, 5);
	    Border titled = BorderFactory.createTitledBorder("Series type");
	    pRadio.setBorder(titled);
		
	    pRadio.add(btnL, cRadio);
	    cRadio.gridy = 1;
	    pRadio.add(btnE, cRadio);
	    
		pInform.setLayout(new GridBagLayout()); 
	    GridBagConstraints c = new GridBagConstraints(); 
	    c.fill = GridBagConstraints.BOTH;
	    c.anchor = GridBagConstraints.WEST;
	    c.insets = new Insets(5, 5, 5, 5);
	    
	    Label l2 = new Label("BASE");
	    Label l3 = new Label("STEP");
	    Label l4 = new Label("LENGTH");
	    tf1 = new JTextField(5);
	    tf2 = new JTextField(5);
	    tf3 = new JTextField(5);
	    
	    pInform.add(tf1, c);
	    c.gridx = 1;
	    pInform.add(l2, c);
	    c.gridy = 1;
	    c.gridx = 0;
	    
	    pInform.add(tf2, c);
	    c.gridx = 1;
	    pInform.add(l3, c);
	    c.gridy = 2;
	    c.gridx = 0;
	    
	    pInform.add(tf3, c);
	    c.gridx = 1;
	    pInform.add(l4, c);
	    
	    bApply = new JButton("Apply");
	    
	    pSettings.setLayout(new GridBagLayout()); 
	    c.gridx = 0;
	    c.gridy = 0;
	    pSettings.add(pRadio, c);
	    c.gridy = 1;
	    pSettings.add(pInform, c);
	    c.gridy = 2;
	    c.anchor = GridBagConstraints.CENTER;
	    pSettings.add(bApply, c);
	    
	    txtArea = new JTextArea(10, 50);
	    txtArea.setLineWrap(true);
	    txtArea.setWrapStyleWord(true);
	    txtArea.setSelectedTextColor(Color.red);
	    txtArea.setEditable(false);
	    scroll = new JScrollPane(txtArea);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    pText.setLayout(new GridBagLayout()); 
	    c.gridx = 0;
	    c.gridy = 0;
	    c.anchor = GridBagConstraints.NORTH;
	    pText.add(scroll, c);
	    
	    Label l5 = new Label("SUM =");
	    tfSum = new JTextField(10);
	    tfSum.setEnabled(false);
	    pSum.setLayout(new GridBagLayout());
	    c.gridx = 0;
	    c.gridy = 0;
	    c.anchor = GridBagConstraints.EAST;
	    c.insets = new Insets(5, 5, 5, 0);
	    pSum.add(l5, c);
	    c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    c.insets = new Insets(5, 0, 5, 5);
	    pSum.add(tfSum, c);
	    c.insets = new Insets(5, 5, 5, 5);
	    
	    pFile.setLayout(new GridBagLayout());
	    Label l6 = new Label("File:");
	    Label l7 = new Label(".txt");
	    
	    c.gridx = 0;
	    c.gridy = 0;
	    tfFile = new JTextField(20);
	    tfFile.setHorizontalAlignment(JTextField.RIGHT);
	    bSave = new JButton("Save");
	    pFile.add(l6, c);
	    c.gridx = 1;
	    c.insets = new Insets(5, 5, 5, 0);
	    pFile.add(tfFile, c);
	    c.gridx = 2;
	    c.insets = new Insets(5, 0, 5, 5);
	    pFile.add(l7, c);
	    c.gridx = 3;
	    c.insets = new Insets(5, 5, 5, 5);
	    pFile.add(bSave, c);
	    
	    cMain.gridheight = 2;
	    pane.add(pSettings, cMain);
	    cMain.gridx = 1;
	    cMain.gridheight = 1;
	    cMain.gridwidth = 2;
	    pane.add(pText, cMain);
	    cMain.gridy = 1;
	    cMain.gridwidth = 1;
	    pane.add(pSum, cMain);
	    cMain.gridx = 2;
	    cMain.gridwidth = GridBagConstraints.REMAINDER;
	    pane.add(pFile, cMain);
    } 

    public MainWindow(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentsToPane(this.getContentPane());
        bApply.addActionListener(this);
        bSave.addActionListener(this);
        btnL.addActionListener(this);
        btnE.addActionListener(this);
        pack();
        
        eSeries = new Exponential(0, 0, 0);
        lSeries = new Linear(0, 0, 0);
        curS = new Series[1];
        curS[0] = eSeries;
      }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bApply) {
        	try {
        		base = Integer.valueOf(tf1.getText());
        		step = Integer.valueOf(tf2.getText());
        		length = Integer.valueOf(tf3.getText());
        		eSeries = new Exponential(base, step, length);
        		lSeries = new Linear(base, step, length);
        		
        		if(btnL.isSelected()) {
        			curS[0] = lSeries;
        		}
        		else {
        			curS[0] = eSeries;
        		}
        		
        		tfSum.setText(String.valueOf(curS[0].sum()));
        		txtArea.setText(curS[0].toString());
        	}
        	catch(NumberFormatException exception) {
        		txtArea.setText("Please fill in all fields with integers.");
        		tfSum.setText("");
        	}
        }
        if (e.getSource() == bSave) {
        	String filename;
        	if(tfFile.getText() == "") {
        		filename = "defaultOutput.txt";
        	}
        	else {
        		filename = tfFile.getText() + ".txt";
        	}
            
            String data = curS[0].toString();
            try(FileOutputStream fos = new FileOutputStream(filename))
            {
                // перевод строки в байты
                byte[] buffer = data.getBytes();
                  
                fos.write(buffer, 0, buffer.length);
            }
            catch(IOException ex){
                //System.out.println(ex.getMessage());
            }
        }
        if (e.getSource() == btnL) {
        	curS[0] = lSeries;
        }
        if (e.getSource() == btnE) {
        	curS[0] = eSeries;
        }
    }

    public static void main(String[] args) {
    	MainWindow frame = new MainWindow("Series");
    	frame.setVisible(true);
    }
}
