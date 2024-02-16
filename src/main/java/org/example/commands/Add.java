package org.example.commands;
import lombok.Getter;
import lombok.Setter;
import org.example.core.CollectionManager;
import org.example.core.Commander;
import org.example.core.SpaceMarineCreator;
import org.example.exception.InvalidInputException;


@Getter
@Setter
public class Add extends Command {
        private final CollectionManager collectionManager;
        private final SpaceMarineCreator spaceMarineCreator = new SpaceMarineCreator();
    public Add(Commander commander) {
        super("add","Add element to collection");
        this.collectionManager =commander.getCollectionManager();
    }


    @Override
    public boolean execute() {
        System.out.println();
        try {
            this.collectionManager.add( this.getSpaceMarineCreator().createSpaceMarine());
        } catch (InvalidInputException e) {
            e.getMessage();
        }
        return true;
    }

}
