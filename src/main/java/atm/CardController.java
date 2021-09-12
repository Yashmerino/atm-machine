package atm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

/**
 * CardController to create/insert cards and perform different actions
 * @author Artiom
 *
 */
public class CardController {

	// Button object just to get the scene/window or other
	@FXML
	private Button buttonCreateCard;

	// Stores currentCard(current .atm file)
	private File currentCard;

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
				alert.setContentText("This is not a .atm file! Create a card if you don't have one!");
				alert.showAndWait();
				return;
			}

			// Sets current card to opened card
			currentCard = selectedCard;

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

			// Generates random number and sets balance to 0
			writer.write("number: " + random.ints(1000, 9999).findFirst().getAsInt() + "\nbalance: 0");

			// Closes the opened file
			writer.close();

			// Sets current card to new created card
			currentCard = newCard;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
