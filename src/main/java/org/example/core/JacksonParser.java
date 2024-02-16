package org.example.core;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Data
public class JacksonParser {
        private ObjectMapper objectMapper = new XmlMapper();


        public CollectionManager convertXmlToCollectionManager(String filepath){
            try {
                return objectMapper.readValue(
                        StringUtils.toEncodedString(Files.readAllBytes(Paths.get(filepath)), StandardCharsets.UTF_8),
                        CollectionManager.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public void convertCollectionManagerToXml(CollectionManager collectionManager,String filepath)  {
            objectMapper.setDefaultPrettyPrinter(new DefaultPrettyPrinter());
            try {
                objectMapper.writeValue(new File(filepath),collectionManager);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
