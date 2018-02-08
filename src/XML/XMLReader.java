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
					DataHolder.setType(eElement.getAttribute("name"));
					DataHolder.setAuthor(eElement.getAttribute("author"));
					DataHolder.setDimensions(Integer.parseInt(eElement.getElementsByTagName("dimensions").item(0).getTextContent()));
					
					if (DataHolder.getType().equals("Game Of Life")) {
						DataHolder.setAliveColor(hex2Rgb(eElement.getElementsByTagName("alive").item(0).getTextContent()));
						DataHolder.setDeadColor(hex2Rgb(eElement.getElementsByTagName("dead").item(0).getTextContent()));
						DataHolder.setPercentDead(Double.parseDouble(eElement.getElementsByTagName("percentDead").item(0).getTextContent()));
						DataHolder.setLifeGrid(eElement.getElementsByTagName("grid").item(0).getTextContent());
					}
					
					if (DataHolder.getType().equals("Spreading Fire")) {
						DataHolder.setBurntColor(hex2Rgb(eElement.getElementsByTagName("empty").item(0).getTextContent()));
						DataHolder.setBurningColor(hex2Rgb(eElement.getElementsByTagName("burning").item(0).getTextContent()));
						DataHolder.setTreeColor(hex2Rgb(eElement.getElementsByTagName("tree").item(0).getTextContent()));
						DataHolder.setProbCatch(Double.parseDouble(eElement.getElementsByTagName("probCatch").item(0).getTextContent()));
						DataHolder.setFireGrid(eElement.getElementsByTagName("grid").item(0).getTextContent());
					}
					
					if(DataHolder.getType().equals("Segregation")) {
						DataHolder.setAColor(hex2Rgb(eElement.getElementsByTagName("acolor").item(0).getTextContent()));
						DataHolder.setBColor(hex2Rgb(eElement.getElementsByTagName("bcolor").item(0).getTextContent()));
						DataHolder.setNeutralColor(hex2Rgb(eElement.getElementsByTagName("neutral").item(0).getTextContent()));
						DataHolder.setSegGrid(eElement.getElementsByTagName("grid").item(0).getTextContent());
					}
					
					if(DataHolder.getType().equals("Predator")) {
						DataHolder.setPredColor(hex2Rgb(eElement.getElementsByTagName("predColor").item(0).getTextContent()));
						DataHolder.setPreyColor(hex2Rgb(eElement.getElementsByTagName("preyColor").item(0).getTextContent()));
						DataHolder.setWaterColor(hex2Rgb(eElement.getElementsByTagName("waterColor").item(0).getTextContent()));
						DataHolder.setPreyProduction(Integer.parseInt(eElement.getElementsByTagName("preyReproduction").item(0).getTextContent()));
						DataHolder.setPredEnergy(Integer.parseInt(eElement.getElementsByTagName("predEnergy").item(0).getTextContent()));
						DataHolder.setEnergyGain(Integer.parseInt(eElement.getElementsByTagName("energyGain").item(0).getTextContent()));
						DataHolder.setPredReproduction(Integer.parseInt(eElement.getElementsByTagName("predReproduction").item(0).getTextContent()));
						DataHolder.setPredGrid(eElement.getElementsByTagName("grid").item(0).getTextContent());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("variable can not be read");
		}
	}

	public static Color hex2Rgb(String colorStr) {
	    return Color.rgb(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
	
} 
