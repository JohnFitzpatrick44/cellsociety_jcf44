import java.awt.Color;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {

	public XMLReader(File inputFile) {
		parse(inputFile);
	}

	private void parse(File xmlFile) throws XMLException {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("type");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					
					Element eElement = (Element) nNode;
//					System.out.println("Type : " + eElement.getAttribute("name"));
//					System.out.println("Dimensions : " + eElement.getElementsByTagName("dimensions").item(0).getTextContent());
//					System.out.println("States : " + eElement.getElementsByTagName("alive").item(0).getTextContent());
//					System.out.println("States : " + eElement.getElementsByTagName("dead").item(0).getTextContent());
//					System.out.println("Animation Time : " + eElement.getElementsByTagName("animation").item(0).getTextContent());
//					System.out.println("Percent Dead : " + eElement.getElementsByTagName("percentDead").item(0).getTextContent());
					DataHolder.TYPE = eElement.getAttribute("name");
					DataHolder.DIMENSIONS = Integer.parseInt(eElement.getElementsByTagName("dimensions").item(0).getTextContent());
					DataHolder.PERCENTDEAD = Double.parseDouble(eElement.getElementsByTagName("percentDead").item(0).getTextContent());
					DataHolder.ANIMATIONSPEED = Integer.parseInt(eElement.getElementsByTagName("animation").item(0).getTextContent());
					DataHolder.ALIVE_COLOR = hex2Rgb(eElement.getElementsByTagName("alive").item(0).getTextContent());
					DataHolder.DEAD_COLOR = hex2Rgb(eElement.getElementsByTagName("dead").item(0).getTextContent());
					
				

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
	
} 
