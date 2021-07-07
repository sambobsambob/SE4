package com.se4.work.uni.interpreter;

import com.se4.work.uni.exception.InvalidSyntaxException;

public class SyntaxCheck {
    //TODO allow variables, regex *= or something like that
    public void check(String[] cmds) throws InvalidSyntaxException {
        final String validCommands = "moveTo,while,if,endif,endwhile,square,reactangle,triangle,circle";
        int line = 0;
        for (String cmd : cmds) {
                if (!validCommands.contains(cmd.split(" ")[0])) {
                    throw new InvalidSyntaxException("Invalid command on line " + line);
                }
            line++;
        }
    }
}
