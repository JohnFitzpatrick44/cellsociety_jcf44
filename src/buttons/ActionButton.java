package buttons;
import java.util.ResourceBundle;

import View.MainTriangleView;
import View.MainView;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

/**
 * ActionButton inherits from the Button class 
 * and acquires all the functionalities of the Button Class
 * @author Ryan Fu
 *
 */
public abstract class ActionButton extends Button{
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private static final String RESOURCE_FILE = "OriginalGUI";
	private String buttonName;
	public static final ResourceBundle myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE+RESOURCE_FILE);
	/*
	 * Constructor for the ActionButton
	 * @parameters buttonName takes in a string for the name of the button
	 * Can add parameters and methods to add more features to the Action Button
	 * which will improve the flexilibity of the button.
	 * 
	 */
	public ActionButton(Color buttonColor) {
//		this.buttonName = buttonName;
//		setButtonText(this.buttonName);
		setButtonFill(buttonColor);
	}
	/*
	 * public method to set the name of the text
	 */
	public void setButtonText(String buttonName) {
		this.setText(buttonName);
	}
	
	/*
	 * sets the color of the button Fill
	 */
	
	private void setButtonFill(Color buttonColor) {
		this.setTextFill(buttonColor);
	}
	/*
	 * Method that sets the X position of the ActionButton
	 * @parameter takes in an integer for the x position
	 */
	
	public void setPosition(int x, int y ) {
		this.setLayoutX(x);
		this.setLayoutY(y);
	}

	/*
	 * returns the name of the button
	 */
	public String getButtonText() {
		return buttonName;
	}
	//return the state of the playBoolean
	public Boolean getPlayBoolean () {
		return MainTriangleView.isPlaying();
	}
	
	//setter for boolean 
	public static Boolean setPlayBoolean(Boolean state) {
	        MainTriangleView.setPlaying(state);
	        return state;
	}

}
