package com.se4.work.uni;

import com.se4.work.uni.gui.CreateGui;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;

public class GPLJFXApplication extends Application {

    @Override
    public void start(Stage stage) {
        CreateGui createGui = new CreateGui(stage, "GPLA");
        createGui.show();
    }
}
