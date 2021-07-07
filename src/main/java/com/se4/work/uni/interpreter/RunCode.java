package com.se4.work.uni.interpreter;


import com.se4.work.uni.exception.InvalidSyntaxException;
import com.se4.work.uni.exception.NoCodeException;
import com.se4.work.uni.exception.UnknownCommandException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RunCode {

    private RunCode() {}

    public static void runCode(TextArea input, GraphicsContext graphicsContext) {
        String code = input.getText().toLowerCase();
        try {
            Interpreter interpreter = new Interpreter();
            String[] cmds = interpreter.getCommands(code);
            interpreter.runCommands(cmds);
        } catch (NoCodeException | InvalidSyntaxException | UnknownCommandException e) {
            e.printStackTrace();
        }
    }

    public static void runCmd(TextField cmd) {

    }
}
