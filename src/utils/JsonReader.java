package utils;


import collection.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import comps.HumanBeing;
import comps.HumanBeingDTO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class JsonReader {
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * JsonReader constructor
     * Configures objectMapper
     * */
    public JsonReader(){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.findAndRegisterModules();
    }

    /**
     * readCollection
     * @param path String path to file
     * */
    public Collection readCollection(String path) throws IOException {
        try{
            FileReader fr = new FileReader(path);
            HumanBeingDTO[] col = objectMapper.readValue(fr, HumanBeingDTO[].class);
            fr.close();
            return new Collection(col);
        }catch(AccessDeniedException e){
            Logger.error("Cannot read from input file. Access denied");
            return null;
        }catch (ClassCastException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
