package commandList;

import comps.HumanBeing;
import utils.Logger;
import utils.UserInterface;

public class Update extends Command {
    public Update(){
        super("update", "id {element} : обновить значение элемента коллекции, id которого равен заданному");
    }

    public void execute(UserInterface ui, String[] args){
        if(args.length < 1){
            Logger.error("Please, specify HumanBeing ID");
            return;
        }
        Integer id;
        try {
            id = Integer.parseInt(args[0]);
        }catch(Exception e){
            Logger.error("Please, type a valid id");
            return;
        }
        if(!ui.getCollection().hasId(id)){
            Logger.error("HumanBeing with id", id, "does not exists");
            return;
        }
        HumanBeing humanBeing = ui.readHumanBeing();
        ui.getCollection().update(id, humanBeing);
    }
}
