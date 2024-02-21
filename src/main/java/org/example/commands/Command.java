package org.example.commands;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.exception.IllegalValueException;
import org.example.exception.InvalidInputException;

@Data
@Getter
@Setter
public abstract class Command {
    private String name;
    private String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract boolean execute(String argument) throws IllegalValueException, InvalidInputException;

}
