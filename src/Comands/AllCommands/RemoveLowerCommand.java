package Comands.AllCommands;

import Collection.CollectionManager;
import Comands.Command;

/**
 * Класс команды удаления из коллекции всех элементов, которые меньше чем заданный по id
 * @author Захарченко Роман
 */
public class RemoveLowerCommand implements Command {
    CollectionManager cm = new CollectionManager();
    @Override
    public void execute(String[] tokens) {
        if (tokens.length > 2){
            System.out.println("The 'remove_lower' command does not require 2 or more arguments. Try again.");
        }else if(tokens.length == 1) System.out.println("This command requires an argument. Try again!");
        else {
            try{
                if (Long.parseLong(tokens[1]) > 0) {
                    cm.removeLower(Long.parseLong(tokens[1]));
                    System.out.println("Complete!");
                }
                else System.out.println("Error! id > 0");
            }catch (NumberFormatException e) {
                System.out.println("Argument type error. Try again!");
            }
        }
    }
}
