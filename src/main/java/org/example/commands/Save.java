package org.example.commands;


import org.example.core.CollectionManager;
import org.example.core.Commander;
import org.example.core.XmlParser;

public class Save extends Command {
    private final CollectionManager collectionManager;
    private final XmlParser parser = new XmlParser();
    private final String fileName;


    /**
     * this class saves the collection to a file in xml format
     *
     * @param commander
     * @param filename
     */
    public Save(Commander commander, String filename) {
        super("save", "saves the collection to a file");
        this.fileName = filename;
        this.collectionManager = commander.getCollectionManager();
    }

    @Override
    public boolean execute(String argument) {
        parser.convertToXML(collectionManager, fileName);
        return true;
    }
}
