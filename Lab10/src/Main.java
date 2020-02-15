import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings({ "serial" })
public class Main extends JFrame {
	private List<Security> baseList;
	Map<String, Integer> minSalaryMap;
	private JPanel firstPanel, secondPanel;
	private JTabbedPane tabbedPane;

	public static void main(String[] args) {
		new Main("Created by Nikita Tev");
	}
	
	

	public Main(String title) {
		super(title);
		baseList = new ArrayList<Security>();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(600, 300));
		this.setResizable(false);

		firstPanel = new JPanel();
		secondPanel = new JPanel();

		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Список сотрудников", firstPanel);
		tabbedPane.addTab("Минимальная зарплата", secondPanel);
		this.add(tabbedPane);

		JMenuBar menu = new JMenuBar();
		this.setJMenuBar(menu);
		JMenu file = new JMenu("File");
		JMenuItem open = new JMenuItem("Open");
		file.add(open);
		menu.add(file);

		pack();
		setVisible(true);

		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showDialog(null, "Open") == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					FileReader reader = new FileReader(file.getPath());
					try {
						baseList = reader.read();
					} catch (ReadingFileException ex) {
						JOptionPane.showMessageDialog(tabbedPane, "Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
						return;
					}
					Collections.sort(baseList);

					firstPanel.removeAll();
					secondPanel.removeAll();

					DefaultListModel<Security> model = new DefaultListModel<>();
					for (int i = 0; i < baseList.size(); i++) {
						model.addElement(baseList.get(i));
					}
					JList<Security> list = new JList<>(model);
					if (!baseList.isEmpty()) {
						firstPanel.add(list);
						JScrollPane scrollPane1 = new JScrollPane(list);
						scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
						scrollPane1.setPreferredSize(new Dimension(500, 200));
						firstPanel.add(scrollPane1);

						minSalaryMap = minSalaryByPosition(baseList);
						DefaultListModel<String> minSalaryModel = new DefaultListModel<>();
						for (Map.Entry<String, Integer> ent : minSalaryMap.entrySet()) {
							minSalaryModel.addElement(ent.getKey() + ": " + ent.getValue());
						}
						JList<String> minSalaryList = new JList<>(minSalaryModel);
						secondPanel.add(minSalaryList);
						JScrollPane scrollPane2 = new JScrollPane(minSalaryList);
						scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
						scrollPane2.setPreferredSize(new Dimension(200, 100));
						secondPanel.add(scrollPane2);
					} else {
						JOptionPane.showMessageDialog(firstPanel, "Error", "Container is empty!",
								JOptionPane.ERROR_MESSAGE);
					}
					pack();

				}
			}
		});
	}

	public static Map<String, Integer> minSalaryByPosition(List<Security> workers) {
		Map<String, Integer> res = new HashMap<>();

		for (Security w : workers) {
			int sal = w.getSalary();
			Integer minSalary = res.get(w.getPosition());
			if (minSalary == null || sal < minSalary) {
				res.put(w.getPosition(), sal);
			}
		}
		return res;
	}
}
