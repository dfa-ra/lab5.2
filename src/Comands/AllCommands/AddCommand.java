package Comands.AllCommands;

import Collection.CollectionManager;
import Comands.Command;

/**
 * Класс команды добавления нового элемента в коллекцию
 * @author Захарченко Роман
 */
public class AddCommand implements Command {
    CollectionManager cm = new CollectionManager();
    @Override
    public void execute(String[] tokens) {
        if (tokens.length > 1){
            System.out.println("Enter 'add' and then an input form will appear.");
        }
        else cm.add();
    }
}
