package cellTypes;

public interface IGrid {

	public void updateNeighborStates();

	public void updateState();

	public void setNeighbor(Cell c);

}
