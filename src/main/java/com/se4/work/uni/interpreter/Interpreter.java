package com.se4.work.uni.interpreter;

import com.se4.work.uni.exception.IncorrectNumberOfParametersException;
import com.se4.work.uni.exception.InvalidSyntaxException;
import com.se4.work.uni.exception.NoCodeException;
import com.se4.work.uni.exception.UnableToDrawShape;
import com.se4.work.uni.factory.DrawCircle;
import com.se4.work.uni.factory.Rectangle;
import com.se4.work.uni.factory.Square;
import com.se4.work.uni.factory.Triangle;
import javafx.scene.canvas.GraphicsContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void runCommands(String[] cmds, String code, GraphicsContext gc) throws UnableToDrawShape, IncorrectNumberOfParametersException {
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
                    squareOrRectangle(code, line, gc);
                    break;
                case ("triangle"):
                    triangle(code, line, gc);
                    break;
                case ("circle"):
                    circle(code, line, gc);
                    break;
                default:
                    var(code, line);
                    break;
            }
        }
    }

    /**
     * Sets the variables entered by the user
     * @param cmd the cmd
     * @param line the line the cmd is on
     */
    private void var(String cmd, int line) {
        try {
            String varName = cmd.split(" ")[0];
            String value = syntaxCheck.getParams(cmd, 1, line).get(0);
            vars.put(varName, value);
            System.out.println("Variable set " + varName + " with the value " + value);
        } catch (IncorrectNumberOfParametersException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the origin of the shape
     * @param cmd the cmd
     * @param line the line of code
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
            System.out.println("Origin set at " + x + " " + y);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the while command
     * @param cmd The command
     * @param line The line the command is on
     */
    private void whileCmd(String cmd, int line) {
        String condition = "";
        try {
            condition = syntaxCheck.getParams(cmd, 1, line).get(0);
        } catch (IncorrectNumberOfParametersException e) {
            e.printStackTrace();
        }
    }

    /**
     * handles the if command
     * @param cmd the cmd
     * @param line the line the cmd is on
     */
    private void ifCmd(String cmd, int line) {
        String condition = "";
        try {
            condition = syntaxCheck.getParams(cmd, 1, line).get(0);
        } catch (IncorrectNumberOfParametersException e) {
            e.printStackTrace();
        }
    }

    /**
     * handles the endif command
     * @param cmd the cmd
     */
    private void endif(String cmd) {
    }

    /**
     * handles the endwhile comd
     * @param cmd the cmd
     */
    private void endwhile(String cmd) {

    }

    /**
     * draws the square or rectangle
     * @param cmd the cmd
     * @param line the line the cmd is on
     * @param gc the graphics context
     * @throws IncorrectNumberOfParametersException if an incorect number of parameters is provided
     * @throws UnableToDrawShape if it is unable to draw the shape
     */
    private void squareOrRectangle(String cmd, int line, GraphicsContext gc) throws IncorrectNumberOfParametersException, UnableToDrawShape {
        if (cmd.equals("square")) {
            List<String> sizeList = syntaxCheck.getParams(cmd, 1, line);
            Square square = new Square();
            square.setOrigin(x, y);
            square.render(gc, sizeList);
        } else {
            List<String> sizeList = syntaxCheck.getParams(cmd, 2, line);
            Rectangle rectangle = new Rectangle();
            rectangle.setOrigin(x, y);
            rectangle.render(gc, sizeList);
        }
    }

    /**
     * draws the triangle
     * @param cmd the cmd
     * @param line the line the cmd is on
     * @param gc the graphics context
     * @throws IncorrectNumberOfParametersException if an incorect number of parameters is provided
     * @throws UnableToDrawShape if it is unable to draw the shape
     */
    private void triangle(String cmd, int line, GraphicsContext gc) throws IncorrectNumberOfParametersException, UnableToDrawShape {
        List<String> params = syntaxCheck.getParams(cmd, 2, line);
        Triangle triangle = new Triangle();
        triangle.setOrigin(x, y);
        triangle.render(gc, params);
    }

    /**
     * draws the circle
     * @param cmd the cmd
     * @param line the line the cmd is on
     * @param gc the graphics context
     * @throws IncorrectNumberOfParametersException if an incorect number of parameters is provided
     * @throws UnableToDrawShape if it is unable to draw the shape
     */
    private void circle(String cmd, int line, GraphicsContext gc) throws IncorrectNumberOfParametersException, UnableToDrawShape {
        List<String> params = syntaxCheck.getParams(cmd, 1, line);
        DrawCircle circle = new DrawCircle();
        circle.setOrigin(x, y);
        circle.render(gc, params);
    }
}
