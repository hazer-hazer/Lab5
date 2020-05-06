package commandList;

import comps.HumanBeing;
import utils.Logger;
import utils.UserInterface;

public class InsertAt extends Command {
    public InsertAt(){
        super("insert_at", "index {element} : добавить новый элемент в заданную позицию");
    }

    public void execute(UserInterface ui, String[] args){
        if(args.length == 0){
            Logger.error("Please, specify index");
            return;
        }
        int index;
        try{
            index = Integer.parseInt(args[0]);
        }catch(Exception e){
            Logger.error("Please, type a number");
            return;
        }
        if(index > ui.getCollection().getSize() || index < 0){
            Logger.error("Index is out of collection bounds");
            return;
        }
        HumanBeing humanBeing = ui.readHumanBeing();
        ui.getCollection().insertAt(index, humanBeing);
    }
}
