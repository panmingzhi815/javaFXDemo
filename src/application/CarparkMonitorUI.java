package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CarparkMonitorUI extends Application {

	private final String fxml = "CarparkMonitorUI.fxml";
	
	@Override
	public void start(Stage stage) throws IOException {
		stage.setTitle("Í£³µ³¡");
		stage.setAlwaysOnTop(true);
		Parent root =FXMLLoader.load(getClass().getResource(fxml));    
	    Scene scene = new Scene(root, 1024, 700);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
}
