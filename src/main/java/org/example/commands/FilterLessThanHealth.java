package org.example.commands;

import lombok.Getter;
import org.example.core.CollectionManager;
import org.example.core.Commander;

import java.util.Scanner;

@Getter
public class FilterLessThanHealth extends Command{
    private final CollectionManager collectionManager;
    Scanner scanner = new Scanner(System.in);

    public FilterLessThanHealth(Commander commander){
        super("FilterLessThanHealth","display elements whose health field value is less than the specified value");
        this.collectionManager = commander.getCollectionManager();
    }

    @Override
    public boolean execute() {
        int health;
        System.out.println("Enter Health:");
        health = scanner.nextInt();
        this.getCollectionManager().getPriorityQueue().stream()
                .filter(sp->sp.getHealth()>health)
                .forEach(System.out::println);

        return  true;
    }
}
