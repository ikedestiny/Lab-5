package org.example.commands;


import lombok.Getter;
import lombok.Setter;
import org.example.core.CollectionManager;
import org.example.core.Commander;

import java.util.Scanner;

@Getter
@Setter
public class RemoveById extends  Command{
    private final CollectionManager collectionManager;
    private final Scanner scanner = new Scanner(System.in);

    public RemoveById(Commander commander) {
        super("removeById", "removes space marine whose id matches the given one from the collection");
        this.collectionManager = commander.getCollectionManager();
    }


    @Override
    public boolean execute() {
        System.out.println();
        System.out.print("Enter id: ");
        this.getCollectionManager().removeById(scanner.nextInt());
        return true;
    }
}
