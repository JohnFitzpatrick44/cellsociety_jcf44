package buttons;
import View.ChartView;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

/*
 * PlayButton class that inherits the ActionButton
 * Creates a PlayButton action that specifically resets the grid simulation
 * @author Ryan Fu
 */
public class ResetButton extends ActionButton{

	private final String BUTTON_NAME = myResources.getString("Reset");

	public ResetButton(Color buttonColor) {
		super(buttonColor);
		this.setButtonText(BUTTON_NAME);
		this.setResetEvent();
	}
	/*
	 * private method to set the action event to play
	 */
	private void setResetEvent() {
		this.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				reset(); //activate the play method
			}
		});
	}

	public static void reset() {
		setPlayBoolean(false);
		MainView.switchSimulation();
		
	}
}
