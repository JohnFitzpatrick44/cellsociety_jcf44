package buttons;
import View.ChartView;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/*
 * PlayButton class that inherits the ActionButton
 * Creates a PlayButton action that specifically pauses the grid simulation
 * @author Ryan Fu
 */
public class ChartButton extends ActionButton{
				
	private final String BUTTON_NAME = myResources.getString("Chart");

	public ChartButton(Color buttonColor) {
		super(buttonColor);
		this.setButtonText(BUTTON_NAME);
		this.setChartEvent();
	}
	/*
	 * private method to set the action event to play
	 */
	private void setChartEvent() {
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        buildChart();// activate the play method
		        MainView.setChartBoolean(true);
		    }
		});
	}
	
	private void buildChart() {
		ChartView graphSimulation = new ChartView();
		Stage secondStage = new Stage();
		secondStage.setScene(graphSimulation.initializeStartScene());
		//change boolean if stage is closed
	    secondStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	           public void handle(WindowEvent we) {
	        	   	MainView.setChartBoolean(false);
	           }
	    });   
		secondStage.show();
	}
}
