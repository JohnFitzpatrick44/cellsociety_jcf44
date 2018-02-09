package XML;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.scene.paint.Color;

public class XMLReader {

	private static final int COLOR_INDEX_1 = 1;
	private static final int COLOR_INDEX_2 = 3;
	private static final int COLOR_INDEX_3 = 5;
	private static final int COLOR_INDEX_4 = 7;
	private static final int COLOR_INDEX_END = 16;

	
	public XMLReader(File inputFile) {
		try {
			parse(inputFile);
		} catch (XMLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parse(File xmlFile) throws XMLException, ParserConfigurationException, SAXException, IOException {
		//try {
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
						Color aliveColor = hex2Rgb(eElement.getElementsByTagName("alive").item(0).getTextContent());
						Color deadColor=hex2Rgb(eElement.getElementsByTagName("dead").item(0).getTextContent());		
						Double percentDead = Double.parseDouble(eElement.getElementsByTagName("percentDead").item(0).getTextContent());
						String lifeGrid =(eElement.getElementsByTagName("grid").item(0).getTextContent());
						LifeHolder.setGameOfLife(aliveColor, deadColor, percentDead, lifeGrid);
					}
					
					else if (DataHolder.getType().equals("Spreading Fire")) {
						Color burntColor=(hex2Rgb(eElement.getElementsByTagName("empty").item(0).getTextContent()));
						Color burningColor=(hex2Rgb(eElement.getElementsByTagName("burning").item(0).getTextContent()));
						Color treeColor=(hex2Rgb(eElement.getElementsByTagName("tree").item(0).getTextContent()));
						Double probCatch=(Double.parseDouble(eElement.getElementsByTagName("probCatch").item(0).getTextContent()));
						String fireGrid =(eElement.getElementsByTagName("grid").item(0).getTextContent());
						FireHolder.setSpreadingFire(burntColor, burningColor, treeColor, probCatch, fireGrid);
					}
					
					else if(DataHolder.getType().equals("Segregation")) {
						Color aColor=(hex2Rgb(eElement.getElementsByTagName("acolor").item(0).getTextContent()));
						Color bColor=(hex2Rgb(eElement.getElementsByTagName("bcolor").item(0).getTextContent()));
						Color neutralColor=(hex2Rgb(eElement.getElementsByTagName("neutral").item(0).getTextContent()));
						String segGrid = (eElement.getElementsByTagName("grid").item(0).getTextContent());
						SegregationHolder.setSegregation(aColor, bColor, neutralColor, segGrid);
					}
					
					else if(DataHolder.getType().equals("Predator")) {
						Color predColor=(hex2Rgb(eElement.getElementsByTagName("predColor").item(0).getTextContent()));
						Color preyColor=(hex2Rgb(eElement.getElementsByTagName("preyColor").item(0).getTextContent()));
						Color waterColor=(hex2Rgb(eElement.getElementsByTagName("waterColor").item(0).getTextContent()));
						int preyProduction=(Integer.parseInt(eElement.getElementsByTagName("preyReproduction").item(0).getTextContent()));
						int predEnergy = (Integer.parseInt(eElement.getElementsByTagName("predEnergy").item(0).getTextContent()));
						int energyGain=(Integer.parseInt(eElement.getElementsByTagName("energyGain").item(0).getTextContent()));
						int predReproduction=(Integer.parseInt(eElement.getElementsByTagName("predReproduction").item(0).getTextContent()));
						String predGrid=(eElement.getElementsByTagName("grid").item(0).getTextContent());
						PredPreyHolder.setPredPreyColor(predColor, preyColor, waterColor);
						PredPreyHolder.setPredPreyParams(preyProduction, predEnergy, energyGain, predReproduction, predGrid);
					}
				}
			}
		//} catch (Exception e) {
			//e.printStackTrace();
		//	System.out.println("variable can not be read");
		//}
	}

	public static Color hex2Rgb(String colorStr) {
	    return Color.rgb(
	            Integer.valueOf( colorStr.substring( COLOR_INDEX_1, COLOR_INDEX_2), COLOR_INDEX_END ),
	            Integer.valueOf( colorStr.substring( COLOR_INDEX_2, COLOR_INDEX_3 ), COLOR_INDEX_END ),
	            Integer.valueOf( colorStr.substring( COLOR_INDEX_3, COLOR_INDEX_4 ), COLOR_INDEX_END ) );
	}
	
} 
