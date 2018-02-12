package rectCells;

import java.util.ArrayList;

import View.MainView;

public class SugarAgentMover {

	private ArrayList<SugarAgent> agents;
	
	public SugarAgentMover() {
		agents = new ArrayList<>();
	}
	
	public void addAgent(SugarAgent sa) {
		agents.add(sa);
		MainView.getGroup().getChildren().add(sa);
	}
	
	public void removeAgent(SugarAgent sa) {
		if(agents.contains(sa)) {
			agents.remove(sa);
			MainView.getGroup().getChildren().remove(sa);
		}
	}
	
	public void updateAgents() {
		for(int k = agents.size()-1; k >= 0; k--) {
			agents.get(k).updateState();
		}
		
		for(int k = 0; k < agents.size(); k++) {
			for(int j = 0; j < agents.size(); j++) {
				if(areNeighbors(agents.get(k), agents.get(j))) {
					if(agents.get(k).isFertile() && agents.get(j).isFertile() && (agents.get(k).isFemale() ^ agents.get(j).isFemale())) {
					}
				}
			}
		}
		
	}
	
	private boolean areNeighbors(SugarAgent a, SugarAgent b) {
		double xDist = Math.abs(a.getCenterX() - b.getCenterX());
		double yDist = Math.abs(a.getCenterY() - b.getCenterY());
		double cellWidth = Math.abs(a.getCell().getPoints().get(0) - a.getCell().getPoints().get(2));
		double cellHeight = Math.abs(a.getCell().getPoints().get(1) - a.getCell().getPoints().get(3));
		System.out.println("Sexy xDist: " + xDist + ", cellWidth: " + cellWidth + " yDist: " + yDist + ", cellHeight: " + cellHeight);
		return (xDist <= cellWidth * 1.1 || yDist <= cellHeight * 1.1);
	}
	
}
