import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileReader {
	private File file;

	public FileReader(String filename) {
		super();
		this.file = new File(filename);
	}

	public List<Zver> read() throws ReadingFileException {
		List<Zver> list = new ArrayList<Zver>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new ReadingFileException("Can't create parser");
		}
		Document doc;
		try {
			doc = db.parse(this.file);
		} catch (SAXException | IOException e) {
			throw new ReadingFileException("Can't parse document:" + this.file.getAbsolutePath());
		}

		doc.getDocumentElement().normalize();

		NodeList nodeLst = doc.getElementsByTagName("zver");

		for (int i = 0; i < nodeLst.getLength(); i++) {
			Node curNode = nodeLst.item(i);
			if (curNode.getNodeType() == Node.ELEMENT_NODE) {
				Element el = (Element) curNode;

				NodeList nameList = el.getElementsByTagName("name");
				Element nameElemContent = (Element) nameList.item(0);
				String name = nameElemContent.getFirstChild().getNodeValue();

				NodeList placeList = el.getElementsByTagName("place");
				Element placeElemContent = (Element) placeList.item(0);
				String place = placeElemContent.getFirstChild().getNodeValue();

				NodeList foodList = el.getElementsByTagName("food");
				Element foodElemContent = (Element) foodList.item(0);
				String food = foodElemContent.getFirstChild().getNodeValue();

				list.add(new Zver(name, place, food));
			}
		}
		return list;
	}
}
