package commandList;

import comps.HumanBeing;
import utils.Logger;
import utils.UserInterface;

public class RemoveAnyByImpactSpeed extends Command {
    public RemoveAnyByImpactSpeed(){
        super("remove_any_by_impact_speed", "impactSpeed : удалить из коллекции один элемент, значение поля impactSpeed которого эквивалентно заданному");
    }

    public void execute(UserInterface ui, String[] args){
        if(args.length == 0){
            Logger.error("Please, specify impact speed");
            return;
        }
        float impactSpeed;
        try{
            impactSpeed = Float.parseFloat(args[0]);
        }catch(Exception e){
            Logger.error("Please, type a valid number");
            return;
        }
        for(HumanBeing h : ui.getCollection().asList()){
            if(h.getImpactSpeed() == impactSpeed){
                ui.getCollection().removeById(h.getId());
                Logger.printl("Removed HumanBeing(", h.getId(), ") with impact speed", impactSpeed);
                return;
            }
        }
        Logger.printl("No HumanBeings found with impact speed", impactSpeed);
    }
}
