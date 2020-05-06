package commandList;

import org.jetbrains.annotations.NotNull;
import utils.Logger;
import utils.UserInterface;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ExecuteScript extends Command {
    private static ArrayList<Path> executedPaths = new ArrayList<>();

    public ExecuteScript(){
        super("execute_script", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    public void execute(UserInterface ui, @NotNull String[] args){
        try{
            if(args.length == 0){
                throw new IndexOutOfBoundsException("Please, specify path to file");
            }

            Path path = Paths.get(args[0]);

            if(executedPaths.contains(path)){
                Logger.error("Recursion detected");
                return;
            }

            executedPaths.add(path);

            Logger.printl("run script by path", path, "...");

            UserInterface scriptUi = new UserInterface(new FileReader(path.toFile()),
                                                       new OutputStreamWriter(System.out),
                                                       ui.getInputPath(), ui.getOutputPath(), true);

            while(scriptUi.hasNextLine()){
                String line = scriptUi.read();
                scriptUi.executeCommand(line);
            }

        }catch (IndexOutOfBoundsException | IOException e){
            Logger.error(e.getMessage());
        }
        executedPaths = new ArrayList<>();
    }
}
