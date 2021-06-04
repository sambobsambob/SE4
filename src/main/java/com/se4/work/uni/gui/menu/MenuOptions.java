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
import java.io.FileWriter;
import java.util.Optional;
import java.util.Scanner;

public class MenuOptions {

    public void createNew(Stage stage, TextArea input) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Create new");
        confirm.setHeaderText("Save?");
        confirm.setContentText("Do you want to save before creating a new project?");
        Optional<ButtonType> result = confirm.showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.OK)) {
            save(stage, input);
        }
        if (!(result.isPresent() && result.get().equals(ButtonType.CANCEL))) {
            input.clear();
        }
    }

    public void save(Stage stage, TextArea input) {
        FileChooser saveFile = new FileChooser();
        saveFile.setTitle("Save File");
        saveFile.setInitialFileName("newProject.txt");
        saveFile.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("txt", "*.txt"));
        File file = saveFile.showSaveDialog(stage);
        if (file != null) {
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(input.getText());
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to save file");
                alert.showAndWait();
            }
        }
    }

    public void load(Stage stage, TextArea input) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmation");
        confirm.setHeaderText("Load new Project");
        confirm.setContentText("Are you sure you want to load a different project?\nMake sure you have saved!");
        Optional<ButtonType> result = confirm.showAndWait();

        if (result.isPresent() && result.get().equals(ButtonType.OK)) {
            FileChooser openFile = new FileChooser();
            openFile.setTitle("Open File");
            openFile.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Files", "*.*"),
                    new FileChooser.ExtensionFilter("txt", "*.txt"));
            File file = openFile.showOpenDialog(stage);

            if (file != null) {
                StringBuilder stringBuilder = new StringBuilder();
                //TODO get spaces from file as well
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNext()) {
                        stringBuilder.append(scanner.next());
                        stringBuilder.append("\n");
                    }
                    input.setText(stringBuilder.toString());
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

    public void exit(Stage stage, TextArea input) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmation");
        confirm.setHeaderText("Exit");
        confirm.setContentText("Do you want to save before exiting?");
        Optional<ButtonType> result = confirm.showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.OK)) {
            save(stage, input);
        }
        if (!(result.isPresent() && result.get().equals(ButtonType.CANCEL))) {
            Platform.exit();
        }
    }

    //TODO use this
    private boolean checkEmptyInput(TextArea input) {
        return input.getText().equals("");
    }
}
