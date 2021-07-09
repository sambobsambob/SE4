package com.se4.work.uni.interpreter;


import com.se4.work.uni.exception.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Handles the user clicking the run button
 *
 * @author samuel.canham
 */
public class RunCode {

    private RunCode() {}

    /**
     * Runs the main code block entered by the user
     * @param input The code entered by the user
     * @param graphicsContext The output section of the GUI
     */
    public static void runCode(TextArea input, GraphicsContext graphicsContext) {
        String code = input.getText().toLowerCase();
        try {
            Interpreter interpreter = new Interpreter();
            String[] cmds = interpreter.getCommands(code);
            interpreter.runCommands(cmds, code, graphicsContext);
        } catch (NoCodeException | InvalidSyntaxException | UnableToDrawShape | IncorrectNumberOfParametersException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the command entered by the user
     * @param input The command entered by the user
     * @param graphicsContext The output section of the GUI
     */
    public static void runCmd(TextField input, GraphicsContext graphicsContext) {
        String code = input.getText().toLowerCase();
        try {
            Interpreter interpreter = new Interpreter();
            String[] cmds = interpreter.getCommands(code);
            interpreter.runCommands(cmds, code, graphicsContext);
        } catch (NoCodeException | InvalidSyntaxException | UnableToDrawShape | IncorrectNumberOfParametersException e) {
            e.printStackTrace();
        }
    }
}
