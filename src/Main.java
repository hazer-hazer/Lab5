import commandList.Privet;
import exceptions.CommandNotFoundException;
import utils.IO;
import utils.Logger;

public class Main {
    public static void main(String[] args){
        try{
            if(args.length != 2){
                throw new Exception("please, specify input and output paths");
            }
            IO io = new IO(args[0], args[1]);

            Logger.randPrivet();
            io.listen();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
