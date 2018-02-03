package buttons;
import gridTypes.Grid;
import View.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

/*
 * PlayButton class that inherits the ActionButton
 * Creates a PlayButton action that specifically resets the grid simulation
 * @author Ryan Fu
 */
public class ResetButton extends ActionButton{
				
	private final String buttonName = "RESET";
	
	public ResetButton(Color buttonColor) {
		super(buttonColor);
		// TODO Auto-generated constructor stub
		this.setButtonText(buttonName);
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
	
	private void reset() {
		//
	}
}
