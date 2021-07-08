package com.se4.work.uni.interpreter;

import com.se4.work.uni.exception.IncorrectNumberOfParametersException;
import com.se4.work.uni.exception.InvalidSyntaxException;
import com.se4.work.uni.exception.NoCodeException;
import com.se4.work.uni.exception.UnknownCommandException;

import java.util.*;

/**
 * Handles the running of the code and commands
 *
 * @author samuel.canham
 */
public class Interpreter {

    SyntaxCheck syntaxCheck = new SyntaxCheck();

    double x = 0;
    double y = 0;
    Map<String, String> vars = new HashMap<>();

    /**
     * Retrieves the commands from the code entered
     * @param code The code entered by the user
     * @return The commands entered by the user
     * @throws NoCodeException if no code has been entered by the user
     * @throws InvalidSyntaxException If there is an invalid syntax in the users code
     */
    public String[] getCommands(String code) throws NoCodeException, InvalidSyntaxException {
        if (code.isEmpty()) {
            throw new NoCodeException("No code entered");
        }
        String[] codeLines = code.split("\n");
        syntaxCheck.check(codeLines);
        return codeLines;
    }

    /**
     * Runs the commands entered by the user
     * @param cmds the command
     * @param code the code
     */
    public void runCommands(String[] cmds, String code) {
        int line = 0;
        for (String cmd : cmds) {
            cmd = cmd.split(" ")[0];
            switch (cmd) {
                case ("moveto"):
                    moveTo(code, line);
                    break;
                case ("while"):
                    whileCmd(code, line);
                    break;
                case ("if"):
                    ifCmd(code, line);
                    break;
                case ("endif"):
                    endif(code);
                    break;
                case ("endwhile"):
                    endwhile(code);
                    break;
                case ("square"):
                    squareOrRectangle(code);
                    break;
                case ("triangle"):
                    triangle(code);
                    break;
                case ("circle"):
                    circle(code);
                    break;
                default:
                    var(code, line);
                    break;
            }
        }
    }

    private void var(String cmd, int line) {
        try {
            String varName = cmd.split(" ")[0];
            String value = syntaxCheck.getParams(cmd, 1, line).get(0);
            vars.put(varName, value);
        } catch (IncorrectNumberOfParametersException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param cmd
     * @param line
     */
    private void moveTo(String cmd, int line) {
        try {
            List<String> coords = syntaxCheck.getParams(cmd, 2, line);
            setOrigin(coords);
        } catch (IncorrectNumberOfParametersException e) {
            e.printStackTrace();
        }

    }

    /**
     * Sets the origin of the shape
     * @param coords the x and y coordinates
     */
    private void setOrigin(List<String> coords) {
        try {
            this.x = Double.parseDouble(coords.get(0));
            this.y = Double.parseDouble(coords.get(1));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void whileCmd(String cmd, int line) {
        String condition = "";
        try {
            condition = syntaxCheck.getParams(cmd, 1, line).get(0);
        } catch (IncorrectNumberOfParametersException e) {
            e.printStackTrace();
        }
    }

    private void ifCmd(String cmd, int line) {
        String condition = "";
        try {
            condition = syntaxCheck.getParams(cmd, 1, line).get(0);
        } catch (IncorrectNumberOfParametersException e) {
            e.printStackTrace();
        }
    }

    private void endif(String cmd) {
        //TODO talk about how it is a beginner programming language hence anythingcan be after this and it will work
    }

    private void endwhile(String cmd) {

    }

    private void squareOrRectangle(String cmd) {

    }

    private void triangle(String cmd) {

    }

    private void circle(String cmd) {

    }
}
