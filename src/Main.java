import Collection.CollectionManager;
import Collection.XmlManager;
import Comands.Invoker;

/**
 * Стартовый класс имеющий статический метод main
 * @author Захарченко Роман
 */
public class Main {
    public static void main(String[] args) throws Exception{
        CollectionManager.setNotebook(XmlManager.myParser());
        Invoker invk = new Invoker();
        invk.commandSelection();
    }
}

