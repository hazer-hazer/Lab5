package utils;

import commandList.CommandsManager;
import comps.Car;
import comps.Coordinates;
import comps.HumanBeing;
import comps.Mood;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class IO {
    private Scanner scanner;
    private UserInterface ui;
    private CommandsManager commandsManager = new CommandsManager();

    /**
     * Constructor
     * @param inputPath path to json input file
     * @param outputPath path to json output file
     * */
    public IO(String inputPath, String outputPath) {
        ui = new UserInterface(new InputStreamReader(System.in, StandardCharsets.UTF_8),
                               new OutputStreamWriter(System.out, StandardCharsets.UTF_8),
                                inputPath, outputPath, false);

        /* FOR DEBUG */
        /* FAST WAY TO PUSH ELEMENT */
//        HumanBeing h = new HumanBeing(
//                117,
//                "Agvin",
//                new Coordinates(5, 10),
//                LocalDateTime.now(),
//                true,
//                false,
//                10.0f,
//                "Again.wav",
//                69.42f,
//                Mood.SADNESS,
//                new Car("MY CAR, BITCH")
//        );
//        ui.getCollection().add(h);
    }

    /**
     * Listen to commands
     * */
    public void listen(){
        Logger.print("> ");
        String line = ui.read();
        ui.executeCommand(line);
        listen();
    }
}
