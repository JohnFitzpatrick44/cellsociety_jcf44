package gridTypes;

import cellTypes.TriangleCell;

public abstract class TriangleGrid {

	public abstract TriangleCell[][] createGrid(double offset, int gridSize, double side, double cutOff);

}
