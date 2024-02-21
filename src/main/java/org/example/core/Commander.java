package org.example.core;

import lombok.Data;
import org.example.commands.*;
import org.example.exception.IllegalValueException;
import org.example.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

@Data
public class Commander {
    private final List<Command> commands = new ArrayList<>();
    private CollectionManager collectionManager;
    private final SpaceMarineCreator spaceMarineCreator;
    private String xmlFIle;
    private ArrayList<String> history = new ArrayList<>();
    private InputManager inputManager;

    public Commander(CollectionManager collectionManager, SpaceMarineCreator spaceMarineCreator, String xmlFIle, String commandfile) {
        this.collectionManager = collectionManager;
        this.spaceMarineCreator = spaceMarineCreator;
        this.inputManager = new InputManager(commandfile);
        this.xmlFIle = xmlFIle;
        addCommands();
    }


    public void addCommands() {
        commands.add(new Add(this));
        commands.add(new Clear(this));
        commands.add(new Show(this));
        commands.add(new UpdateById(this));
        commands.add(new Help(this));
        commands.add(new Info(this));
        commands.add(new RemoveById(this));
        commands.add(new Exit());
        commands.add(new Save(this, xmlFIle));
        commands.add(new ExecuteScript(this));
        commands.add(new Head(this));
        commands.add(new RemoveLower(this));
        commands.add(new History(this));
        commands.add(new CountGreaterThanCategory(this));
        commands.add(new FilterStartsWithName(this));
        commands.add(new FilterLessThanHealth(this));

    }


    public void doCommand(String commandName) throws IllegalValueException, InvalidInputException {
        for (var com : this.getCommands()) {
            if (com.getName().trim().startsWith(commandName)) {
                com.execute(commandName.split(",")[1]);
            }
        }
    }








}
