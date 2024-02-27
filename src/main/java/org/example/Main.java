package org.example;
import org.example.core.*;
import org.example.exception.IllegalValueException;
import javax.xml.bind.JAXBException;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }