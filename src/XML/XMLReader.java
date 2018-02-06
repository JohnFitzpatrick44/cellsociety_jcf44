package XML;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.scene.paint.Color;

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
			NodeList nList = doc.getElementsByTagName("type");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					DataHolder.TYPE = eElement.getAttribute("name");
					DataHolder.AUTHOR = eElement.getAttribute("author");
					DataHolder.DIMENSIONS = Integer.parseInt(eElement.getElementsByTagName("dimensions").item(0).getTextContent());
					
					if (DataHolder.TYPE.equals("Game Of Life")) {
						DataHolder.ALIVE_COLOR = hex2Rgb(eElement.getElementsByTagName("alive").item(0).getTextContent());
						DataHolder.DEAD_COLOR = hex2Rgb(eElement.getElementsByTagName("dead").item(0).getTextContent());
						DataHolder.PERCENTDEAD = Double.parseDouble(eElement.getElementsByTagName("percentDead").item(0).getTextContent());
					}
					
					if (DataHolder.TYPE.equals("Spreading Fire")) {
						DataHolder.BURNT_COLOR = hex2Rgb(eElement.getElementsByTagName("empty").item(0).getTextContent());
						DataHolder.BURNING_COLOR = hex2Rgb(eElement.getElementsByTagName("burning").item(0).getTextContent());
						DataHolder.TREE_COLOR = hex2Rgb(eElement.getElementsByTagName("tree").item(0).getTextContent());
						DataHolder.PROB_CATCH = Double.parseDouble(eElement.getElementsByTagName("probCatch").item(0).getTextContent());
					}
					
					if(DataHolder.TYPE.equals("Segregation")) {
						DataHolder.A_COLOR = hex2Rgb(eElement.getElementsByTagName("acolor").item(0).getTextContent());
						DataHolder.B_COLOR = hex2Rgb(eElement.getElementsByTagName("bcolor").item(0).getTextContent());
						DataHolder.NEUTRAL_COLOR = hex2Rgb(eElement.getElementsByTagName("neutral").item(0).getTextContent());
					}
					
					if(DataHolder.TYPE.equals("Predator")) {
						DataHolder.PRED_COLOR = hex2Rgb(eElement.getElementsByTagName("predColor").item(0).getTextContent());
						DataHolder.PREY_COLOR = hex2Rgb(eElement.getElementsByTagName("preyColor").item(0).getTextContent());
						DataHolder.WATER_COLOR = hex2Rgb(eElement.getElementsByTagName("waterColor").item(0).getTextContent());
						DataHolder.PREY_REPRODUCTION = Integer.parseInt(eElement.getElementsByTagName("preyReproduction").item(0).getTextContent());
						DataHolder.PRED_ENERGY = Integer.parseInt(eElement.getElementsByTagName("predEnergy").item(0).getTextContent());
						DataHolder.ENERGY_GAIN = Integer.parseInt(eElement.getElementsByTagName("energyGain").item(0).getTextContent());
						DataHolder.PRED_REPRODUCTION = Integer.parseInt(eElement.getElementsByTagName("predReproduction").item(0).getTextContent());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Color hex2Rgb(String colorStr) {
	    return Color.rgb(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
	
} 
