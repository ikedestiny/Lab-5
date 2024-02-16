package org.example.core;

import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 */
@Data
public class InputManager {
    private Scanner scanner;
    private String commandScriptPath;

    public InputManager(String commandScriptPath) {
        try {
            this.scanner = new Scanner(new File(commandScriptPath));
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        }
    }


}
