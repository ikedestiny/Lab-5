package org.example.commands;

import lombok.Getter;
import lombok.Setter;
import org.example.core.CollectionManager;
import org.example.core.Commander;

import java.util.Scanner;
@Setter
@Getter
public class FilterStartsWithName extends Command{
    private final CollectionManager collectionManager;
    Scanner scanner = new Scanner(System.in);

    public FilterStartsWithName(Commander commander) {
        super("FilterStartsWithName","display elements whose name field value begins with the given substring");
        this.collectionManager = commander.getCollectionManager();
    }

    @Override
    public boolean execute() {
        String name;
        System.out.println("Enter substring:");
        name = scanner.next();
        this.getCollectionManager().getPriorityQueue().stream()
                .filter(sp->sp.getName().startsWith(name))
                .forEach(System.out::println);

        return  true;
    }
}
