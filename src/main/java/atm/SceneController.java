package atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller for the Scenes to perform different actions
 * 
 * @author Artiom
 *
 */
public class SceneController {

	private Stage stage;
	private Scene scene;
	private Parent root;

	/**
	 * Changes the scene to Scene2
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void changeToScene2(ActionEvent event) {
		try {
			// Gets Scene2 and the stage
			root = FXMLLoader.load(getClass().getResource("/Scene2.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);

			// Sets css styles for the scene
			scene.getStylesheets().add(this.getClass().getResource("/Styles.css").toExternalForm());

			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Changes the scene to Scene1
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void changeToScene1(ActionEvent event) {
		try {
			// Gets Scene1 and the stage
			root = FXMLLoader.load(getClass().getResource("/Scene1.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);

			// Sets css styles for the scene
			scene.getStylesheets().add(this.getClass().getResource("/Styles.css").toExternalForm());

			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
