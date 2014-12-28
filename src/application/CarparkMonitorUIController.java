package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class CarparkMonitorUIController implements Initializable {

	@FXML
	private TextField text_inPlate;
	@FXML
	private TextField text_inUsername;
	@FXML
	private TextField text_inCarType;
	@FXML
	private TextField text_inPositionType;
	@FXML
	private TextField text_inOverdureTime;
	@FXML
	private Label label_inPlateImage;
	@FXML
	private Tab tab_inImage;

	@FXML
	private TextField text_outPlate;
	@FXML
	private TextField text_outUsername;
	@FXML
	private TextField text_outCarType;
	@FXML
	private TextField text_outPositionType;
	@FXML
	private TextField text_outOverdureTime;
	@FXML
	private TextField text_outEnterTime;
	@FXML
	private TextField text_outExitTime;
	@FXML
	private TextField text_outParkingTime;
	@FXML
	private TextField text_outShouldCharge;
	@FXML
	private Label label_outPlateImage;
	@FXML
	private Tab tab_outImage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		test();
	}
	
	public void cleanUIInfo(int i){
		if(i == 0){
			this.text_inCarType.clear();
			this.text_inOverdureTime.clear();
			this.text_inPlate.clear();
			this.text_inPositionType.clear();
			this.text_inUsername.clear();
			this.label_inPlateImage.setBackground(null);
			this.label_inPlateImage.setText("进口车牌");
			this.tab_inImage.getTabPane().setBackground(null);
		}else{
			this.text_outCarType.clear();
			this.text_outEnterTime.clear();
			this.text_outExitTime.clear();
			this.text_outOverdureTime.clear();
			this.text_outParkingTime.clear();
			this.text_outPlate.clear();
			this.text_outPositionType.clear();
			this.text_outShouldCharge.clear();
			this.text_outUsername.clear();
			this.label_outPlateImage.setBackground(null);
			this.tab_outImage.getTabPane().setBackground(null);
		}
	}
	
	public void setIntoInfo(String carType,String overdureTime,String inPlate,String positionType,String inUsername,String inPlateImagePath,String InImagePath){
		this.text_inCarType.setText(carType);
		this.text_inOverdureTime.setText(overdureTime);
		this.text_inPlate.setText(inPlate);
		this.text_inPositionType.setText(positionType);
		this.text_inUsername.setText(inUsername);
		
		Background createImageBackground = createImageBackground(inPlateImagePath, this.label_inPlateImage.getWidth(), this.label_inPlateImage.getHeight());
		this.label_inPlateImage.setText("");
		this.label_inPlateImage.setBackground(createImageBackground);
		
		Background createImageBackground2 = createImageBackground(InImagePath, this.tab_inImage.getTabPane().getWidth(), this.tab_inImage.getTabPane().getHeight());
		this.tab_inImage.getTabPane().setBackground(createImageBackground2);
	}
	
	public void setOutInfo(String carType,String enterTime,String exitTime,String overdureTime,String outParkingTime,String outPlate,String positionType,String outShouldCharge,String outUsername,String outPlateImagePath,String outImagePath){
		
	}
	
	@FXML
	protected void btn_intoPassReleased() {

	}

	@FXML
	protected void btn_outPassReleased() {

	}

	public Background createImageBackground(String imageFilePath,double width,double height){
		Image image = new Image(imageFilePath, width, width, true, false);
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		return background;
	}
	
	public void test(){
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				cleanUIInfo(0);
				String inPlateImagePath = "file://c://plate.jpg";
				String inImagePath = "file://G://picture//Camera20140602//IMG_20140525_143441.jpg";
				setIntoInfo("固定车", "2014-12-29 12:59:59", "粤S69112", "固定车位", "三栋二楼201室", inPlateImagePath, inImagePath);
			}
		};
		ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutor.scheduleWithFixedDelay(runnable, 3, 5, TimeUnit.SECONDS);
	}
	
	
}
