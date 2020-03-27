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
            Logger.printl("Please, specify HumanBeing ID");
            return;
        }
        Integer id;
        try {
            id = Integer.parseInt(args[0]);
        }catch(ClassCastException e){
            Logger.printl(e.getMessage());
            return;
        }
        HumanBeing humanBeing = ui.readHumanBeing();
        if(!ui.getCollection().update(id, humanBeing)){
            Logger.printl("HumanBeing with id", id, "does not exists");
        }
    }
}
