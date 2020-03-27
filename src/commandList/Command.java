package commandList;

import utils.UserInterface;

/**
 * CommandInterface
 * */
interface CommandInterface{
    void execute(UserInterface ui, String[] args);
    String getName();
    String getHelp();
}

/**
 * Command
 * void execute() - virtual function that overrides in every command-inherited class
 * String getName() - returns name
 * String getHelp() - return help
 * */
public abstract class Command implements CommandInterface{
    protected final String name;
    protected final String help;

    public Command(String name, String help){
        this.name = name;
        this.help = help;
    }

    public String getName(){
        return name;
    }

    public String getHelp(){
        return help;
    }
}