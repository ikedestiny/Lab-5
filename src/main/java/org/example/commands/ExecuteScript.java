package org.example.commands;

import org.example.core.Commander;


public class ExecuteScript extends Command{

    private Commander commander;

    public ExecuteScript(Commander commander) {
        super("executeScript", "collects a list of commands and executes all the commands");
        this.commander = commander;
    }


    @Override
    public boolean execute() {
        while(commander.getInputManager().getScanner().hasNextLine()){
            commander.doCommand(commander.getInputManager().getScanner().nextLine());
        }
        return true;
    }
}
