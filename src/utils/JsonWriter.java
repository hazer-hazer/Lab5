package utils;

import collection.Collection;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import comps.HumanBeingDTO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JsonWriter {
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * JsonWriter constructor
     * Configures objectMapper
     * */
    public JsonWriter(){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.findAndRegisterModules();
    }

    /**
     * writeCollection
     * @param path String path to output file
     * @param col Collection to write to file
     * */
    public void writeCollection(String path, Collection col) throws IOException {
        File file = new File(path);
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(col.asDTOArray()).getBytes());
        outputStream.close();
    }
}
