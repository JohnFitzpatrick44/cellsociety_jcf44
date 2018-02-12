package buttons;
import View.MainView;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;

/*
 * switch button that changes a boolean found in the Main Class (using a public static method)
 * The boolean controls whether the simulation runs a triangle or square simulation
 * @author Ryan Fu
 */
public class SwitchButton extends Label
{
	private SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(true);

	public SwitchButton()
	{
		Button switchBtn = new Button();
		switchBtn.setPrefWidth(40);
		switchBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent t)
			{
				MainView.switchShape();
				MainView.switchSimulation();
				switchedOn.set(!switchedOn.get());
			}
		});

		setGraphic(switchBtn);

		switchedOn.addListener(new ChangeListener<Boolean>()
		{
			@Override
			public void changed(ObservableValue<? extends Boolean> ov,
					Boolean t, Boolean t1)
			{
				if (t1)
				{
					setText("TRIANGLE");
					setStyle("-fx-background-color: grey;-fx-text-fill:white;");
					setContentDisplay(ContentDisplay.RIGHT);
				}
				else
				{
					setText("SQUARE");
					setStyle("-fx-background-color: grey;-fx-text-fill:black;");
					setContentDisplay(ContentDisplay.LEFT);
				}
			}
		});

		switchedOn.set(false);
	}

	public SimpleBooleanProperty switchOnProperty() { 
		return switchedOn; 
	}
	public void setPosition(int x, int y ) {
		this.setLayoutX(x);
		this.setLayoutY(y);
	}

}