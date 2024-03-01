package Comands.AllCommands;

import Collection.CollectionManager;
import Comands.Command;

/**
 * Класс команды вывода элементов коллекции в порядке возрастания id
 * @author Захарченко Роман
 */
public class PrintAscendingCommand implements Command {
    CollectionManager cm = new CollectionManager();
    @Override
    public void execute(String[] tokens) {
        if (tokens.length > 1){
            System.out.println("The 'print_ascending' command requires no arguments. Try again.");
        }
        else cm.printAscending();
    }
}
