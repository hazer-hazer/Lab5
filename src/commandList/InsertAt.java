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
            Logger.printl("Please, specify index");
            return;
        }
        int index = Integer.parseInt(args[0]);
        if(index > ui.getCollection().getSize() || index < 0){
            Logger.printl("Index is out of collection bounds");
            return;
        }
        HumanBeing humanBeing = ui.readHumanBeing();
        ui.getCollection().insertAt(index, humanBeing);
    }
}
