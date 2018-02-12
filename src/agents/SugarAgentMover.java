package agents;

import java.util.ArrayList;

import View.MainView;
import rectCells.SugarCell;

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
				checkFertility(agents.get(k), agents.get(j));
			}
		}
		
	}
	
	private void checkFertility(SugarAgent a, SugarAgent b) {
		if(areNeighbors(a, b)) {
			if(a.isFertile() && b.isFertile() && (a.isFemale() ^ b.isFemale())) {
				findFreeSpot(a, b);
			}
		}
	}
	
	private void findFreeSpot(SugarAgent a, SugarAgent b) {
		SugarCell freeSpot = a.findSpot();
		if(freeSpot == null) {
			freeSpot = b.findSpot();
		}
		if(freeSpot != null) {
			a.reproduce();
			b.reproduce();
			SugarAgent baby = new SugarAgent(freeSpot, a.getVision(), b.getMetabolism(), a.getInitialSugar());
			addAgent(baby);
			baby.addSAM(this);
		}
	}
	
	private boolean areNeighbors(SugarAgent a, SugarAgent b) {
		double xDist = Math.abs(a.getCenterX() - b.getCenterX());
		double yDist = Math.abs(a.getCenterY() - b.getCenterY());
		double cellWidth = Math.abs(a.getCell().getPoints().get(0) - a.getCell().getPoints().get(2));
		return (xDist <= cellWidth && yDist == 0) || (xDist == 0 && yDist <= cellWidth);
	}
	
}
