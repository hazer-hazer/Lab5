package commandList;

import collection.Collection;
import comps.HumanBeing;
import utils.Logger;
import utils.UserInterface;

public class FilterContainsName extends Command {
    public FilterContainsName(){
        super("filter_contains_name", "name : вывести элементы, значение поля name которых содержит заданную подстроку");
    }

    public void execute(UserInterface ui, String[] args){
        Collection col = ui.getCollection();
        String substr = args[0];
        for (HumanBeing hb : col.asList()){
            if(hb.getName().contains(substr)) {
                Logger.printl(hb);
            }
        }
    }
}
