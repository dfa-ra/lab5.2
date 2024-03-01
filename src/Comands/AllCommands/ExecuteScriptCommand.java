package Comands.AllCommands;

import Comands.Command;
import Comands.Invoker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Класс команды исполнения скрипта
 * @author Захарченко Роман
 */
public class ExecuteScriptCommand implements Command {
    BufferedReader reader;

    @Override
    public void execute(String[] tokens) {
        if (tokens.length > 2){
            System.out.println("The 'execute_script' command does not require 2 or more arguments. Try again.");
        }else if(tokens.length == 1) System.out.println("This command requires an argument. Try again!");
        else {
            Invoker invk = new Invoker();
            try {
                reader = new BufferedReader(new FileReader(tokens[1]));
                String line = reader.readLine();

                while (line != null) {
                    System.out.println(line);
                    invk.commandSelectionByStr(line);
                    line = reader.readLine();
                }

                reader.close();
            } catch (IOException e) {
                System.out.println("This file does not exist, try again!");
            } catch (Exception e) {
                System.out.println("Error!! Try again!");
            }

        }
    }
}
