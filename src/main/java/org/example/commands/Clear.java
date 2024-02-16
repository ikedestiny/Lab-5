package org.example.commands;


import lombok.Getter;
import lombok.Setter;
import org.example.core.CollectionManager;
import org.example.core.Commander;

@Setter
@Getter
public class Clear extends Command{
    private final CollectionManager collectionManager;

    public Clear(Commander commander) {
        super("clear", "remove all element from collection");
        this.collectionManager = commander.getCollectionManager();
    }

    @Override
    public boolean execute() {
        System.out.println();
        collectionManager.clear();
        return true;
    }
}
