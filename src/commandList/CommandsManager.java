package commandList;

import exceptions.CommandNotFoundException;
import utils.Logger;
import utils.UserInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandsManager {
    private ArrayList <Command> commandList = new ArrayList<>();
    private HashMap <String, Command> commands = new HashMap<>();

    public CommandsManager(){

        commandList.add(new Add());
        commandList.add(new Help());
        commandList.add(new Show());
        commandList.add(new Save());
        commandList.add(new RemoveById());
        commandList.add(new Info());
        commandList.add(new ExecuteScript());
        commandList.add(new Clear());
        commandList.add(new Exit());


//        !!!!
        commandList.add(new Privet());

        for(Command c : commandList)
            commands.put(c.getName(), c);

    }

    public Command findCommand(String name){
        try{
            if(!commands.containsKey(name))
                throw new CommandNotFoundException("Command `" + name + "` not found");
            return commands.get(name);
        }catch(CommandNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void executeCommand(String name, UserInterface ui, String[] args){
        Command command = findCommand(name);
        if(command != null)
            command.execute(ui, args);
    }

    public ArrayList <Command> getCommandList(){
        return commandList;
    }
    public HashMap <String, Command> getCommands(){
        return commands;
    }
}