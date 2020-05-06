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
            Logger.error("Please, specify HumanBeing id");
            return;
        }
        int id;
        try{
            id = Integer.parseInt(args[0]);
        }catch(Exception e){
            Logger.error("Please, specify a valid id");
            return;
        }
        ui.getCollection().removeIf(hb -> hb.getId().equals(id));
    }
}
