package org.example.commands;

import org.example.core.Commander;

public class Help extends Command{
    private final Commander commander;

    public Help(Commander commander) {
        super("help", "Prints out all Available commands and their description");
        this.commander = commander;
    }

    @Override
    public boolean execute(String argument) {
        System.out.println();
        commander.getCommands().forEach(s -> {
            System.out.println(s.getName() + " --> " + s.getDescription());
        });
        System.out.println();
        System.out.println("ALL ARGUMENTS ARE THE LAST ITEM ENTERED AFTER THE LAST COMMA(,)");
        return true;
    }
}
