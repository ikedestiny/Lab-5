package org.example.core;

import org.example.exception.IllegalValueException;
import org.example.exception.InvalidInputException;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleManager {
    Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    private final Commander commander;

    /**
     * class responsible for reading commands and its args from console
     *
     * @param commander
     */
    public ConsoleManager(Commander commander) {
        this.commander = commander;
    }

    /**
     * starts the console loop
     * ended with exit or ctrl+D
     *
     * @throws IllegalValueException
     * @throws InvalidInputException
     */
    public void Start() throws IllegalValueException, InvalidInputException {
        //checkXml();
        String s1 = "";
        System.out.println("You can enter commands, Enter \\help\\ for more info...");

        while (!s1.equalsIgnoreCase("exit") && scanner.hasNext()) {
            String name;
            String argument;


            try {
                s1 = scanner.nextLine().trim();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
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
