package agents;

import java.util.ArrayList;

public class AntAgentMover {
	
	ArrayList<AntAgent> ants;
	
	public AntAgentMover() {
		ants = new ArrayList<>();
	}
	
	public void addAnt(AntAgent a) {
		ants.add(a);
	}
	
	public void removeAnt(AntAgent a) {
		if(ants.contains(a)) {
			ants.remove(a);
		}
	}
	
	public void updateAnts() {
		for(AntAgent a : ants) {
			a.updateState();
		}
	}
	
}
