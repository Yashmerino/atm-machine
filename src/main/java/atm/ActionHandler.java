package atm;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

/**
 * Class that perform actions when buttons clicked
 * 
 * @author Artiom
 *
 */
public class ActionHandler implements Initializable {

	// Withdraw/Deposit amount components
	@FXML
	private Rectangle rectangleAmount;
	@FXML
	private Label labelAmount;
	@FXML
	private Label labelWrittenAmount;

	public void initialize(URL location, ResourceBundle resources) {
		setVisibleAmountComponents(false);
	}

	/**
	 * Switches to Scene1 when logout button pressed
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void logout(ActionEvent event) {
		SceneController sceneController = new SceneController();
		sceneController.switchToInsertScene(event);
	}

	/**
	 * Shows interface to withdraw an amount from card
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void withdraw(ActionEvent event) {
		setVisibleAmountComponents(true);
		clear(event);
	}

	/**
	 * Shows interface to deposit an amount to card
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void deposit(ActionEvent event) {
		setVisibleAmountComponents(true);
		clear(event);
	}

	/**
	 * Hides the interface to deposit/withdraw
	 * 
	 * @param event - Event gotten from Scene
	 */
	public void cancel(ActionEvent event) {
		setVisibleAmountComponents(false);
		clear(event);
	}

	/**
	 * Clears the written amount
	 * 
	 * @param event - Even gotten from Scene
	 */
	public void clear(ActionEvent event) {
		labelWrittenAmount.setText("");
	}

	/**
	 * Adds a character to written amount
	 * 
	 * @param digit - Digit you add
	 */
	private void addCharToAmount(String digit) {
		labelWrittenAmount.setText(labelWrittenAmount.getText() + digit);
	}

	/**
	 * Handles and perform actions when buttonOne clicked
	 * 
	 * @param event - Event gotten from source
	 */
	public void handleButtonOne(ActionEvent event) {
		addCharToAmount("1");
	}

	/**
	 * Handles and perform actions when buttonTwo clicked
	 * 
	 * @param event - Event gotten from source
	 */
	public void handleButtonTwo(ActionEvent event) {
		addCharToAmount("2");
	}

	/**
	 * Handles and perform actions when buttonThree clicked
	 * 
	 * @param event - Event gotten from source
	 */
	public void handleButtonThree(ActionEvent event) {
		addCharToAmount("3");
	}

	/**
	 * Handles and perform actions when buttonFour clicked
	 * 
	 * @param event - Event gotten from source
	 */
	public void handleButtonFour(ActionEvent event) {
		addCharToAmount("4");
	}

	/**
	 * Handles and perform actions when buttonFive clicked
	 * 
	 * @param event - Event gotten from source
	 */
	public void handleButtonFive(ActionEvent event) {
		addCharToAmount("5");
	}

	/**
	 * Handles and perform actions when buttonSix clicked
	 * 
	 * @param event - Event gotten from source
	 */
	public void handleButtonSix(ActionEvent event) {
		addCharToAmount("6");
	}

	/**
	 * Handles and perform actions when buttonSeven clicked
	 * 
	 * @param event - Event gotten from source
	 */
	public void handleButtonSeven(ActionEvent event) {
		addCharToAmount("7");
	}

	/**
	 * Handles and perform actions when buttonEight clicked
	 * 
	 * @param event - Event gotten from source
	 */
	public void handleButtonEight(ActionEvent event) {
		addCharToAmount("8");
	}

	/**
	 * Handles and perform actions when buttonNine clicked
	 * 
	 * @param event - Event gotten from source
	 */
	public void handleButtonNine(ActionEvent event) {
		addCharToAmount("9");
	}

	/**
	 * Handles and perform actions when buttonDot clicked
	 * 
	 * @param event - Event gotten from source
	 */
	public void handleButtonDot(ActionEvent event) {
		addCharToAmount(".");
	}

	/**
	 * Handles and perform actions when buttonZero clicked
	 * 
	 * @param event - Event gotten from source
	 */
	public void handleButtonZero(ActionEvent event) {
		addCharToAmount("0");
	}

	/**
	 * Handles and perform actions when buttonZeroZero clicked
	 * 
	 * @param event - Event gotten from source
	 */
	public void handleButtonZeroZero(ActionEvent event) {
		addCharToAmount("00");
	}

	/**
	 * Set components' visibility in dependance of boolean value
	 * 
	 * @param value - Set visibility to true or false
	 */
	private void setVisibleAmountComponents(boolean value) {
		rectangleAmount.setVisible(value);
		labelAmount.setVisible(value);
		labelWrittenAmount.setVisible(value);
	}

}
