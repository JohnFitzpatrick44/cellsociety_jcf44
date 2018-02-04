package buttons;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

/*
 * PlayButton class that inherits the ActionButton
 * Creates a PlayButton action that jumps to a future frame
 * @author Ryan Fu
 */
public class JumpButton extends ActionButton{
				
	private final String BUTTON_NAME = "JUMP";

	public JumpButton(Color buttonColor) {
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
		        //jump(); activate the play method
		    }
		});
	}
}
