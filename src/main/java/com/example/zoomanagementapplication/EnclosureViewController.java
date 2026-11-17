package com.example.zoomanagementapplication;

import com.example.zoomanagementapplication.Model.Animal;
import com.example.zoomanagementapplication.Model.Enclosure;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class EnclosureViewController {
    @FXML
    private Label aTitleLabel;

    @FXML
    private Label aCountLabel;

    @FXML
    private ListView<Animal> aAnimalListView;

    private Enclosure aEnclosure;

    private void refresh() {
        this.aAnimalListView.getItems().setAll(this.aEnclosure.getAnimal());
        this.aCountLabel.setText("Animals: " + this.aEnclosure.countAnimals());
    }


    /**
     *
     * @param pEvent the button event
     */
    @FXML
    protected void onAddButtonClick(ActionEvent pEvent) {
//        Animal created = this.openAnimalView(null, pEvent);
//        if (created != null) {
//            this.aEnclosure.addAnimal(created);
//            this.refresh();
//        }
        this.openAnimalView(null, pEvent);
    }

    /**
     *
     * @param pEvent the button event
     */
    @FXML
    protected void onEditButtonClick(ActionEvent pEvent) {
        Animal selected = this.getSelectedAnimal();
        if (selected == null) {
            return;
        }
        this.openAnimalView(selected, pEvent); // the animal view edits the object itself
        this.refresh();
    }

    /**
     * @param pEvent the button event
     */
    @FXML
    protected void onRemoveButtonClick(ActionEvent pEvent) {
        Animal selected = this.getSelectedAnimal();
        if (selected == null) {
            return;
        }
        this.aEnclosure.removeAnimal(selected);
        this.refresh();
    }

    /**
     * @param pEvent the button event
     */
    @FXML
    protected void onBackButtonClick(ActionEvent pEvent) {
        Stage stage = (Stage) this.aAnimalListView.getScene().getWindow();
        stage.close();
    }

    /**
     * @return the selected animal
     */
    private Animal getSelectedAnimal() {
        Animal selected = this.aAnimalListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Please select an animal first.").showAndWait();
        }
        return selected;
    }

    /**
     * @param pAnimal the animal to edit
     * @param pEvent  the event that triggered this
     * @return the animal that was saved
     */
    private void openAnimalView(Animal pAnimal, ActionEvent pEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(AnimalViewController.class.getResource("animal-view.fxml"));
            Parent view = loader.load();
            AnimalViewController controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(view)); // must come BEFORE setAnimal
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());

            if (pAnimal == null) {
                controller.setEnclosure(this.aEnclosure); // Add: new animal
            } else {
                controller.setAnimal(pAnimal);            // Edit: existing animal
            }

            stage.showAndWait();
            this.refresh();
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Could not open the animal view: " + e.getMessage()).showAndWait();
        }
    }


    public void setEnclosure(Enclosure selectedEnclosure) {
        this.aEnclosure = selectedEnclosure;
        this.aTitleLabel.setText(selectedEnclosure.getName());
        this.refresh();
    }
}