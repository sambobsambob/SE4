/**************************************************************************
 * Copyright (C) 2021 Sam Canham
 * Unauthorised copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Sam Canham <canhamsam@gmail.com>, March 2021
 **************************************************************************/
package com.se4.work.uni;

import com.se4.work.uni.gui.CreateGui;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GPLSpringBootApplication {

    public static void main(String[] args) {
        Application.launch(GPLJFXApplication.class, args);
    }
}
