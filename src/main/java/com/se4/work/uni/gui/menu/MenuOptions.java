package com.se4.work.uni.gui.menu;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Optional;

public class MenuOptions {

    public void createNew() {

    }

    public void save(Stage stage, TextArea input) {
        FileChooser saveFile = new FileChooser();
        saveFile.setTitle("Save File");
        saveFile.setInitialFileName("image.png");
        saveFile.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT", "*.txt"));
        File file = saveFile.showSaveDialog(stage);

        if (file != null) {
            try {

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to save file");
                alert.showAndWait();
            }
        }
    }

    public void load(Stage stage) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmation");
        confirm.setHeaderText("Load new Project");
        confirm.setContentText("Are you sure you want to load a different project?\nMake sure you have saved!");
        Optional<ButtonType> result = confirm.showAndWait();

        if (result.get().equals(ButtonType.OK)) {
            FileChooser openFile = new FileChooser();
            openFile.setTitle("Open File");
            openFile.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Files", "*.*"),
                    new FileChooser.ExtensionFilter("TXT", "*.txt"));
            File file = openFile.showOpenDialog(stage);

            if (file != null) {
                try {
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to load file");
                    alert.showAndWait();
                }
            }
        }
    }

    public void help() {
        Stage helpStage = new Stage();
        helpStage.setTitle("Help");
        HBox mainHBox = new HBox();
        mainHBox.setStyle("-fx-background-color: #ffffff");
        mainHBox.setPrefSize(800, 200);


        Label text = new Label();
        text.setText("Thank you for using this application!");

        mainHBox.getChildren().addAll(text);

        Scene helpScene = new Scene(mainHBox);
        helpStage.setScene(helpScene);
        helpStage.showAndWait();
    }

    public void exit() {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmation");
        confirm.setHeaderText("Exit");
        confirm.setContentText("Are you sure you want to exit?\nMake sure you have saved!");
        Optional<ButtonType> result = confirm.showAndWait();
        if (result.get().equals(ButtonType.OK)) {
            Platform.exit();
        }
    }
}
