package com.se4.work.uni.interpreter;

import com.se4.work.uni.exception.InvalidSyntaxException;
import com.se4.work.uni.exception.NoCodeException;
import com.se4.work.uni.exception.UnknownCommandException;

public class Interpreter {

    SyntaxCheck syntaxCheck = new SyntaxCheck();

    public String[] getCommands(String code) throws NoCodeException, InvalidSyntaxException {
        if (code.isEmpty()) {
            throw new NoCodeException("No code entered");
        }
        String[] codeLines = code.split("\n");
        syntaxCheck.check(codeLines);
        return codeLines;
    }

    //TODO create custom exceptions for not enough parameters when creating the shapes
    public void runCommands(String[] cmds) throws UnknownCommandException {
        int line = 0;
        for (String cmd : cmds) {
            switch (cmd) {
                case ("moveto"):
                    moveTo(cmd);
                    break;
                case ("while"):
                    whileCmd(cmd);
                    break;
                case ("if"):
                    ifCmd(cmd);
                    break;
                case ("endif"):
                    endif(cmd);
                    break;
                case ("endwhile"):
                    endwhile(cmd);
                    break;
                case ("square"):
                    squareOrRectangle(cmd);
                    break;
                case ("triangle"):
                    triangle(cmd);
                    break;
                case ("circle"):
                    circle(cmd);
                    break;
                default:
                    throw new UnknownCommandException("Unknown command on line " + line);
            }
        }
    }

    private String formatCmdLine(String cmdLine) {
        return cmdLine.replace(" ", "");
    }

    private void moveTo(String cmd) {
        cmd = formatCmdLine(cmd);
    }

    private void whileCmd(String cmd) {
        cmd = formatCmdLine(cmd);
    }

    private void ifCmd(String cmd) {
        cmd = formatCmdLine(cmd);
    }

    private void endif(String cmd) {
        cmd = formatCmdLine(cmd);
    }

    private void endwhile(String cmd) {
        cmd = formatCmdLine(cmd);
    }

    private void squareOrRectangle(String cmd) {
        cmd = formatCmdLine(cmd);
    }

    private void triangle(String cmd) {
        cmd = formatCmdLine(cmd);
    }

    private void circle(String cmd) {
        cmd = formatCmdLine(cmd);
    }
}
