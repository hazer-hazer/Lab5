package commandList;

import utils.Logger;
import utils.UserInterface;

import java.io.IOException;

public class Save extends Command {
    public Save(){
        super("save", "сохранить коллекцию в файл");
    }

    public void execute(UserInterface ui, String[] args) {
        try{
            ui.saveCollection();
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            Logger.printl("Collection saved successfully");
        }
    }
}
