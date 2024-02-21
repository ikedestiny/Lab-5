package org.example.commands;

public class Exit extends  Command{
    public Exit() {
        super("exit", "terminates the program without saving anything");
    }

    @Override
    public boolean execute(String argument) {
        System.exit(1);
        return false;
    }
}
