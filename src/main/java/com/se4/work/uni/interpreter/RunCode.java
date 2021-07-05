package com.se4.work.uni.interpreter;


import com.se4.work.uni.factory.Square;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RunCode {

    public static void runCode(TextArea input, GraphicsContext graphicsContext) {
        String code = input.getText();
        Square square = new Square();
        square.setOrigin(1000, 1000);
        square.render(graphicsContext, new int[]{100});
    }

    public static void runCmd(TextField cmd) {

    }
}
