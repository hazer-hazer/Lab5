package commandList;

import utils.Logger;
import utils.UserInterface;

public class Exit extends Command {
    public Exit(){
        super("exit", "завершить программу (без сохранения в файл)");
    }

    public void execute(UserInterface ui, String[] args){
        Logger.illmissu();
        System.exit(-1);
    }
}
