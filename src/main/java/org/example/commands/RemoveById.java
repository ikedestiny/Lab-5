package org.example.commands;


import lombok.Getter;
import lombok.Setter;
import org.example.core.CollectionManager;
import org.example.core.Commander;
import org.example.exception.IllegalValueException;

import java.util.Scanner;

@Getter
@Setter
public class RemoveById extends  Command{
    private final CollectionManager collectionManager;
    private final Scanner scanner = new Scanner(System.in);

    public RemoveById(Commander commander) {
        super("removeById",
                "removes space marine whose id matches the given one from the collection");
        this.collectionManager = commander.getCollectionManager();
    }


    @Override
    public boolean execute(String argument) throws IllegalValueException {
        try {
            System.out.println();
            this.getCollectionManager().removeById(Integer.parseInt(argument));
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalValueException("The format of the id wasnt right. Its supposed to be a number");
        }
    }
}
