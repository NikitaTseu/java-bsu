import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
	private ArrayList<Zver> baseList;
	Map<String, Integer> baseMap;
	private JPanel firstPanel, secondPanel, thirdPanel, panel4, panel5;
	private DefaultListModel<Zver> model;
	private JTabbedPane tabbedPane;

	public static void main(String[] args) {
		new Main("Created by Nikita Tev");
	}

	public Main(String title) {
		super(title);
		baseList = new ArrayList<Zver>();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800, 500));
		this.setResizable(false);

		firstPanel = new JPanel();
		secondPanel = new JPanel();
		thirdPanel = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();

		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Список зверей", firstPanel);
		tabbedPane.addTab("Сортируем по месту", secondPanel);
		tabbedPane.addTab("Сортируем по массе", thirdPanel);
		tabbedPane.addTab("Места", panel5);
		this.add(tabbedPane);

		JMenuBar menu = new JMenuBar();
		this.setJMenuBar(menu);
		JMenu file = new JMenu("Файл");
		JMenu data = new JMenu("Данные");
		JMenuItem open = new JMenuItem("Открыть");
		JMenuItem byPlace = new JMenuItem("По обитанию");
		JMenuItem byMass = new JMenuItem("По массе");
		JMenuItem adapt = new JMenuItem("Приспособленцы");
		JMenuItem places = new JMenuItem("Места");
		JMenuItem find = new JMenuItem("Поиск");
		JMenuItem kol = new JMenuItem("Количество");
		file.add(open);
		data.add(byPlace);
		data.add(byMass);
		data.add(adapt);
		data.add(places);
		data.add(find);
		data.add(kol);
		menu.add(file);
		menu.add(data);

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
						baseList = (ArrayList<Zver>) reader.read();
					} catch (ReadingFileException ex) {
						JOptionPane.showMessageDialog(tabbedPane, "Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
						return;
					}

					firstPanel.removeAll();
					secondPanel.removeAll();
					thirdPanel.removeAll();
					panel4.removeAll();
					panel5.removeAll();
					baseMap = new HashMap<>();
					for (Zver z : baseList) {
						Integer countPlace = baseMap.get(z.place);
						if (countPlace == null) {
							baseMap.put(z.place, 1);
						} else {
							baseMap.put(z.place, countPlace + 1);
						}
					}

					model = new DefaultListModel<>();
					for (int i = 0; i < baseList.size(); i++) {
						model.addElement(baseList.get(i));
					}

					JList<Zver> list = new JList<>(model);
					if (!baseList.isEmpty()) {
						firstPanel.add(list);
						JScrollPane scrollPane1 = new JScrollPane(list);
						scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
						scrollPane1.setPreferredSize(new Dimension(500, 200));
						firstPanel.add(scrollPane1);
					} else {
						JOptionPane.showMessageDialog(firstPanel, "Error", "Container is empty!",
								JOptionPane.ERROR_MESSAGE);
					}
					pack();

				}
			}
		});

		byPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Zver> sortedList2 = (ArrayList<Zver>) baseList.clone();
				Collections.sort(sortedList2, new Comparator<Zver>() {
					public int compare(Zver z1, Zver z2) {
						if (z1.place.compareTo(z2.place) > 0) {
							return 1;
						} else {
							if (z1.place.compareTo(z2.place) < 0) {
								return -1;
							} else {
								if (z1.name.compareTo(z2.name) > 0) {
									return 1;
								} else {
									if (z1.name.compareTo(z2.name) < 0) {
										return -1;
									} else {
										return 0;
									}
								}
							}
						}
					}
				});
				DefaultListModel<Zver> placeModel = new DefaultListModel<>();
				for (int i = 0; i < sortedList2.size(); i++) {
					placeModel.addElement(sortedList2.get(i));
				}

				JList<Zver> placeList = new JList<>(placeModel);
				if (!sortedList2.isEmpty()) {
					thirdPanel.add(placeList);
					JScrollPane scrollPane1 = new JScrollPane(placeList);
					scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
					scrollPane1.setPreferredSize(new Dimension(500, 200));
					secondPanel.add(scrollPane1);
				}
				pack();
			}
		});

		byMass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Zver> sortedList1 = (ArrayList<Zver>) baseList.clone();
				Collections.sort(sortedList1, new Comparator<Zver>() {
					public int compare(Zver z1, Zver z2) {
						if (z1.countMass() > z2.countMass()) {
							return 1;
						} else {
							if (z1.countMass() < z2.countMass()) {
								return -1;
							} else {
								return 0;
							}
						}
					}
				});
				DefaultListModel<Zver> massModel = new DefaultListModel<>();
				for (int i = 0; i < sortedList1.size(); i++) {
					massModel.addElement(sortedList1.get(i));
				}

				JList<Zver> massList = new JList<>(massModel);
				if (!sortedList1.isEmpty()) {
					thirdPanel.add(massList);
					JScrollPane scrollPane1 = new JScrollPane(massList);
					scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
					scrollPane1.setPreferredSize(new Dimension(500, 200));
					thirdPanel.add(scrollPane1);
				}
				pack();
			}
		});

		places.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultListModel<String> placeModel = new DefaultListModel<>();
				for (Map.Entry<String, Integer> ent : baseMap.entrySet()) {
					placeModel.addElement(ent.getKey());
				}
				JList<String> placeList = new JList<>(placeModel);
				panel5.add(placeList);
				JScrollPane scrollPane2 = new JScrollPane(placeList);
				scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				scrollPane2.setPreferredSize(new Dimension(200, 100));
				panel5.add(scrollPane2);
			}
		});

		kol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s;
				s = JOptionPane.showInputDialog(tabbedPane, "Place: ");
				if (s == null)
					return;
				else {
					if (s.equals("")) {
						JOptionPane.showMessageDialog(tabbedPane, "Empty input!");
					} else {

						if (baseMap.containsKey(s))
							JOptionPane.showMessageDialog(tabbedPane, "Таких зверей " + baseMap.get(s), "Search",
									JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(tabbedPane, "Таких зверей нет");
					}
				}
			}
		});
	}
}
