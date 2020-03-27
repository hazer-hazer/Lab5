package utils;

import collection.Collection;
import commandList.CommandsManager;
import comps.Car;
import comps.Coordinates;
import comps.HumanBeing;
import comps.Mood;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class UserInterface {

    JsonReader jsonReader = new JsonReader();
    JsonWriter jsonWriter = new JsonWriter();

    private boolean script;

    private String inputPath;
    private String outputPath;

    private Reader reader;
    private Writer writer;

    Collection collection;

    Scanner scanner;

    private CommandsManager commandsManager = new CommandsManager();

    /**
     * UserInterface constructor
     * @param reader Reader-interface
     * @param writer Writer-interface
     * @param inputPath Path to input file
     * @param outputPath Path to output file
     * */
    public UserInterface(Reader reader, Writer writer, String inputPath, String outputPath, boolean script){
        this.reader = reader;
        this.writer = writer;
        this.script = script;
        scanner = new Scanner(reader);

        this.inputPath = Paths.get(inputPath).toAbsolutePath().toString();
        this.outputPath = Paths.get(outputPath).toAbsolutePath().toString();

        try {
            collection = jsonReader.readCollection(this.inputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * getInputPath
     * @return path to input file
     * */
    public String getInputPath() {
        return inputPath;
    }

    /**
     * getOutputPath
     * @return path to output file
     * */
    public String getOutputPath(){
        return outputPath;
    }

    /**
     * saveCollection
     * Saves collection to the output file
     * */
    public void saveCollection() throws IOException {
        jsonWriter.writeCollection(outputPath, getCollection());
    }

    /**
     * setCollection
     * set collection by List-interface object
     * @param col List-interface
     * */
    public void setCollection(List col){
        collection.set(col);
    }

    /**
     * getCollection
     * @return collection
     * */
    public Collection getCollection(){
        return collection;
    }

    /**
     * executeCommand
     * execute command by line
     * */
    public void executeCommand(String line){
        commandsManager.executeCommand(line, this);
    }

    /**
     * hasNextLine
     * @return boolean true if reader has next line
     * */
    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }

    /**
     * read
     * @return reader next line
     * */
    public String read(){
        return scanner.nextLine();
    }

    /**
     * readWithMessage
     * @param msg String message
     * */
    public String readWithMessage(String msg){
        return readWithMessage(msg, str -> true);
    }

    /**
     * readWithMessage with specified condition Predicate
     * */
    public String readWithMessage(String msg, Predicate <String> condition){
        String str;
        do {
            if(!script){
                Logger.printl(msg);
            }
            str = read();
        }while(!condition.test(str));

        return str;
    }

    public Double readNumberWithMessage(String msg){
        return readNumberWithMessage(msg, (int)(Double.NEGATIVE_INFINITY), (int)(Double.POSITIVE_INFINITY));
    }

    private Double readNumberWithMessage(String msg, int max){
        return readNumberWithMessage(msg, (int)(Double.NEGATIVE_INFINITY), max);
    }

    private Double readNumberWithMessage(String msg, int min, int max){
        String string = readWithMessage(msg, str -> numberInRange(Double.parseDouble(str), min, max) );

        return Double.parseDouble(string);
    }

    /**
     * numberInRange
     * @return boolean true if number is in range
     * */
    private static boolean numberInRange(double s, int min, int max) {
        return ((min < 0 || Math.abs(s - min) < 10e-9 || s > min) && (max < 0 || s <= max));
    }

    /**
     * readBool
     * @return boolean read from reader
     * */
    private boolean readBool(String msg){
        msg += " (bool can be true/false)";
        String boolVal = readWithMessage(msg, str -> str.equals("true") || str.equals("false"));
        return Boolean.parseBoolean(boolVal);
    }

    /**
     * readCoordinates
     * @return Coordinates read from reader
     * */
    private Coordinates readCoordinates(){
        Logger.printl("Type Coordinates X and Y");
        Integer x = readNumberWithMessage("Type Integer `x` (<= 319)", 319).intValue();
        Integer y = readNumberWithMessage("Type Integer `y`", (int)(Double.POSITIVE_INFINITY)).intValue();
        return new Coordinates(x, y);
    }

    /**
     * readMood
     * @return Mood read from reader
     * */
    private Mood readMood(){
        String name = readWithMessage("Type mood (" +
                                        String.join("/", Mood.getNames()) +
                                        ")", Mood::has);
        return Mood.valueOf(name);
    }

    /**
     * readCar
     * @return Car read from reader
     * */
    private Car readCar(){
        return new Car(readWithMessage("Type Car name"));
    }

    /**
     * readHumanBeing
     * @return HumanBeing that was read from reader
     * */
    public HumanBeing readHumanBeing(){
        String name = readWithMessage("Type HumanBeing name");
        Coordinates coords = readCoordinates();
        boolean realHero = readBool("Real Hero?");
        boolean hasToothpick = readBool("Has tooth pick?");
        float impactSpeed = readNumberWithMessage("Type impact speed").floatValue();
        String soundtrackName = readWithMessage("Type soundtrack name");
        float minutesOfWaiting = readNumberWithMessage("Type minutes of waiting").floatValue();
        Mood mood = readMood();
        Car car = readCar();

        return new HumanBeing(name, coords, realHero, hasToothpick, impactSpeed, soundtrackName, minutesOfWaiting, mood, car);
    }
}
