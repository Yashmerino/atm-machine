package atm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class CardController {

	@FXML
	private Button buttonCreateCard;

	/**
	 * Gets the inserted card(.txt file)
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void insertCard(ActionEvent event) {

	}

	/**
	 * Creates a new card(.txt file)
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void createCard(ActionEvent event) {
		try {
			// Creates FileChooser to select save file
			FileChooser fileChooser = new FileChooser();
			// Extension filter to show only .txt files
			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

			// Stores the selected file
			File newCard = fileChooser.showSaveDialog(buttonCreateCard.getScene().getWindow());

			// If selected file doesn't have extension add it manually
			if (!newCard.toString().toLowerCase().endsWith(".txt")) {
				newCard = new File(newCard.getAbsolutePath() + ".txt");
			}

			// Creates BufferedWriter to write info about the card
			BufferedWriter writer = new BufferedWriter(new FileWriter(newCard));

			Random random = new Random();

			// Generates random number and sets balance to 0
			writer.write("number: " + random.ints(1000, 9999).findFirst().getAsInt() + "\nbalance: 0");

			// Closes the opened file
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
