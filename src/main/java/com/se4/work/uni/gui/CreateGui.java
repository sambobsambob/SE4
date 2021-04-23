package com.se4.work.uni.gui;

import com.se4.work.uni.gui.menu.MenuOptions;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateGui {

    private Stage stage;
    private Scene mainScene;
    private VBox mainVBox;
    private SplitPane mainSplitPane = new SplitPane();

    private HBox menuHBox;

    private TextArea input = new TextArea();
    private Button run = new Button("Run");
    private VBox inputVBox = new VBox(input, run);

    private VBox outputVBox = new VBox();

    public CreateGui(Stage stage, String title) {
        this.stage = stage;
        configureStage(title);
        configureMenu();
        configureInput();
        configureScene();
        this.stage.setScene(mainScene);
    }

    public void show() {
        stage.show();
    }

    private void configureStage(String title) {
        this.stage.setTitle(title);
        this.stage.setMaximized(true);
    }

    private void configureMenu() {
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuOptions options = new MenuOptions();

        MenuItem createNew = new MenuItem("New");
        createNew.setOnAction(e -> options.createNew());

        MenuItem save = new MenuItem("Save");
        save.setOnAction(e -> options.save(stage, input));

        MenuItem load = new MenuItem("Load");
        load.setOnAction(e -> options.load(stage));

        MenuItem help = new MenuItem("Help");
        help.setOnAction(e -> options.help());

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> options.exit());

        menu.getItems().addAll(createNew, save, load, help,  exit);
        menuBar.getMenus().addAll(menu);
        menuHBox = new HBox(menuBar);
    }

    private void configureInput() {
        input.setWrapText(true);
        input.prefHeightProperty().bind(stage.heightProperty());
    }

    private void configureScene() {
        mainSplitPane.getItems().addAll(inputVBox, outputVBox);
        mainVBox = new VBox(menuHBox, mainSplitPane);
        mainScene = new Scene(mainVBox);
    }
}
