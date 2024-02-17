package org.example.core;
import java.io.DataInputStream;
import java.util.*;

public class ConsoleManager {
    Scanner scanner = new Scanner(new DataInputStream(System.in));
    private final Commander commander;

    public ConsoleManager(Commander commander) {
        this.commander = commander;
    }

    public void Start(){
        String s1 = "";
        System.out.println("You can enter commands, Enter \\help\\ for more info...");
        while (!s1.equalsIgnoreCase("exit")&& scanner.hasNext()){
            s1 = scanner.next();
            boolean ex = false;
            for (var com: commander.getCommands()){
                if (com.getName().equalsIgnoreCase(s1)){
                    com.execute();
                    ex = true;
                    commander.getHistory().add(s1);
                }
            }
            if (!ex){System.out.println("No such command");}
            System.out.print("==>");

        }
    }


}
