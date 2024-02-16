package org.example.commands;


import lombok.Getter;
import lombok.Setter;
import org.example.core.CollectionManager;
import org.example.core.Commander;
import org.example.core.SpaceMarineCreator;
import org.example.data.SpaceMarine;
import org.example.exception.InvalidInputException;

import java.util.Scanner;

@Getter
@Setter
public class UpdateById extends Command{
    private final CollectionManager cm;
    private final SpaceMarineCreator spaceMarineCreator;
    Scanner scanner = new Scanner(System.in);

    public UpdateById(Commander commander) {
        super("UpdateById", "updates a given element in the collection by its id");
        this.cm = commander.getCollectionManager();
        this.spaceMarineCreator = commander.getSpaceMarineCreator();
    }



    @Override
    public boolean execute() {
        System.out.println("Enter id of SpaceMarine: ");
        int id = scanner.nextInt();
        SpaceMarine spaceMarine = null;
        try {
            spaceMarine = spaceMarineCreator.createSpaceMarine();
        } catch (InvalidInputException e) {
            e.getMessage();
        }
        cm.updateById(spaceMarine,id);
        return  true;
    }


}
