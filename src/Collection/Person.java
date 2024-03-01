package Collection;

import enum_.Color;

import java.util.Date;

/**
 * Класс персонажа с днём рождения, цветом волос и локацией персонажа.
 * @author Захарченко Роман
 */
public class Person {
    /**
     * День рождения персонажа, не может быть null
     */
    private Date birthday; //Поле не может быть null
    /**
     * Цвет волос персонажа, может быть null
     */
    private Color hairColor; //Поле может быть null
    /**
     * Локация персонажа, не может быть null
     */
    private Location location; //Поле не может быть null

    /**
     * Конструктор - создание нового объекта
     * @param birthday день рождения персонажа
     * @param hairColor цвет волос персонажа
     * @param location локация персонажа
     */
    public Person(Date birthday, Color hairColor, Location location){
        this.birthday = birthday;
        this.hairColor = hairColor;
        this.location = location;
    }
    public Person() {

    }
    /**
     * Процедура определения дня рождения {@link Person#birthday}
     * @param birthday день рождения человека
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    /**
     * Процедура определения цвета волос человека {@link Person#hairColor}
     * @param hairColor цвет волос человека
     */
    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Процедура определения локации {@link Person#location}
     * @param location локация персонажа
     */
    public void setLocation(Location location) {
        this.location = location;
    }
    /**
     * Метод получения значения поля {@link Person#birthday}
     * @return возвращает день рождения персонажа
     */
    public Date getBirthday() {
        return birthday;
    }
    /**
     * Метод получения значения поля {@link Person#hairColor}
     * @return возвращает цве волос персонажа
     */
    public Color getHairColor() {
        return hairColor;
    }
    /**
     * Метод получения значения поля {@link Person#location}
     * @return возвращает локацию персонажа
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Переопределённый метод toString.
     * @return возвращает читаемую и информативную строку с локацией, цветом волос и днём рождения персонажа.
     */
    @Override
    public String toString() {
        return "{" +
                "\n\t\tbirthday=" + birthday +
                "\n\t\thairColor=" + hairColor +
                "\n\t\tlocation=" + location.toString() +
                "\n\t}";
    }
}
