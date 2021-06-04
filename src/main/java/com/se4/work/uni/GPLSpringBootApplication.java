/**************************************************************************
 * Copyright (C) 2021 Sam Canham
 * Unauthorised copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Sam Canham <canhamsam@gmail.com>, March 2021
 **************************************************************************/
package com.se4.work.uni;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GPLSpringBootApplication {

    public static void main(String[] args) {
        Application.launch(GPLJFXApplication.class, args);
    }
}
