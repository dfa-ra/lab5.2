package Comands.AllCommands;

import Collection.CollectionManager;
import Comands.Command;

/**
 * Класс команды удаления элемента из коллекции по его id
 * @author Захарченко Роман
 */
public class RemoveByIdCommand implements Command {
    CollectionManager cm = new CollectionManager();
    @Override
    public void execute(String[] tokens) {
        if (tokens.length > 2){
            System.out.println("The 'remove_by_id' command does not require 2 or more arguments. Try again.");
        }else if(tokens.length == 1) System.out.println("This command requires an argument. Try again!");
        else {
            try{
                if (Long.parseLong(tokens[1]) > 0) cm.removeById(Long.parseLong(tokens[1]));
                else System.out.println("Error! id > 0");
            }catch (NumberFormatException nfe) {
                System.out.println("Argument type error. Try again!");
            }
        }
    }
}
