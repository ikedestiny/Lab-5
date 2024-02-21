package org.example.commands;

import org.example.core.CollectionManager;
import org.example.core.Commander;

import java.util.Scanner;

public class RemoveLower extends Command{
    private final CollectionManager collectionManager;
    private final Scanner scanner = new Scanner(System.in);


    public RemoveLower(Commander commander) {
        super("RemoveLower", "remove all elements from a collection smaller than a given one");
        this.collectionManager = commander.getCollectionManager();
    }

    @Override
    public boolean execute(String argument) {
        try {
            collectionManager.getPriorityQueue().removeIf(s -> s.getId() > Integer.parseInt(argument));
            return true;
        } catch (NumberFormatException e) {
            System.out.println("The format of the argument is not right, collects an Integer Id");
            return false;
        }
    }
}
