import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLReader {
	public static void main(String argv[]){
	try {
		File xmlFile = new File("/Users/Ryan/cs308/cellsociety_team03/data/GameOfLife.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("type");

		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				System.out.println("Type : " + eElement.getAttribute("name"));
				System.out.println("Dimensions : " + eElement.getElementsByTagName("dimensions").item(0).getTextContent());
				System.out.println("States : " + eElement.getElementsByTagName("states").item(0).getTextContent());
				System.out.println("Color : " + eElement.getAttribute("color"));
				System.out.println("Animation Time : " + eElement.getElementsByTagName("animation").item(0).getTextContent());
				System.out.println("Percent Dead : " + eElement.getElementsByTagName("percentDead").item(0).getTextContent());

			}
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
}} 
