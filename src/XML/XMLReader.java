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
	
	private int colorOne;
	private int colorTwo;
	private int colorThree;
	private int growthRate;
	private int growthInterval;
	private String sugarGrid;

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
		predEnergy = 2;
		energyGain=2;
		predReproduction=2;
		predGrid="0 1 0 1 2 1 0 0 2 0 1 0 2 2 1 0 0 1 0 2 1 1 1 1 1 1 1 1 1 0 1 2 1 2 2 2 0 1 0 2 2 1 0 0 1 0 2 0 0 0 0 0 0 1 0 1 0 1 2 1 0 0 2 0 1 0 2 2 1 0 0 1 0 2 0 0 0 0 0 0 1 0 1 0 1 2 1 0 0 2 0 1 0 2 2 1 0 0 1 0 2 0 0 0 0 0 0 1";
	
		colorOne = 255;
		colorTwo = 255;
		colorThree = 255;
		growthRate = 5;
		growthInterval = 1;
		sugarGrid = "5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5\n" + 
				"			  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  10 10 10 10 10 10 10 10 5  5\n" + 
				"			  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  10 20 20 20 20 20 20 20 20 10 5\n" + 
				"			  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  10 20 20 20 20 50 50 20 20 20 20 10\n" + 
				"			  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  10 20 20 20 50 100 100 50 20 20 20 10\n" + 
				"			  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  10 20 20 20 50 100 100 50 20 20 20 10\n" + 
				"			  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  10 20 20 20 20 50 50 20 20 20 20 10\n" + 
				"			  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  10 20 20 20 20 20 20 20 20 10 5\n" + 
				"			  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  10 10 10 10 10 10 10 10 5  5\n" + 
				"			  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5\n" + 
				"			  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5\n" + 
				"			  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5\n" + 
				"			  5  5  5  5  5  5  10 10 10 10 10 10 10 10 5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5\n" + 
				"			  5  5  10 10 10 20 20 20 20 20 20 20 20 10 10 10 5  5  5  5  5  5  5  5  5  5  5  5  5  5\n" + 
				"			  10 10 20 20 20 20 50 50 20 20 20 20 10 10 10 10 5  5  5  5  5  5  5  5  5  5  5  5  5  5\n" + 
				"			  10 20 20 20 50 50 50 100 100 50 50 20 20 20 10  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5\n" + 
				"			  10 20 20 20 50 100 100 100 100 50 20 20 20 10  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5\n" + 
				"			  10 20 20 20 20 50 100 100 50 20 20 20 20 10 5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5\n" + 
				"			  5  10 20 20 20 20 20 20 20 20 10 5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5  5\n" + 
				"			  5  5  10 10 10 10 10 10 10 10 5  5";
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
					try {
					aliveColor = hex2Rgb(eElement.getElementsByTagName("alive").item(0).getTextContent());
					deadColor=hex2Rgb(eElement.getElementsByTagName("dead").item(0).getTextContent());		
					percentDead = Double.parseDouble(eElement.getElementsByTagName("percentDead").item(0).getTextContent());
					lifeGrid =(eElement.getElementsByTagName("grid").item(0).getTextContent());
					LifeHolder.setGameOfLife(aliveColor, deadColor, percentDead, lifeGrid);
					}
					catch(Exception e) {
						createDefaultValues();				
					}
					LifeHolder.setGameOfLife(aliveColor, deadColor, percentDead, lifeGrid);

				}

				else if (DataHolder.getType().equals("Spreading Fire")) {
					try {
					burntColor=(hex2Rgb(eElement.getElementsByTagName("empty").item(0).getTextContent()));
					burningColor=(hex2Rgb(eElement.getElementsByTagName("burning").item(0).getTextContent()));
					treeColor=(hex2Rgb(eElement.getElementsByTagName("tree").item(0).getTextContent()));
					probCatch=(Double.parseDouble(eElement.getElementsByTagName("probCatch").item(0).getTextContent()));
					fireGrid =(eElement.getElementsByTagName("grid").item(0).getTextContent());				
					}
					catch(Exception e) {
						createDefaultValues();				
					}
					FireHolder.setSpreadingFire(burntColor, burningColor, treeColor, probCatch, fireGrid);
				}

				else if(DataHolder.getType().equals("Segregation")) {
					try {
						aColor=(hex2Rgb(eElement.getElementsByTagName("acolor").item(0).getTextContent()));
						bColor=(hex2Rgb(eElement.getElementsByTagName("bcolor").item(0).getTextContent()));
						neutralColor=(hex2Rgb(eElement.getElementsByTagName("neutral").item(0).getTextContent()));
						segGrid = (eElement.getElementsByTagName("grid").item(0).getTextContent());

					}catch(Exception e) {
						createDefaultValues();				
					}
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
						System.out.println("went through");
						System.out.println(predEnergy);
					}
					catch(Exception e){
						createDefaultValues();
						PredPreyHolder.setPredPreyColor(predColor, preyColor, waterColor);
						PredPreyHolder.setPredPreyParams(preyProduction, predEnergy, energyGain, predReproduction, predGrid);
						System.out.print("error");
						System.out.println(predEnergy);
						e.printStackTrace();
					}

				}				
				else if (DataHolder.getType().equals("SugarScape")) {
					colorOne=(Integer.parseInt(eElement.getElementsByTagName("colorOne").item(0).getTextContent()));
					colorTwo=(Integer.parseInt(eElement.getElementsByTagName("colorTwo").item(0).getTextContent()));
					colorThree=(Integer.parseInt(eElement.getElementsByTagName("colorThree").item(0).getTextContent()));
					growthRate=(Integer.parseInt(eElement.getElementsByTagName("growthRate").item(0).getTextContent()));
					growthInterval=(Integer.parseInt(eElement.getElementsByTagName("growthInterval").item(0).getTextContent()));
					sugarGrid=(eElement.getElementsByTagName("grid").item(0).getTextContent());
					SugarHolder.setSugarScape(colorOne, colorTwo, colorThree, growthRate, growthInterval, sugarGrid);
				}

				else if (DataHolder.getType().equals("Bacteria")) {
					aliveColor = hex2Rgb(eElement.getElementsByTagName("alive").item(0).getTextContent());
					deadColor=hex2Rgb(eElement.getElementsByTagName("dead").item(0).getTextContent());		
					percentDead = Double.parseDouble(eElement.getElementsByTagName("percentDead").item(0).getTextContent());
					lifeGrid =(eElement.getElementsByTagName("grid").item(0).getTextContent());
					BacteriaHolder.setGameOfLife(aliveColor, deadColor, percentDead, lifeGrid);
				}
				else {
					System.out.println("WRONG SIMULATION NAME"); //ERROR CHECKING IF WRONG SIMULATION IS TYPED
				}
			}
		}
	}

	public static Color hex2Rgb(String colorStr) {
		return Color.rgb(
				Integer.valueOf( colorStr.substring( COLOR_INDEX_1, COLOR_INDEX_2), COLOR_INDEX_END ),
				Integer.valueOf( colorStr.substring( COLOR_INDEX_2, COLOR_INDEX_3 ), COLOR_INDEX_END ),
				Integer.valueOf( colorStr.substring( COLOR_INDEX_3, COLOR_INDEX_4 ), COLOR_INDEX_END ) );
	}

} 
