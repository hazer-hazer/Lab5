package commandList;

import org.jetbrains.annotations.NotNull;
import utils.Logger;
import utils.UserInterface;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ExecuteScript extends Command {
    public ExecuteScript(){
        super("execute_script", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    public void execute(UserInterface ui, @NotNull String[] args){
        try{
            if(args.length == 0)
                throw new IndexOutOfBoundsException("Please, specify path to file");

            Path path = Paths.get(args[0]);

            Logger.printl("run script by path", path);

            UserInterface scriptUi = new UserInterface(new FileReader(path.toFile(), StandardCharsets.UTF_8),
                                                       new OutputStreamWriter(System.out, StandardCharsets.UTF_8),
                                                       ui.getInputPath(), ui.getOutputPath(), true);

            while(scriptUi.hasNextLine()){
                String line = scriptUi.read();
                scriptUi.executeCommand(line);
            }

        }catch (IndexOutOfBoundsException | IOException e){
            Logger.printl(e.getMessage());
        }
    }
}
