package com.se4.work.uni.gui;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CreateGui {

    @Value("${message}")
    private String test;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void init() {
        stage.setTitle(test);
    }

    public void show() {
        stage.show();
    }
}
