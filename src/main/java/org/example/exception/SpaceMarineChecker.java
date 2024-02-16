package org.example.exception;

import org.example.data.SpaceMarine;

import java.lang.reflect.Field;

public class SpaceMarineChecker {

    public void checkSpaceMarine(SpaceMarine spaceMarine){
        Field[] fields = SpaceMarine.class.getDeclaredFields();

    }
}
