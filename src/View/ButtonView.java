package View;

import java.io.File;

import XML.DataHolder;
import buttons.ChartButton;
import buttons.CompareButton;
import buttons.FileUploadButton;
import buttons.JumpButton;
import buttons.PauseButton;
import buttons.PlayButton;
import buttons.ResetButton;
import buttons.SlowButton;
import buttons.SpeedButton;
import buttons.SpeedSlider;
import buttons.StepButton;
import buttons.SwitchButton;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ButtonView {

	private static final Color BUTTON_COLOR = Color.BLACK;	
	private static final int BUTTON_Y_POSITION = 400;
	private static final int BUTTONROW2_Y_POSITION = 440;
	private static final int BUTTONROW3_Y_POSITION = 480;
	private static final int PLAYBTN_X_POSITION = 20;
	private static final int PAUSEBTN_X_POSITION = 80;
	private static final int STEPBTN_X_POSITION = 150;
	private static final int RESETBTN_X_POSITION = 210;
	private static final int JUMPBTN_X_POSITION = 280;
	private static final int JUMPTXTFIELD_X_POSITION = 340;
	private static final int JUMPTXT_DIMENSIONS = 70;
	private static final int TITLE_X_POSITION = 140;
	private static final int TITLE_Y_POSITION = 390;
	private static final int SPEEDBTN_X_POSITION = 380;
	private static final int SLOWBTN_X_POSITION = 340;
	private static final int FILE_X_POSITION = 290;
	private static final int SLIDER_X_POSITION = 50;
	private static final double MAXSLIDERSPEED=200;
	private static final double MINSLIDERSPEED=0;
	private static final double DEFAULTSLIDERSPEED = 1;

	//creating instance variables of the buttons
	private static PlayButton playBtn;
	private static ResetButton resetBtn;
	private static JumpButton jumpBtn;
	private static PauseButton pauseBtn;
	private static StepButton stepBtn;
	private static SpeedButton speedBtn;
	private static SlowButton slowBtn;
	private static FileUploadButton fileBtn;
	private static SpeedSlider speedSlider;
	private static ChartButton chartBtn;
	private static SwitchButton switchBtn;
	//private CompareButton compareBtn;
	
	private static ComboBox<File> fileSelector;
	public static ComboBox<File> getFileSelector() {
		return fileSelector;
	}

	public static void setFileSelector(ComboBox<File> fileSelector) {
		ButtonView.fileSelector = fileSelector;
	}




	private static TextField jumpField;
	public static TextField getJumpField() {
		return jumpField;
	}

	public static void setJumpField(TextField jumpField) {
		ButtonView.jumpField = jumpField;
	}




	private static Text title;
	//create all the buttons
	public static void createButtons() {
		playBtn = new PlayButton(BUTTON_COLOR);
		resetBtn = new ResetButton(BUTTON_COLOR);
		pauseBtn = new PauseButton(BUTTON_COLOR);
		jumpBtn = new JumpButton(BUTTON_COLOR);
		stepBtn = new StepButton(BUTTON_COLOR);
		speedBtn = new SpeedButton(BUTTON_COLOR);
		slowBtn = new SlowButton(BUTTON_COLOR);
		fileBtn = new FileUploadButton(BUTTON_COLOR);
		speedSlider = new SpeedSlider(MINSLIDERSPEED, MAXSLIDERSPEED, DEFAULTSLIDERSPEED);
		switchBtn = new SwitchButton();
		chartBtn = new ChartButton(BUTTON_COLOR);
		jumpField = new TextField();
		
		title = new Text();
		setTitleAuthor();
//		MainTriangleView.createDropDownMenu();
//		MainTriangleView.getGroup().getChildren().addAll(playBtn, resetBtn, pauseBtn, jumpBtn, stepBtn, fileSelector, jumpField, title, slowBtn, speedBtn, fileBtn,switchBtn);
		MainView.createDropDownMenu();
		MainView.getGroup().getChildren().addAll(playBtn, resetBtn, pauseBtn, jumpBtn, stepBtn, fileSelector, jumpField, title, slowBtn, speedBtn, speedSlider, fileBtn, chartBtn, switchBtn);
	}
	//arrange all the buttons on the screen
	public static void arrangeButtons() {
		playBtn.setPosition(PLAYBTN_X_POSITION, BUTTON_Y_POSITION);
		pauseBtn.setPosition(PAUSEBTN_X_POSITION,  BUTTON_Y_POSITION);
		stepBtn.setPosition(STEPBTN_X_POSITION, BUTTON_Y_POSITION);
		resetBtn.setPosition(RESETBTN_X_POSITION, BUTTON_Y_POSITION);
		jumpBtn.setPosition(JUMPBTN_X_POSITION, BUTTON_Y_POSITION);
		speedBtn.setPosition(SPEEDBTN_X_POSITION, BUTTONROW2_Y_POSITION);
		slowBtn.setPosition(SLOWBTN_X_POSITION, BUTTONROW2_Y_POSITION);
		fileSelector.setLayoutY(BUTTONROW2_Y_POSITION);
		fileSelector.setLayoutX(PLAYBTN_X_POSITION);
		jumpField.setLayoutX(JUMPTXTFIELD_X_POSITION);
		jumpField.setLayoutY(BUTTON_Y_POSITION);
		jumpField.setMaxWidth(JUMPTXT_DIMENSIONS);
		title.setLayoutX(TITLE_X_POSITION);
		title.setLayoutY(TITLE_Y_POSITION);
		fileBtn.setPosition(FILE_X_POSITION, BUTTONROW2_Y_POSITION);
		switchBtn.setPosition(FILE_X_POSITION, BUTTONROW3_Y_POSITION);
		speedSlider.setPosition(SLIDER_X_POSITION, BUTTONROW3_Y_POSITION);
		chartBtn.setPosition(RESETBTN_X_POSITION, BUTTONROW3_Y_POSITION);
	}

	
	public static void setTitleAuthor() {
		title.setText(DataHolder.getType()+" by "+DataHolder.getAuthor());
	}
	
}
