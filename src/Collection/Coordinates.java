package Collection;

/**
 * Класс координат (x, y)
 * @author Захарченко Роман
 */
public class Coordinates {
    /**
     * Координата x, значение должно быть больше -785.
     */
    private float x; //Значение поля должно быть больше -785
    /**
     * Координата y, не может быть null.
     */
    private double y; //Поле не может быть null

    /**
     * Конструктор - создание нового объекта
     * @param x координата по x
     * @param y координата по y
     */
    public Coordinates(float x, double y){
        this.x = x;
        this.y = y;
    }
    public Coordinates(){

    }
    /**
     * Процедура определения координаты по y {@link Coordinates#y}
     * @param y координата по y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Процедура определения координаты по x {@link Coordinates#x}
     * @param x координата по x
     */
    public void setX(float x) {
        this.x = x;
    }
    /**
     * Метод получения значения поля {@link Coordinates#x}
     * @return возвращает координату по x
     */
    public float getX() {
        return x;
    }
    /**
     * Метод получения значения поля {@link Coordinates#y}
     * @return возвращает координату по y
     */
    public double getY() {
        return y;
    }

    /**
     * Переопределённый метод toString.
     * @return возвращает читаемую и информативную строку с координатами (x, y)
     */
    @Override
    public String toString() {
        return "{" +
                "\n\t\tx=" + x +
                "\n\t\ty=" + y +
                "\n\t}";
    }
}
