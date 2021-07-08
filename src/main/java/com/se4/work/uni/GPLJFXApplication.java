package com.se4.work.uni;

import com.se4.work.uni.gui.ManageGui;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Launches the GUI
 *
 * @author samuel.canham
 */
public class GPLJFXApplication extends Application {

    @Override
    public void start(Stage stage) {
        ManageGui createGui = new ManageGui(stage, "GPLA");
        createGui.show();
    }
}
