package org.example.core;

import org.example.exception.IllegalValueException;
import org.example.exception.InvalidInputException;

import java.io.DataInputStream;
import java.util.Scanner;

public class ConsoleManager {
    Scanner scanner = new Scanner(new DataInputStream(System.in));
    private final Commander commander;

    public ConsoleManager(Commander commander) {
        this.commander = commander;
    }

    public void Start() throws IllegalValueException, InvalidInputException {
        //checkXml();
        String s1 = "";
        System.out.println("You can enter commands, Enter \\help\\ for more info...");
        while (!s1.equalsIgnoreCase("exit") && scanner.hasNext()) {
            String name;
            String argument;
            s1 = scanner.next().trim();
            if (s1.trim().split(",").length > 1) {
                name = s1.split(",")[0];
                argument = s1.split(",")[s1.split(",").length - 1];
            } else {
                name = s1;
                argument = "no args";
            }
            boolean ex = false;
            for (var com : commander.getCommands()) {
                if (com.getName().equalsIgnoreCase(name)) {
                    com.execute(argument);
                    ex = true;
                    commander.getHistory().add(s1);
                }
            }
            if (!ex) {
                System.out.println("No such command");
            }
            System.out.print("==>");

        }
    }


}
