package com.se4.work.uni.interpreter;

import com.se4.work.uni.exception.IncorrectNumberOfParametersException;
import com.se4.work.uni.exception.InvalidSyntaxException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Checks the syntax of the code or command entered by the user
 *
 * @author samuel.canham
 */
public class SyntaxCheck {

    /**
     *
     * @param cmds The lines of code to validate
     * @throws InvalidSyntaxException If invalid code has been entered
     */
    public void check(String[] cmds) throws InvalidSyntaxException {
        final String validCommands = "moveto,while,if,endif,endwhile,square,reactangle,triangle,circle";
        int line = 0;
        for (String cmd : cmds) {
                if (!validCommands.contains(cmd.split(" ")[0]) && !cmd.matches("[a-zA-Z]*[\\d]*[\" ]\"*[\\=][\" \"]*[\\d]*")) {
                    throw new InvalidSyntaxException("Invalid command on line " + line);
                }
            line++;
        }
    }

    /**
     * Retrieves the parameters from the code line
     * @param cmd The code line
     * @param count The count of parameters expected
     * @param line The line number the line of code is on
     * @return A {@link List} of the parameters
     * @throws IncorrectNumberOfParametersException if the number of parameters provided does not match the number expected
     */
    public List<String> getParams(String cmd, int count, int line) throws IncorrectNumberOfParametersException {
        String[] cmdLineArray = cmd.split(" ");
        cmdLineArray = Arrays.copyOfRange(cmdLineArray, 1, cmdLineArray.length);
        List<String> params = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            try {
                params.add(cmdLineArray[i]);
            } catch (Exception e) {
                throw new IncorrectNumberOfParametersException("Invalid number of parameters provided on line " + line);
            }
        }
        return params;
    }
}
