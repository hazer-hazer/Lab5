package commandList;

import comps.HumanBeing;
import utils.Logger;
import utils.UserInterface;

import java.util.function.Predicate;

public class RemoveById extends Command {
    public RemoveById(){
        super("remove_by_id", "удалить элемент из коллекции по его id");
    }

    public void execute(UserInterface ui, String[] args){
        if(args.length == 0){
            Logger.printl("Please, specify HumanBeing id");
            return;
        }
        int id = Integer.parseInt(args[0]);
        ui.getCollection().removeIf(hb -> hb.getId().equals(id));
    }
}
