package com.se4.work.uni.gui;

import com.se4.work.uni.gui.menu.MenuOptions;
import com.se4.work.uni.interpreter.RunCode;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageGui {

    protected Stage stage;
    private Scene mainScene;
    private final SplitPane mainSplitPane = new SplitPane();

    private HBox menuHBox;

    private final Label inputBoxLabel = new Label("Input box:");
    public final TextArea input = new TextArea();
    private final Label cmdLineLabel = new Label("Command line:");
    public final TextField cmd = new TextField();
    private final Button runCmd = new Button("Run Command");
    private final HBox cmdLine = new HBox(cmd, runCmd);
    private final Button runCode = new Button("Run Program");
    private final VBox inputVBox = new VBox(inputBoxLabel, input, cmdLineLabel, cmdLine, runCode);

    private final Canvas output = new Canvas();
    private final GraphicsContext graphicsContext = output.getGraphicsContext2D();
    private final VBox outputVBox = new VBox(output);

    public ManageGui(Stage stage, String title) {
        this.stage = stage;
        configureStage(title);
        configureMenu();
        configureInput();
        configureScene();
        configureRun();
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
        createNew.setOnAction(e -> options.createNew(input));

        MenuItem save = new MenuItem("Save");
        save.setOnAction(e -> options.save(stage, input));

        MenuItem load = new MenuItem("Load");
        load.setOnAction(e -> options.load(stage, input));

        MenuItem help = new MenuItem("Help");
        help.setOnAction(e -> options.help());

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> options.exit(input));

        menu.getItems().addAll(createNew, save, load, help,  exit);
        menuBar.getMenus().addAll(menu);
        menuHBox = new HBox(menuBar);
    }

    private void configureInput() {
        input.setWrapText(true);
        input.prefHeightProperty().bind(stage.heightProperty());
        input.setPadding(new Insets(10, 10, 10, 10));
        inputVBox.setPadding(new Insets(10, 10, 10, 10));
    }

    private void configureScene() {
        mainSplitPane.getItems().addAll(inputVBox, outputVBox);
        VBox mainVBox = new VBox(menuHBox, mainSplitPane);
        mainScene = new Scene(mainVBox);
    }

    private void configureRun() {
        runCode.setOnAction(e -> RunCode.runCode(input, graphicsContext));
        runCmd.setOnAction(e -> RunCode.runCmd(cmd));
    }
}
