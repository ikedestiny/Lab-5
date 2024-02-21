package org.example.commands;


import lombok.Getter;
import lombok.Setter;
import org.example.core.CollectionManager;
import org.example.core.Commander;

@Getter
@Setter
public class Info extends Command{
    private final CollectionManager collectionManager;

    public Info(Commander commander) {
        super("info", "prints info about collection like size creation date etc");
        this.collectionManager = commander.getCollectionManager();
    }

    @Override
    public boolean execute(String argument) {
        System.out.println();
        System.out.printf("""
                        Collection type    -- %s
                        Number of elements -- %d
                        Creation date      -- %s
                        """, this.getCollectionManager().getPriorityQueue().getClass().getSimpleName(),
                this.getCollectionManager().getPriorityQueue().size(),
                this.getCollectionManager().getCreationDate());
        return true;
    }
}
