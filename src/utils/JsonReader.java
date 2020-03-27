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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class JsonReader {
    private ObjectMapper objectMapper = new ObjectMapper();

    public JsonReader(){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.findAndRegisterModules();
    }

    public Collection readCollection(String path) throws IOException {
        try{
            FileReader fr = new FileReader(path);
            HumanBeingDTO[] col = objectMapper.readValue(fr, HumanBeingDTO[].class);
            fr.close();
            return new Collection(col);
        }catch (ClassCastException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
