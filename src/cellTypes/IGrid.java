package cellTypes;

public interface IGrid {
	
	public void updateNeighborStates();
	
	public void updateState();
	
	public void setState(int state);
	
	public void setNeighbor(Cell c);
	
	public void setX(double x);
	
	public void setY(double y);
	
	public void setWidth(double w);
	
	public void setHeight(double h);
	
}
