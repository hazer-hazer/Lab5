package commandList;

import comps.HumanBeing;
import utils.Logger;
import utils.UserInterface;

public class RemoveGreater extends Command {
    public RemoveGreater(){
        super("remove_greater", "{element} : удалить из коллекции все элементы, превышающие заданный");
    }

    public void execute(UserInterface ui, String[] args){
        HumanBeing humanBeing = ui.readHumanBeing();
        int sizeBefore = ui.getCollection().getSize();
        ui.getCollection().removeIf(x -> x.greaterThan(humanBeing));
        Logger.printl("Removed", sizeBefore - ui.getCollection().getSize(), "elements from collection");
    }
}
