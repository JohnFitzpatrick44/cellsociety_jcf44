package buttons;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
/*
 * PlayButton class that inherits the ActionButton
 * Creates a PlayButton action that specifically plays the grid simulation
 * @author Ryan Fu
 */
public class PlayButton extends ActionButton{
	
	private final String BUTTON_NAME = myResources.getString("Play");

	public PlayButton(Color buttonColor) {
		super(buttonColor);
		this.setButtonText(BUTTON_NAME);
		this.setPlayEvent();
	}
	
	
	/*
	 * private method to set the action event to play
	 */

	private void setPlayEvent() {
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        play(); //activate the play method
		    }
		});
	}
	private void play() {
		setPlayBoolean(true);
	}
}
