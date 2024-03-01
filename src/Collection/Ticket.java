package Collection;

import enum_.TicketType;

import java.time.ZonedDateTime;

/**
 * Класс билетов и описания билетов (какой, чей и т.д)
 * @author Захарченко Роман
 */
public class Ticket implements Comparable<Ticket> {
    /**
     * Id каждого билета. Не может быть null, значение должно быть больше 0, должно быть уникальным, должно генерироваться автоматически
     */
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /**
     * Имя человека которому принадлежит билет. Не может быть null, не может быть пустой
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * Координаты, не может быть null
     */
    private Coordinates coordinates; //Поле не может быть null
    /**
     * Дата создания билета. Не может быть null, генерируется автоматически
     */
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /**
     * Цена билета. Не может быть null, должно быть больше 0
     */
    private Double price; //Поле не может быть null, Значение поля должно быть больше 0
    /**
     * Комментарий к биллету.
     */
    private String comment; //Строка не может быть пустой, Поле может бь null
    /**
     * Возвратность билет.
     */
    private Boolean refundable; //Поле может быть null
    /**
     * Тип билета.
     */
    private TicketType type; //Поле не может быть null
    /**
     * Некоторая информация о человеке.
     */
    private Person person = null; //Поле может быть null

    /**
     * Конструктор - создание нового объекта
     * @param id id билета
     * @param name имя человека которому принадлежит билет
     * @param coordinates координаты
     * @param creationDate дата создания
     * @param price цена билета
     * @param comment комментарий к билету
     * @param refundable возвратность билета
     * @param type тип билета
     */
    public Ticket(Long id, String name, Coordinates coordinates, ZonedDateTime creationDate, Double price, String comment, Boolean refundable, TicketType type){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.comment = comment;
        this.refundable = refundable;
        this.type = type;
    }

    public Ticket() {

    }
    /**
     * Процедура определения id билета {@link Ticket#id}
     * @param id id билета
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Процедура определения имени человека купившего билет {@link Ticket#name}
     * @param name имя человека
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Процедура определения координат {@link Ticket#coordinates}
     * @param coordinates координаты
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Процедура определения дата покупки билета  {@link Ticket#creationDate}
     * @param creationDate дата покупки билета
     */
    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Процедура определения цена билета {@link Ticket#price}
     * @param price цела билета
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Процедура определения комментария к билету {@link Ticket#comment}
     * @param comment комментарий к билету
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Процедура определения возвратности билета {@link Ticket#refundable}
     * @param refundable возвратность билета
     */
    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }

    /**
     * Процедура определения типа билета {@link Ticket#type}
     * @param type тип билета
     */
    public void setType(TicketType type) {
        this.type = type;
    }

    /**
     * Процедура определения некоторой информации о человеке купившем билет {@link Ticket#person}
     * @param person название билета
     */
    public void setPerson(Person person) {
        this.person = person;
    }
    /**
     * Метод получения значения поля {@link Ticket#creationDate}
     * @return возвращает дату создания билета
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }
    /**
     * Метод получения значения поля {@link Ticket#id}
     * @return возвращает id билета
     */
    public Long getId() {
        return id;
    }
    /**
     * Метод получения значения поля {@link Ticket#type}
     * @return возвращает тип билета
     */
    public TicketType getType() {
        return type;
    }
    /**
     * Метод получения значения поля {@link Ticket#name}
     * @return возвращает имя человека которому принадлежит билет
     */
    public String getName() {
        return name;
    }
    /**
     * Метод получения значения поля {@link Ticket#coordinates}
     * @return возвращает координаты
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }
    /**
     * Метод получения значения поля {@link Ticket#price}
     * @return возвращает цену билета
     */
    public Double getPrice() {
        return price;
    }
    /**
     * Метод получения значения поля {@link Ticket#comment}
     * @return возвращает комментарий по билету
     */
    public String getComment() {
        return comment;
    }
    /**
     * Метод получения значения поля {@link Ticket#refundable}
     * @return возвращает возвратность билета
     */
    public Boolean getRefundable() {
        return refundable;
    }
    /**
     * Метод получения значения поля {@link Ticket#person}
     * @return возвращает некоторую информацию о человеке купившем билет
     */
    public Person getPerson() {
        return person;
    }
    /**
     * Переопределённый метод toString.
     * @return возвращает читаемую и информативную строку информацией о билете
     */
    @Override
    public String toString() {
        if (person == null){
            return "{" +
                    "\n\tid=" + id +
                    "\n\tname='" + name + '\'' +
                    "\n\tcoordinates=" + coordinates.toString() +
                    "\n\tcreationDate=" + creationDate +
                    "\n\tprice=" + price +
                    "\n\tcomment='" + comment + '\'' +
                    "\n\trefundable=" + refundable +
                    "\n\ttype=" + type +
                    "\n\tperson=null" +
                    "\n}";
        }else{
            return "{" +
                    "\n\tid=" + id +
                    "\n\tname='" + name + '\'' +
                    "\n\tcoordinates=" + coordinates.toString() +
                    "\n\tcreationDate=" + creationDate +
                    "\n\tprice=" + price +
                    "\n\tcomment='" + comment + '\'' +
                    "\n\trefundable=" + refundable +
                    "\n\ttype=" + type +
                    "\n\tperson=" + person.toString() +
                    "\n}";
        }

    }

    /**
     * Переопределённый компаратор. Создан для сортировки элементов коллекции по id.
     */
    @Override
    public int compareTo(Ticket o) {
        return (int) (this.getId() - o.getId());
    }
}
