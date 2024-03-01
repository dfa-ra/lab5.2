package Comands.AllCommands;

import Collection.CollectionManager;
import Comands.Command;

/**
 * Класс вывода значения поля type всех элементов в порядке убывания
 */
public class PrintFieldDescendingTypeCommand implements Command {
    CollectionManager cm = new CollectionManager();
    @Override
    public void execute(String[] tokens) throws Exception {
        if (tokens.length > 1){
            System.out.println("The 'print_field_descending_type' command requires no arguments. Try again.");
        }
        else {
            cm.printFieldDescendingType();
        }
    }
}
