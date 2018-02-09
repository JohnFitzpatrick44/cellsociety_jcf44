package buttons;
import java.io.File;


import View.Main;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
/*
 * FileUploadButton class that inherits the ActionButton
 * Creates a button action that increases the speed of the animation.
 * @author Ryan Fu
 */
public class FileUploadButton extends ActionButton{

	private static final int MAX_WIDTH = 250;
	
	private final String BUTTON_NAME = myResources.getString("File");
	//private Desktop desktop = Desktop.getDesktop();
	public FileUploadButton(Color buttonColor) {
		super(buttonColor);
		this.setButtonText(BUTTON_NAME);
		this.setFileEvent();
	}


	/*
	 * private method to set the action event to speed
	 */

	private void setFileEvent() {
		this.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				fileUpload(); //activate the play method
			}
		});
	}
	private void fileUpload() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(Main.getMainStage());
        if (file != null) {
        		MainView.fileSelector.getItems().add(file);
        		MainView.fileSelector.setMaxWidth(MAX_WIDTH);
        }
	}

}