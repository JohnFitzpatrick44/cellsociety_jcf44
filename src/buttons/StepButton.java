package buttons;
import View.MainView;
import gridTypes.Grid;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

/*
 * PlayButton class that inherits the ActionButton
 * Creates a PlayButton action that specifically increments after each step
 * @author Ryan Fu
 */
public class StepButton extends ActionButton{
				
	private final String BUTTON_NAME = "STEP";

	public StepButton(Color buttonColor) {
		super(buttonColor);
		this.setButtonText(BUTTON_NAME);
		this.setStepEvent();
	}
	/*
	 * private method to set the action event to play
	 */
	private void setStepEvent() {
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        step(); //activate the play method
		    }
		});
	}
	private void step() {
		Grid.updateStates(MainView.myCellGrid);
	}
}

