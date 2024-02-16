package org.example;


import org.example.core.*;

import javax.xml.bind.JAXBException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        XmlParser xmlParser = new XmlParser();

        CollectionManager collectionManager = null;
        try {
            collectionManager = xmlParser.convertXmlToObject("src/main/java/org/example/data/test.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        SpaceMarineCreator spaceMarineCreator = new SpaceMarineCreator();
        Commander commander = new Commander(collectionManager, spaceMarineCreator, "src/main/java/org/example/data/test2.xml","src/main/java/org/example/data/testfile");

        System.out.println(System.getenv("HOMEDRIVE"));




        ConsoleManager cs = new ConsoleManager(commander);
        cs.Start();

    }
    }