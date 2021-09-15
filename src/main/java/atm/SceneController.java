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
	 * Switches to card management scene
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void switchToManagementScene(ActionEvent event) {
		try {
			// Gets managementScene and the stage
			root = FXMLLoader.load(getClass().getResource("/managementScene.fxml"));
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
	 * Switches to insert card scene
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void switchToInsertScene(ActionEvent event) {
		try {
			// Gets insertScene and the stage
			root = FXMLLoader.load(getClass().getResource("/insertScene.fxml"));
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
	 * Switches to pin scene
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void switchToPinScene(ActionEvent event) {
		try {
			// Gets pinScene and the stage
			root = FXMLLoader.load(getClass().getResource("/pinScene.fxml"));
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
