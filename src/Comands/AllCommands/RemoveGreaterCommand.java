package Comands.AllCommands;

import Collection.CollectionManager;
import Comands.Command;

/**
 * Класс команды удаления из коллекции всех элементов, превышающие заданный по id
 * @author Захарченко Роман
 */
public class RemoveGreaterCommand implements Command {
    CollectionManager cm = new CollectionManager();
    @Override
    public void execute(String[] tokens) {
        if (tokens.length > 2){
            System.out.println("The 'remove_greater' command does not require 2 or more arguments. Try again.");
        }else if(tokens.length == 1) System.out.println("This command requires an argument. Try again!");
        else {
            try{
                if (Long.parseLong(tokens[1]) > 0) cm.removeGreater(Long.parseLong(tokens[1]));
                else System.out.println("Error! id > 0");
            }catch (NumberFormatException nfe) {
                System.out.println("Argument type error. Try again!");
            }
        }
    }
}
