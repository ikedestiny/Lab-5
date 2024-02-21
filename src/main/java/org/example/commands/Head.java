package org.example.commands;

import org.example.core.CollectionManager;
import org.example.core.Commander;

public class Head extends Command{
    private final CollectionManager collectionManager;

    public Head(Commander commander) {
        super("head", "prints first element in the collection");
        this.collectionManager = commander.getCollectionManager();
    }


    @Override
    public boolean execute(String argument) {
        System.out.println();
        System.out.println(collectionManager.getPriorityQueue().peek());
        return true;
    }
}
