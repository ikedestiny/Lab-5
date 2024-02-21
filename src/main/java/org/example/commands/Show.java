package org.example.commands;


import lombok.Getter;
import lombok.Setter;
import org.example.core.CollectionManager;
import org.example.core.Commander;


@Setter
@Getter
public class Show extends Command {
    private CollectionManager collectionManager;

    public Show(Commander commander) {
        super("show", "prints all the elements in the collection");
        this.collectionManager = commander.getCollectionManager();
    }

    @Override
    public boolean execute(String argument) {
        this.collectionManager.show();
        return true;
    }
}
