package org.example.commands;


import lombok.Getter;
import lombok.Setter;
import org.example.core.CollectionManager;
import org.example.core.Commander;
import org.example.core.SpaceMarineCreator;
import org.example.data.SpaceMarine;

import java.util.Scanner;

@Getter
@Setter
public class UpdateById extends Command{
    private final SpaceMarineCreator spaceMarineCreator;
    private final CollectionManager collectionManager;
    Scanner scanner = new Scanner(System.in);

    public UpdateById(Commander commander) {
        super("UpdateById", "updates a given element in the collection by its id");
        this.spaceMarineCreator = commander.getSpaceMarineCreator();
        collectionManager = commander.getCollectionManager();
    }


    @Override
    public boolean execute(String argument) {
        try {
            SpaceMarine sp = collectionManager.findById(Integer.parseInt(argument));
            if (sp != null) {
                this.getCollectionManager().
                        updateById(spaceMarineCreator.createSpaceMarine(), Integer.parseInt(argument));
                return true;
            } else return false;
        } catch (NumberFormatException e) {
            System.out.println("The command was not entered right, check the argument");
        }
        return false;
    }


}
