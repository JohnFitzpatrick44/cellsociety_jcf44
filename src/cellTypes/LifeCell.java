package cellTypes;

import java.util.ArrayList;

import XML.DataHolder;
import javafx.scene.paint.Paint;

import java.awt.Color;

public class LifeCell extends Cell {
	
	public static final Color DEAD_COLOR = DataHolder.getDeadColor();
	public static final Color ALIVE_COLOR = DataHolder.getAliveColor();
	
	private int state;
	
	private Paint getPaint(Color color) {
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		int a = color.getAlpha();
		double opacity = a/255.0;
		javafx.scene.paint.Color newColor = javafx.scene.paint.Color.rgb(r, g, b, opacity);
		return newColor;
	}
	
	public LifeCell(int x, int y, int width, int height, int state) {
		this(x, y, width, height);
		setState(state);
		if(state == 0) this.setFill(getPaint(DEAD_COLOR));
		else this.setFill(getPaint(ALIVE_COLOR));
	}
	
	public LifeCell(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.setFill(getPaint(DEAD_COLOR));
		this.setFill(getPaint(ALIVE_COLOR));
	}
	
	public LifeCell() {
		this(0, 0, 0, 0);
	}

	public void updateState() {
		int numAlive = sumArray(this.getNeighborStates());
		if(this.getState() == 1) {
			if(numAlive <= 1 || numAlive > 3) {
				this.setState(0);
			}
		} else if(this.getState() == 0) {
			if(numAlive == 3) {
				this.setState(1);
			}
		}
	}
	
	public void setState(int state) {
		this.state = state;
		if(state==1) {
			this.setFill(getPaint(ALIVE_COLOR));
		} else if(state==0){
			this.setFill(getPaint(DEAD_COLOR));
		}
	}
	
	public int getState() {
		return state;
	}
	
	private int sumArray(ArrayList<Integer> arr) {
		int sum = 0;
		for(int x : arr) sum += x;
		return sum;
	}
	
}
