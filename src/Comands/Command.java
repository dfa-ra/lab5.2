package Comands;

/**
 * Интерфейс команд
 * @author Захарченко Роман
 */
public interface Command {
    /**
     * Метод выполнения. Присутствует в каждом command классе.
     * @param tokens - массив элементы которого являются командами и их аргументами
     * @throws Exception
     */
    void execute(String[] tokens) throws Exception;
}
