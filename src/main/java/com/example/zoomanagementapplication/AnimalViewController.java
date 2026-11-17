package com.example.zoomanagementapplication;

import com.example.zoomanagementapplication.Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Controller responsible for creating and editing {@link Animal} objects.
 * <p>
 * This controller manages the animal form, validates user input,
 * creates new animals when necessary, updates existing animals,
 * and closes the window when the operation is complete.
 * </p>
 */
public class AnimalViewController {

    /**
     * The animal being viewed or edited.
     */
    private Animal aAnimal;

    /**
     * Indicates whether the animal is being created (true)
     * or edited (false).
     */
    private boolean isNew = true;

    /**
     * The enclosure that contains the animal.
     * Used when adding a newly created animal.
     */
    private Enclosure aEnclosure;

    /**
     * Text field used to enter or edit the animal's name.
     */
    @FXML
    private TextField aNameTextField;

    /**
     * Spinner used to enter or edit the animal's age.
     */
    @FXML
    private Spinner<Double> aAgeSpinner;

    /**
     * Initializes the controller after its root element has been
     * completely processed.
     * <p>
     * Configures the age spinner to accept values between
     * 0 and 200, with a default value of 1.
     * </p>
     */
    @FXML
    public void initialize() {
        this.aAgeSpinner.setValueFactory(
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 200, 1)
        );
    }

    /**
     * Handles the Save button click event.
     * <p>
     * Creates a new animal when in creation mode or updates the
     * existing animal when in edit mode. If invalid data is entered,
     * a warning message is displayed to the user.
     * </p>
     */
    @FXML
    protected void onSaveButtonClick() {
        try {
            String animalName = this.aNameTextField.getText();
            double animalAge = this.aAgeSpinner.getValue();

            if (this.isNew) {
                this.aAnimal = new Animal(animalName, animalAge);
                this.aEnclosure.addAnimal(this.aAnimal);
            } else {
                this.aAnimal.setName(animalName);
                this.aAnimal.setAge(animalAge);
            }
        } catch (IllegalArgumentException exception) {
            Alert alert = new Alert(Alert.AlertType.WARNING, exception.getMessage());
            alert.showAndWait();
            return;
        }

        this.onBackButtonClick();
    }

    /**
     * Handles the Back button click event.
     * <p>
     * Closes the current window without making additional changes.
     * </p>
     */
    @FXML
    protected void onBackButtonClick() {
        Stage stage = (Stage) aNameTextField.getScene().getWindow();
        stage.close();
    }

    /**
     * Sets the animal to be edited.
     * <p>
     * Populates the form controls with the animal's current data
     * and updates the window title.
     * </p>
     * <p>
     * Presetting the animal is used to view / edit an existing animal.
     * </p>
     *
     * @param pAnimal the animal to edit
     */
    public void setAnimal(Animal pAnimal) {
        this.aAnimal = pAnimal;
        this.isNew = false;
        this.aNameTextField.setText(pAnimal.getName());
        this.aAgeSpinner.getValueFactory().setValue(pAnimal.getAge());

        Stage currentStage = (Stage) this.aNameTextField.getScene().getWindow();
        currentStage.setTitle("Edit Animal: " + pAnimal.getName());
    }

    /**
     * Sets the enclosure to which to add the new animal.
     * <p>
     * The enclosure is used when adding a newly created animal.
     * The new animal will be added to this enclosure upon save.
     * </p>
     *
     * @param pEnclosure the enclosure that will contain the animal
     */
    public void setEnclosure(Enclosure pEnclosure) {
        this.aEnclosure = pEnclosure;
        this.isNew = true;
    }
}