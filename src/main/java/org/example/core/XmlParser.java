package org.example.core;



import lombok.Data;
import org.example.data.SpaceMarine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Data
public class XmlParser {
   private JAXBContext jaxbContext;


    public XmlParser() {
    }

    /**
     *
     * @param path
     * @return object of collection manager
     * @throws JAXBException
     */
   public CollectionManager convertXmlToObject(String path) throws JAXBException {

            File file = new File(path);
            jaxbContext = JAXBContext.newInstance(CollectionManager.class, SpaceMarine.class);
            return (CollectionManager) jaxbContext.createUnmarshaller().unmarshal(file);


   }


    public  void convertToXML(CollectionManager collectionManager, String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(CollectionManager.class,SpaceMarine.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName));
            marshaller.marshal(collectionManager, bufferedOutputStream);
            bufferedOutputStream.close();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            System.out.println("Error during converting java object to xml");
        }
    }
}
