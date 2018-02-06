package buttons;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;


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
		    	if (isNumeric(MainView.jumpField.getText())) {
		        for (int i = 0; i<Integer.parseInt(MainView.jumpField.getText()); i++) {
		        		Grid.updateStates(MainView.myCellGrid);
		        }
		    	}
		    }
		});
	}
	
	//checks if the word written is a numerical value
	private Boolean isNumeric(String value) {
		Boolean isTrue = false;
		try {
			Integer.parseInt(value);
			isTrue = true;
		}catch (NumberFormatException e) {
	
		}
		return isTrue;
		
	}
}
