package org.example.commands;

import org.example.core.Commander;
import org.example.exception.IllegalValueException;
import org.example.exception.InvalidInputException;


public class ExecuteScript extends Command{

    private final Commander commander;

    public ExecuteScript(Commander commander) {
        super("executeScript", "collects a list of commands and executes all the commands");
        this.commander = commander;
    }


    @Override
    public boolean execute(String argument) {
        String commandName = null;
        String arg;
        while (commander.getInputManager().getScanner().hasNextLine()) {
            commandName = commander.getInputManager().getScanner().nextLine();
            if (commandName.split(",").length > 1) {
                arg = commandName.split(",")[1];
            } else {
                arg = "no args";
            }
            try {
                for (Command command : commander.getCommands()) {
                    if (command.getName().equalsIgnoreCase(commandName.split(",")[0])) {
                        command.execute(arg);
                    }
                }
            } catch (IllegalValueException e) {
                System.out.println(e.getMessage());
            } catch (InvalidInputException e) {
                e.getMessage();
            }
        }
        return true;
    }
}
