package org.example.commands;


import org.example.core.CollectionManager;
import org.example.core.Commander;
import org.example.core.JacksonParser;
import org.example.core.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;

public class Save extends Command{
    private  final CollectionManager collectionManager;
    private final XmlParser parser = new XmlParser();
    private final String fileName;


    public Save(Commander commander, String filename) {
        super("save","saves the collection to a file");
        this.fileName = filename;
        this.collectionManager = commander.getCollectionManager();
    }

    @Override
    public boolean execute() {
        parser.convertToXML(collectionManager,fileName);
        return  true;
    }
}
