package commandList;

import comps.Mood;
import utils.Logger;
import utils.UserInterface;

public class CountGreaterThanMood extends Command {
    public CountGreaterThanMood(){
        super("count_greater_than_mood", "mood : вывести количество элементов, значение поля mood которых больше заданного");
    }

    public void execute(UserInterface ui, String[] args){
        if(args.length == 0){
            Logger.printl("Please, specify mood");
            return;
        }
        Mood mood = Mood.valueOf(args[0]);
        long count = ui.getCollection().asList().stream().filter(h -> h.getMood().ordinal() > mood.ordinal()).count();
        Logger.printl(count, "HumanBeings with mood more than", mood);
    }
}
