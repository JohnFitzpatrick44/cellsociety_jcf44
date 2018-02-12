package buttons;

import View.MainView;

import javafx.scene.control.Slider;

/*
 * Slider that controls the speed of the animation based on the slider position
 * @author Ryan Fu
 */

public class SpeedSlider extends Slider{
	public SpeedSlider(double minsliderspeed, double maxsliderspeed, double defaultsliderspeed) {
		this.setMin(minsliderspeed);
		this.setMax(maxsliderspeed);
		this.setShowTickLabels(true);
		this.setShowTickMarks(true);
		this.setMajorTickUnit(50);
		this.setValue(defaultsliderspeed);
	     this.valueProperty().addListener((obs, oldval, newVal)->
	     	MainView.setAnimationRate(newVal.doubleValue()));

	}
	
	public void setPosition(int x, int y) {
		this.setLayoutX(x);
		this.setLayoutY(y);
	}
	
	
}
