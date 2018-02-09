package buttons;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import View.ButtonView;
import View.MainView;
import gridTypes.Grid;
/*
 * PlayButton class that inherits the ActionButton
 * Creates a PlayButton action that jumps to a future frame
 * @author Ryan Fu
 */
public class JumpButton extends ActionButton{
				
	private final String BUTTON_NAME = myResources.getString("Jump");

	public JumpButton(Color buttonColor) {
		super(buttonColor);
		this.setButtonText(BUTTON_NAME);
		this.setJumpEvent();
	}
	/*
	 * private method to set the action event to play
	 */
	private void setJumpEvent() {
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	if (isNumeric(ButtonView.getJumpField().getText())) {
		        for (int i = 0; i<Integer.parseInt(ButtonView.getJumpField().getText()); i++) {
		        		Grid.updateStates(MainView.getMyCellGrid());
		        }
		    	}
		    }
		});
	}
	
	//checks if the word written is a numerical value
	private Boolean isNumeric(String value) {
		try {
			Integer.parseInt(value);
		}catch (NumberFormatException e) {
			return false;
		}
		return true;
		
	}
}
