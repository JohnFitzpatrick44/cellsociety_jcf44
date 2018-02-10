package buttons;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
/*
 * SpeedButton class that inherits the ActionButton
 * Creates a Speedbutton action that increases the speed of the animation.
 * @author Ryan Fu
 */
public class SpeedButton extends ActionButton{
	
	private final String BUTTON_NAME = myResources.getString("Speed");

	private static final double SPEED_AMOUNT = 2;
	
	public SpeedButton(Color buttonColor) {
		super(buttonColor);
		this.setButtonText(BUTTON_NAME);
		this.setPlayEvent();
	}
	
	
	/*
	 * private method to set the action event to speed
	 */

	private void setPlayEvent() {
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        speed(); //activate the play method
		    }
		});
	}
	private void speed() {
		MainView.setAnimationRate(SPEED_AMOUNT);
	}
}
