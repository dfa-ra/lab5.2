package Comands.AllCommands;

import Collection.CollectionManager;
import Comands.Command;

/**
 * Класс команды вывода коллекции в текстовом виде в стандартный поток вывода
 * @author Захарченко Роман
 */
public class ShowCommand implements Command {
    CollectionManager cm = new CollectionManager();
    @Override
    public void execute(String[] tokens) {
        if (tokens.length > 1){
            System.out.println("The 'show' command requires no arguments. Try again.");
        }
        else cm.show();
    }
}
