package Comands;

import Comands.AllCommands.*;
import enum_.Color;
import enum_.TicketType;
import Collection.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Класс реализующий взаимодействие с пользователем.
 * @author Захарченко Роман
 */
public class Invoker {
    /**
     * Список всех введённых команд
     */
    protected List<String> history = new ArrayList<>();
    /**
     * Коллекция типа ключ значение ключ='названию команды' значение='класс исполнитель команды'
     */
    protected Map<String, Command> commands = new HashMap<>();

    /**
     * Конструктор в котором определяются все команды
     */
    public Invoker(){
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand());
        commands.put("exit", new ExitCommand());
        commands.put("show", new ShowCommand());
        commands.put("add", new AddCommand());
        commands.put("clear", new ClearCommand());
        commands.put("save", new SaveCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("update", new UpdateCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("history", new HistoryCommand());
        commands.put("group_counting_by_type", new GroupCountingByTypeCommand());
        commands.put("remove_greater", new RemoveGreaterCommand());
        commands.put("remove_lower", new RemoveLowerCommand());
        commands.put("print_ascending", new PrintAscendingCommand());
        commands.put("print_field_descending_type", new PrintFieldDescendingTypeCommand());
        commands.put("print_field_type", new PrintFieldTypeCommand());
    }
    protected String[] tokens;

    /**
     * Метод реализующий ввод команды
     * @throws Exception
     */
    public void commandSelection() throws Exception {
        String str = "";
        Scanner in = new Scanner(System.in);
        while (true) {
            try{
                str = in.nextLine();
                commandSelectionByStr(str);
            } catch (NoSuchElementException e) {
                System.out.println("CTRL+D entered - program terminated");
                commandSelectionByStr("exit");
            }

        }
    }

    /**
     * Метод разделяющий введённую команду на слова, проверяющий существование команды и выполняющий её если она есть. Так же этот метод заносит данный элемент в историю команд.
     * @param str введённая строка
     * @throws Exception
     */
    public void commandSelectionByStr(String str) throws Exception {
        String[] tokens = str.split(" ");
        if (commands.containsKey(tokens[0])){
            Command command = commands.get(tokens[0]);
            command.execute(tokens);
            history.add(str);
        }
        else {
            System.out.println("This command does not exist. Using the 'help' command you can see all available commands.");
        }
    }

    /**
     * Метод реализующий команду истории. Выводящий последние 8 введённых команд.
     */
    public class HistoryCommand implements Command{
        @Override
        public void execute(String[] tokens) {
            int i = history.size() - 1;
            int j = 0;
            while (i-j >= 0) {
                System.out.println(i-j+") " + history.get(i-j));
                j++;
                if (j == 8) break;
            }
        }
    }
    /**
     * Метод для работы с ведёнными строками.
     * @param about (String) что вводить?
     * @param canBeNull (boolean) может быть null или нет?
     * @return Метод возвращает введённую строку либо null если не ввели ничего
     */
    static public String addStr(String about, boolean canBeNull){
        Scanner in = new Scanner(System.in);
        String str = "";
        System.out.print("Input " + about + ": ");
        str=in.nextLine();
        if (!canBeNull){
            while (str == "") {
                System.out.print("Input " + about + ": ");
                str=in.nextLine();
            }
        }
        else if (str == "") str = null;
        return str;
    }

    /**
     * Метод для введения координат.
     * @return Метод возвращает введённые координаты x и y.
     */
    static public Coordinates addCoordinates(){
        Scanner in = new Scanner(System.in);
        int y;
        float x = 0;
        //Coordinates
        for(;;) {
            try {
                System.out.print("Input coordinates x (>-785): ");
                x = in.nextFloat();
                while (x <= -785) {
                    System.out.print("(>-785)!!! Input coordinates x : ");
                    x = in.nextFloat();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid data type. Try again.");
                in.next();
            }
        }
        for(;;){
            try{
                System.out.print("Input coordinates y: ");
                y = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid data type. Try again.");
                in.next();
            }
        }
        return new Coordinates(x, y);
    }

    /**
     * Метод для введения цены.
     * @return Метод возвращает введённую цену.
     */
    static public Double addPrice(){
        Scanner in = new Scanner(System.in);
        Double price;
        for(;;){
            try{
                System.out.print("Input price x (>0): ");
                price = in.nextDouble();
                while (price < 0){
                    System.out.print("Input price x (>0): ");
                    price = in.nextDouble();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid data type. Try again.");
                in.next();
            }
        }
        return price;
    }

    /**
     * Метод для введения возвратности билета.
     * @return Возвращает ответ (да или нет) на вопрос. Является ли билет возвратным?
     */
    static public Boolean addRefundable(){
        Scanner in = new Scanner(System.in);
        Boolean refundable;
        //refundable
        for(;;){
            try{
                System.out.print("Input refundable(can be null): ");
                refundable = in.nextBoolean();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error! Available answers are true or false!");
                in.next();
            }
        }
        return refundable;
    }

    /**
     * Метод для ввода типа билета.
     * @return Возвращает тип билета.
     */
    static public TicketType addTicketType(){
        System.out.println("1)" + TicketType.VIP);
        System.out.println("2)" + TicketType.CHEAP);
        System.out.println("3)" + TicketType.USUAL);
        System.out.println("4)" + TicketType.BUDGETARY);
        Scanner in = new Scanner(System.in);
        TicketType ticketType;
        for(;;){
            try{
                System.out.print("Enter one of these ticket types: ");
                String tmp = in.next();
                if (tmp == "") ticketType = null;
                else ticketType = TicketType.valueOf(tmp);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error! Select an option from the list above!");
            }
        }
        return ticketType;
    }

    /**
     * Метод для ввода даты рождения.
     * @return Возвращает введённую дату рождения
     */
    static public Date addBirthDay(){
        Scanner in = new Scanner(System.in);
        String answBirthday = null;
        Date birthday = null;
        SimpleDateFormat birthdayFormat = new SimpleDateFormat("dd.MM.yyyy");
        while (true) {
            try {
                System.out.print("Input your birthday (dd.mm.yyyy): ");
                answBirthday = in.next();
                birthday = birthdayFormat.parse(answBirthday.trim());
                break;
            } catch (ParseException ignored) {
                System.out.println("try again");
            }
        }
        return birthday;
    }

    /**
     * Метод для ввода цвета волос.
     * @return Возвращает введённый цвет волос.
     */
    static public Color addHaitColor(){
        System.out.println("1)" + Color.BLACK);
        System.out.println("2)" + Color.GREEN);
        System.out.println("3)" + Color.BLUE);
        Scanner in = new Scanner(System.in);
        Color hairColor;
        for(;;){
            try{
                System.out.print("Enter one of these hair color: ");
                hairColor = Color.valueOf(in.next());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error! Select an option from the list above!");
            }
        }
        return hairColor;
    }

    /**
     * Метод для ввода локации.
     * @return Возвращает введённую локацию с координатами и названием.
     */
    static public Location addLocation(){
        double X;
        Long Y;
        float Z;
        Scanner in = new Scanner(System.in);
        for(;;){
            try{
                System.out.print("Input location x (not null): ");
                X = in.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid data type. Try again.");
                in.next();
            }
        }
        for(;;){
            try{
                System.out.print("Input location y: ");
                Y = in.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid data type. Try again.");
                in.next();
            }
        }
        for(;;){
            try{
                System.out.print("Input location z: ");
                Z = in.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid data type. Try again.");
                in.next();
            }
        }
        return new Location(X, Y, Z, addStr("location name", true));
    }
}
