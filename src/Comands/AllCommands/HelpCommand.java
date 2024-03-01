package Comands.AllCommands;

import Comands.Command;

/**
 * Класс команды help(помощи)
 * @author Захарченко Роман
 */
public class HelpCommand implements Command {
    @Override
    public void execute(String[] tokens) {
        if (tokens.length > 1){
        System.out.println("The 'help' command requires no arguments. Try again.");
    }
    else {
        System.out.println("help : display help on available commands");
        System.out.println("info : print information about the collection (type, initialization date, number of elements, etc.) to standard output");
        System.out.println("show : Print to standard output all the elements of the collection in string representation");
        System.out.println("add {element} : add a new element to the collection");
        System.out.println("update id {element} : update the value of a collection element whose id is equal to the given one");
        System.out.println("remove_by_id id : remove an element from a collection by its id");
        System.out.println("clear : clear the collection");
        System.out.println("save : save the collection to a file");
        System.out.println("execute_script file_name : Read and execute a script from the specified file. The script contains commands in the same form in which the user enters them interactively.");
        System.out.println("exit : exit the program (without saving to a file)");
        System.out.println("remove_greater {element} : remove from the collection all elements greater than the given one");
        System.out.println("remove_lower {element} : remove all elements from the collection that are smaller than the given one");
        System.out.println("history : print the last 8 commands (without their arguments)");
        System.out.println("group_counting_by_type : group the collection elements by the value of the type field, display the number of elements in each group");
        System.out.println("print_ascending : Print the collection elements in ascending order");
        System.out.println("print_field_descending_type : print the type field values of all elements in descending order");
        System.out.println("print_field__type : print sorted id of all collection elements with the same ticket types");
    }
    }
}
