package Comands.AllCommands;

import Collection.CollectionManager;
import Comands.Command;

/**
 * Класс команды сгруппировки элементов коллекции по значению поля type и вывода количества элементов в каждой группе
 * @author Захарченко Роман
 */
public class GroupCountingByTypeCommand implements Command {

    CollectionManager cm = new CollectionManager();

    @Override
    public void execute(String[] tokens) {
        if (tokens.length > 1){
            System.out.println("The 'group_counting_by_type' command requires no arguments. Try again.");
        }
        else {
            cm.groupCountingByType();
            System.out.println("Complete!");
        }
    }
}
