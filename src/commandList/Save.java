package commandList;

import utils.Logger;
import utils.UserInterface;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

public class Save extends Command {
    public Save(){
        super("save", "сохранить коллекцию в файл");
    }

    public void execute(UserInterface ui, String[] args) {
        try{
            ui.saveCollection();
            Logger.printl("Collection saved successfully");
        }catch(AccessDeniedException e){
            Logger.printl("No permissions to save output file");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
