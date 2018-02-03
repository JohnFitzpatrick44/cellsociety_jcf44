package buttons;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

/*
 * PlayButton class that inherits the ActionButton
 * Creates a PlayButton action that specifically increments after each step
 * @author Ryan Fu
 */
public class StepButton extends ActionButton{
				
	private final String buttonName = "STEP";

	public StepButton(Color buttonColor) {
		super(buttonColor);
		// TODO Auto-generated constructor stub
		this.setButtonText(buttonName);
		this.setStepEvent();
	}
	/*
	 * private method to set the action event to play
	 */
	private void setStepEvent() {
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        //step(); activate the play method
		    }
		});
	}
}

