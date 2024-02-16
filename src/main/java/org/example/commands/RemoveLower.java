package org.example.commands;

import org.example.core.CollectionManager;
import org.example.core.Commander;

import java.util.Scanner;

public class RemoveLower extends Command{
    private final CollectionManager collectionManager;
    private Scanner scanner = new Scanner(System.in);


    public RemoveLower(Commander commander) {
        super("RemoveLower", "remove all elements from a collection smaller than a given one");
        this.collectionManager = commander.getCollectionManager();
    }

    @Override
    public boolean execute() {
        int id;
        System.out.print("Enter id of spaceMarine to remove lower: ");
        id = scanner.nextInt();
        collectionManager.getPriorityQueue().removeIf(s->s.getId()>id);
        return true;
    }
}
