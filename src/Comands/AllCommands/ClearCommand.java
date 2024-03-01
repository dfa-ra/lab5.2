package Comands.AllCommands;

import Collection.CollectionManager;
import Comands.Command;

/**
 * Класс команды отчистки всей коллекции
 * @author Захарченко Роман
 */
public class ClearCommand implements Command {
    CollectionManager cm = new CollectionManager();
    @Override
    public void execute(String[] tokens) {
        if (tokens.length > 1){
            System.out.println("The 'clear' command requires no arguments. Try again.");
        }
        else cm.clear();
    }
}
