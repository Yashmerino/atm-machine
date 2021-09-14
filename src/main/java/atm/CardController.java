package atm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

/**
 * CardController to create/insert cards and perform different actions
 * 
 * @author Artiom
 *
 */
public class CardController {

	// Button object just to get the scene/window or other
	@FXML
	private Button buttonCreateCard;

	// Stores current card(current .atm file)
	private File currentCard;

	// Controller to perform actions in the Scene1
	private SceneController sceneController;

	// Constructor to initialize variables
	public CardController() {
		sceneController = new SceneController();
	}

	/**
	 * Gets the inserted card(.atm file)
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void insertCard(ActionEvent event) {
		try {
			// Creates FileChooser to select file to open
			FileChooser fileChooser = new FileChooser();
			// Extension filter to show only .atm files
			fileChooser.getExtensionFilters()
					.addAll(new FileChooser.ExtensionFilter("ATM Machine Files (.atm)", "*.atm"));

			// Stores the selected file
			File selectedCard = fileChooser.showOpenDialog(buttonCreateCard.getScene().getWindow());

			// If selected file doesn't end with .atm
			if (!selectedCard.toString().toLowerCase().endsWith(".atm")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("This is not a .atm file! Create a card if you don't have one.");
				alert.showAndWait();
				return;
			}

			// Check the card if it is valid before opening Scene2
			if (cardIsOk(selectedCard)) {
				// Sets current card to selected card
				currentCard = selectedCard;

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("The card is corrupted! Please select a valid card or create a new one.");
				alert.showAndWait();
				return;
			}

			// Changes the scene to Scene2
			sceneController.changeToScene2(event);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a new card(.atm file)
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void createCard(ActionEvent event) {
		try {
			// Creates FileChooser to select save file
			FileChooser fileChooser = new FileChooser();
			// Extension filter to show only .atm files
			fileChooser.getExtensionFilters()
					.addAll(new FileChooser.ExtensionFilter("ATM Machine Files (.atm)", "*.atm"));

			// Stores the selected file
			File newCard = fileChooser.showSaveDialog(buttonCreateCard.getScene().getWindow());

			// If selected file doesn't have extension add it manually
			if (!newCard.toString().toLowerCase().endsWith(".atm")) {
				newCard = new File(newCard.getAbsolutePath() + ".atm");
			}

			// Creates BufferedWriter to write info about the card
			BufferedWriter writer = new BufferedWriter(new FileWriter(newCard));

			Random random = new Random();

			// Generates random number, sets balance to zero and generates a random pin
			writer.write("number: " + random.ints(1000, 9999).findFirst().getAsInt() + "\nbalance: 0" + "\npin: "
					+ random.ints(1000, 9999).findFirst().getAsInt());

			// Closes the opened file
			writer.close();

			// Sets current card to new created card
			currentCard = newCard;

			// Changes the scene to Scene2
			sceneController.changeToScene2(event);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Switches scene to Scene1 to insert another card or create a new one
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void changeCard(ActionEvent event) {
		sceneController.changeToScene1(event);
	}

	/**
	 * Checks if the selected card by user is valid
	 * 
	 * @param selectedCard - The card user selected
	 */
	private boolean cardIsOk(File selectedCard) {
		try {
			Scanner reader = new Scanner(selectedCard);

			while (reader.hasNextLine()) {
				// String that stores a whole line from the file
				String data = reader.nextLine();

				// Checks if number, balance and pin fields are present
				if (data.substring(0, 8).equals("number: ")) {
					continue;
				} else if (data.substring(0, 9).equals("balance: ")) {
					continue;
				} else if (data.substring(0, 5).equals("pin: ")) {
					continue;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// If everything went fine return true
		return true;
	}
}
