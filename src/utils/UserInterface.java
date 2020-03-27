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

    public String getInputPath() {
        return inputPath;
    }
    public String getOutputPath(){
        return outputPath;
    }

    public void saveCollection() throws IOException {
        jsonWriter.writeCollection(outputPath, getCollection());
    }

    public Collection getCollection(){
        return collection;
    }

    public void executeCommand(String name, String[] args){
        commandsManager.executeCommand(name, this, args);
    }

    public void executeCommand(String line){
        commandsManager.executeCommand(line, this);
    }

    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }

    public String read(){
        return scanner.nextLine();
    }

    public String readWithMessage(String msg){
        return readWithMessage(msg, str -> true);
    }

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

    private static boolean numberInRange(double s, int min, int max) {
        return ((min < 0 || Math.abs(s - min) < 10e-9 || s > min) && (max < 0 || s <= max));
    }

    private boolean readBool(String msg){
        msg += " (bool can be true/false)";
        String boolVal = readWithMessage(msg, str -> str.equals("true") || str.equals("false"));
        return Boolean.parseBoolean(boolVal);
    }

    private Coordinates readCoordinates(){
        Logger.printl("Type Coordinates X and Y");
        Integer x = readNumberWithMessage("Type Integer `x` (<= 319)", 319).intValue();
        Integer y = readNumberWithMessage("Type Integer `y`", (int)(Double.POSITIVE_INFINITY)).intValue();
        return new Coordinates(x, y);
    }

    private Mood readMood(){
        String name = readWithMessage("Type mood (" +
                                        String.join("/", Mood.getNames()) +
                                        ")", Mood::has);
        return Mood.valueOf(name);
    }

    private Car readCar(){
        return new Car(readWithMessage("Type Car name"));
    }

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
