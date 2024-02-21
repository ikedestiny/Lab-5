package org.example.commands;

import lombok.Getter;
import org.example.core.CollectionManager;
import org.example.core.Commander;

import java.util.InputMismatchException;
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
    public boolean execute(String argument) {


        try {
            this.getCollectionManager().getPriorityQueue().stream()
                    .filter(sp -> sp.getHealth() < Long.parseLong(argument))
                    .forEach(System.out::println);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("You entered a wrong argument type for the health");
        }

        return true;
    }
}
