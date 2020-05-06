package commandList;

import comps.Car;
import comps.Coordinates;
import comps.HumanBeing;
import comps.Mood;
import utils.UserInterface;

import java.util.Scanner;

public class Add extends Command {
    public Add(){
        super("add", "добавить новый элемент в коллекцию");
    }


    public void execute(UserInterface ui, String[] args){
        HumanBeing humanBeing = ui.readHumanBeing();
        ui.getCollection().add(humanBeing);
    }

}
