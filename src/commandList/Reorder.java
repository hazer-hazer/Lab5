package commandList;

import collection.Collection;
import comps.HumanBeing;
import utils.UserInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Reorder extends Command {
    public Reorder(){
        super("reorder", "отсортировать коллекцию в порядке, обратном нынешнему");
    }

    public void execute(UserInterface ui, String[] args){
        ArrayList col = ui.getCollection().asList();
        Collections.sort(col, HumanBeingComparator);
        ui.setCollection(col);
    }

    private static Comparator<HumanBeing> HumanBeingComparator = Comparator.comparing(HumanBeing::getId);
}
