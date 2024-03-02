package org.example;
import org.example.core.*;
import org.example.exception.IllegalValueException;
import org.example.exception.InvalidInputException;

import javax.xml.bind.JAXBException;
import java.io.EOFException;
import java.util.NoSuchElementException;
public class Main {
    public static void main(String[] args) {
        XmlParser xmlParser = new XmlParser();
        CollectionManager collectionManager = null;
        try {
            collectionManager = xmlParser.convertXmlToObject(System.getenv("PATH_TO_XML"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        SpaceMarineCreator spaceMarineCreator = new SpaceMarineCreator();
        Commander commander = new Commander(collectionManager, spaceMarineCreator, System.getenv("PATH_TO_XML"),
                System.getenv("PATH_TO_SCRIPT"));
        ConsoleManager cs = new ConsoleManager(commander);
        try {
            cs.Start();
        } catch (IllegalValueException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Not a valid input");

        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
    }