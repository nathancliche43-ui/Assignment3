package com.example.zoomanagementapplication;

import com.example.zoomanagementapplication.Model.Enclosure;
import com.example.zoomanagementapplication.Model.ZooComponent;
import com.example.zoomanagementapplication.Model.ZooSection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ZooSectionViewController {
    @FXML
    private Label titleText;

    @FXML
    private ListView<ZooComponent> zooListView;

    @FXML
    private final List<ZooSection> navigationHistory = new ArrayList<>();

    private ZooService aService;

    @FXML
    public void initialize() {
        aService = ImportHelper.createZooService();
        ZooSection root = aService.getRootSection();
        List<ZooComponent> ComponentList = root.ZooComponentList();
        zooListView.getItems().setAll(ComponentList);
    }

    @FXML
    protected void onViewButtonClick(ActionEvent pEvent) throws IOException {
        ZooComponent selectedItem = zooListView.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            return;
        }

        if (selectedItem instanceof ZooSection selectedSection) {
            navigationHistory.add(selectedSection);

            if (titleText != null) {
                titleText.setText(selectedSection.getName());
            }

            zooListView.getItems().setAll(selectedSection.ZooComponentList());

        }
        // If the user selected an Enclosure, open the enclosure modal window
        else if (selectedItem instanceof Enclosure selectedEnclosure) {
            openEnclosureWindow(selectedEnclosure, pEvent);
        }
    }

    @FXML
    private void openEnclosureWindow(Enclosure selectedEnclosure, ActionEvent pEvent) throws IOException {
            FXMLLoader = new FXMLLoader(ZooApplication.class.getResource("enclosure-view.fxml"));
            Parent view = fxmlLoader.load();
            EnclosureViewController newEnclosureViewController = fxmlLoader.getController();
            newEnclosureViewController.setEnclosure(getSelectedEnclosure());
            Scene nextScene = new Scene(view, 500, 500);
            Stage nextStage = new Stage();
            nextStage.setScene(nextScene);
            nextStage.setTitle(pEnclosure.getName());
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
            nextStage.showAndWait();
    }

    @FXML
    private void onBackButtonClick(ActionEvent pEvent) {
        Platform.exit();
    }
}

