package atm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	/**
	 * Launches the application
	 * 
	 * @param args - arguments given by user
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/insertScene.fxml"));

			Scene scene = new Scene(root);
			
			// Sets css styles
			scene.getStylesheets().add(this.getClass().getResource("/Styles.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setTitle("ATM Machine");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
