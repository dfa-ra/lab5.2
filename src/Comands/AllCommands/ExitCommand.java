package Comands.AllCommands;

import Comands.Command;

/**
 * Класс команды выхода
 * @author Захарченко Роман
 */
public class ExitCommand implements Command {
    @Override
    public void execute(String[] tokens) {
        if (tokens.length > 1){
            System.out.println("The 'info' command requires no arguments. Try again.");
        }
        else System.exit(0);
    }
}
