package buttons;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * PlayButton class that inherits the ActionButton
 * Creates a PlayButton action that opens up another window for comparison.
 * @author Ryan Fu
 */
public class CompareButton extends ActionButton{

	private final String BUTTON_NAME = myResources.getString("Compare");

	public CompareButton(Color buttonColor) {
		super(buttonColor);
		this.setButtonText(BUTTON_NAME);
		this.setCompareEvent();
	}
	/*
	 * private method to set the action event to play
	 */
	private void setCompareEvent() {
		this.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				compare();// activate the play method
			}
		});
	}

	private void compare() {
		MainView secondSimulation = new MainView();
		Stage secondStage = new Stage();
		secondStage.setScene(secondSimulation.initializeStartScene());
		secondStage.show();


	}
}
