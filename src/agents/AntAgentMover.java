package agents;

import java.util.ArrayList;

import View.MainView;

/**
 * Class to update ants in simulation
 * @author team_03
 */
public class AntAgentMover {
	
	private ArrayList<AntAgent> ants;
	
	public AntAgentMover() {
		ants = new ArrayList<>();
	}
	
	public void addAnt(AntAgent a) {
		ants.add(a);
		MainView.getGroup().getChildren().add(a);
	}
	
	public void removeAnt(AntAgent a) {
		if(ants.contains(a)) {
			ants.remove(a);
			MainView.getGroup().getChildren().remove(a);
		}
	}
	
	public void updateAnts() {
		for(AntAgent a : ants) {
			a.updateState();
		}
	}
	
}
