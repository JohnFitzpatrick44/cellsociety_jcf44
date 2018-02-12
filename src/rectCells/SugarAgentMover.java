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
	}
	
}
