package Comands.AllCommands;

import Collection.CollectionManager;
import Comands.Command;

/**
 * Класс команды вывода id всех типов билетов по группам
 * @author Захарченко Роман
 */
public class PrintFieldTypeCommand implements Command {

    CollectionManager cm = new CollectionManager();
    @Override
    public void execute(String[] tokens) {
        if (tokens.length > 1){
            System.out.println("The 'print_field_descending_type' command requires no arguments. Try again.");
        }
        else {
            cm.printFieldType();
        }
    }
}
