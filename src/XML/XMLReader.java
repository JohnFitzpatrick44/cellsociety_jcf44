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

	//DEFAULT PRIVATE VARIABLES FOR ALL SIMULATIONS
	private Color aliveColor;
	private Color deadColor;		
	private Double percentDead;
	private String lifeGrid;
	private Color burntColor;
	private Color burningColor;
	private Color treeColor;
	private Double probCatch;
	private String fireGrid;

	private Color aColor;
	private Color bColor;
	private Color neutralColor;
	private String segGrid;

	private Color predColor;
	private Color preyColor;
	private Color waterColor;
	private 	int preyProduction;
	private int predEnergy;
	private int energyGain;
	private 	int predReproduction;
	private 	String predGrid;	
	
	public XMLReader(File inputFile) {
		try {
			parse(inputFile);
		} catch (Exception e) {
			System.out.println("Trouble parsing XML file, " + e.toString());
		}
	}

	private void createDefaultValues() {
		System.out.println("blah");
		aliveColor = Color.BLACK;
		deadColor=Color.WHITE;		
		percentDead = 20.0;
		lifeGrid ="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 1 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 0 1 0 0 0 1 0 1 1 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1";

		burntColor=Color.YELLOW;
		burningColor=Color.RED;
		treeColor=Color.GREEN;
		probCatch=0.5;
		fireGrid ="1 1 1 1 2 2 1 1 1 1 1 1 1 1 2 2 2 2 2 1 1 1 1 2 2 2 1";

		aColor=Color.BLUE;
		bColor=Color.RED;
		neutralColor=Color.WHITE;
		segGrid = "0 1 0 1 2 1 0 0 2 0 1 0 2 2 1 0 0 1 0 2 0 0 0 0 0 0 1";

		predColor=Color.GREEN;
		preyColor=Color.PURPLE;
		waterColor=Color.RED;
		preyProduction=5;
		predEnergy = 5;
		energyGain=2;
		predReproduction=2;
		predGrid="0 1 0 1 2 1 0 0 2 0 1 0 2 2 1 0 0 1 0 2 1 1 1 1 1 1 1 1 1 0 1 2 1 2 2 2 0 1 0 2 2 1 0 0 1 0 2 0 0 0 0 0 0 1 0 1 0 1 2 1 0 0 2 0 1 0 2 2 1 0 0 1 0 2 0 0 0 0 0 0 1 0 1 0 1 2 1 0 0 2 0 1 0 2 2 1 0 0 1 0 2 0 0 0 0 0 0 1";
	}
	
	private void parse(File xmlFile) throws XMLException, ParserConfigurationException, SAXException, IOException {
		//try {
		
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("type");
			System.out.print(nList.item(0));
			for (int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					DataHolder.setType(eElement.getAttribute("name"));
					DataHolder.setAuthor(eElement.getAttribute("author"));
					DataHolder.setDimensions(Integer.parseInt(eElement.getElementsByTagName("dimensions").item(0).getTextContent()));
					
					if (DataHolder.getType().equals("Game Of Life")) {
						aliveColor = hex2Rgb(eElement.getElementsByTagName("alive").item(0).getTextContent());
						deadColor=hex2Rgb(eElement.getElementsByTagName("dead").item(0).getTextContent());		
						percentDead = Double.parseDouble(eElement.getElementsByTagName("percentDead").item(0).getTextContent());
						lifeGrid =(eElement.getElementsByTagName("grid").item(0).getTextContent());
						LifeHolder.setGameOfLife(aliveColor, deadColor, percentDead, lifeGrid);
					}
					
					else if (DataHolder.getType().equals("Spreading Fire")) {
						burntColor=(hex2Rgb(eElement.getElementsByTagName("empty").item(0).getTextContent()));
						burningColor=(hex2Rgb(eElement.getElementsByTagName("burning").item(0).getTextContent()));
						treeColor=(hex2Rgb(eElement.getElementsByTagName("tree").item(0).getTextContent()));
						probCatch=(Double.parseDouble(eElement.getElementsByTagName("probCatch").item(0).getTextContent()));
						fireGrid =(eElement.getElementsByTagName("grid").item(0).getTextContent());
						FireHolder.setSpreadingFire(burntColor, burningColor, treeColor, probCatch, fireGrid);
					}
					
					else if(DataHolder.getType().equals("Segregation")) {
						aColor=(hex2Rgb(eElement.getElementsByTagName("acolor").item(0).getTextContent()));
						bColor=(hex2Rgb(eElement.getElementsByTagName("bcolor").item(0).getTextContent()));
						neutralColor=(hex2Rgb(eElement.getElementsByTagName("neutral").item(0).getTextContent()));
						String segGrid = (eElement.getElementsByTagName("grid").item(0).getTextContent());
						SegregationHolder.setSegregation(aColor, bColor, neutralColor, segGrid);
					}
					
					else if(DataHolder.getType().equals("Predator")) {
						try {
						System.out.println("alsdkfjls");
						predColor=(hex2Rgb(eElement.getElementsByTagName("predColor").item(0).getTextContent()));
						preyColor=(hex2Rgb(eElement.getElementsByTagName("preyColor").item(0).getTextContent()));
						waterColor=(hex2Rgb(eElement.getElementsByTagName("waterColor").item(0).getTextContent()));
						System.out.println(waterColor);
						preyProduction=(Integer.parseInt(eElement.getElementsByTagName("preyReproduction").item(0).getTextContent()));
						predEnergy = (Integer.parseInt(eElement.getElementsByTagName("predEnergy").item(0).getTextContent()));
						energyGain=(Integer.parseInt(eElement.getElementsByTagName("energyGain").item(0).getTextContent()));
						predReproduction=(Integer.parseInt(eElement.getElementsByTagName("predReproduction").item(0).getTextContent()));
						predGrid=(eElement.getElementsByTagName("grid").item(0).getTextContent());
						PredPreyHolder.setPredPreyColor(predColor, preyColor, waterColor);
						PredPreyHolder.setPredPreyParams(preyProduction, predEnergy, energyGain, predReproduction, predGrid);
						}
						catch(Exception e){
							createDefaultValues();
							PredPreyHolder.setPredPreyColor(predColor, preyColor, waterColor);
							PredPreyHolder.setPredPreyParams(preyProduction, predEnergy, energyGain, predReproduction, predGrid);
							System.out.print("error");
						}
						
						
					}
					
					else if (DataHolder.getType().equals("SugarScape")) {
						burntColor=(hex2Rgb(eElement.getElementsByTagName("empty").item(0).getTextContent()));
						burningColor=(hex2Rgb(eElement.getElementsByTagName("burning").item(0).getTextContent()));
						treeColor=(hex2Rgb(eElement.getElementsByTagName("tree").item(0).getTextContent()));
						probCatch=(Double.parseDouble(eElement.getElementsByTagName("probCatch").item(0).getTextContent()));
						fireGrid =(eElement.getElementsByTagName("grid").item(0).getTextContent());
						SugarHolder.setSpreadingFire(burntColor, burningColor, treeColor, probCatch, fireGrid);
					}
					
					else {
						System.out.println("WRONG SIMULATION NAME"); //ERROR CHECKING IF WRONG SIMULATION IS TYPED
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
