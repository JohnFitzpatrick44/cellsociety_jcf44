package buttons;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
/*
 * SpeedButton class that inherits the ActionButton
 * Creates a button action that increases the speed of the animation.
 * @author Ryan Fu
 */
public class SlowButton extends ActionButton{
	
	private final String BUTTON_NAME = myResources.getString("Slow");

	public SlowButton(Color buttonColor) {
		super(buttonColor);
		this.setButtonText(BUTTON_NAME);
		this.setSlowEvent();
	}
	
	
	/*
	 * private method to set the action event to speed
	 */

	private void setSlowEvent() {
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        slow(); //activate the play method
		    }
		});
	}
	private void slow() {
		MainView.multiplyAnimationRate(0.5);
	}
}
