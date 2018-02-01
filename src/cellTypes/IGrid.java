package cellTypes;

public interface IGrid {
	
	public void updateNeighborStates();
	
	public void updateState();
	
	public void setState(int state);
	
	public void setNeighbor(Cell c);
	
}
