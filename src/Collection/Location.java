package Collection;

/**
 * Класс локации с координатами x, y, z и названием локации
 * @author Захарчекно Роман
 */
public class Location {
    /**
     * Координата x, не может быть null.
     */
    private double x; //Поле не может быть null
    /**
     * Координата y, не может быть null.
     */
    private Long y; //Поле не может быть null
    /**
     * Координата z, не может быть null.
     */
    private float z; //Поле не может быть null

    /**
     * Название локации, может быть null.
     */
    private String name; //Поле может быть null

    /**
     * Конструктор - создание нового объекта
     * @param x координата по x
     * @param y координата по y
     * @param z координата по z
     * @param name название локации
     */
    public Location(double x, Long y, float z, String name){
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
    public Location(){

    }
    /**
     * Процедура определения координаты по y {@link Location#y}
     * @param y координата по y
     */
    public void setY(Long y) {
        this.y = y;
    }
    /**
     * Процедура определения координаты по z {@link Location#z}
     * @param z координата по z
     */
    public void setZ(float z) {
        this.z = z;
    }

    /**
     * Процедура определения координаты по x {@link Location#x}
     * @param x координата по x
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Процедура определения названия локации {@link Location#name}
     * @param name название локации
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Метод получения значения поля {@link Location#x}
     * @return возвращает координату по x
     */
    public double getX() {
        return x;
    }
    /**
     * Метод получения значения поля {@link Location#y}
     * @return возвращает координату по y
     */
    public Long getY() {
        return y;
    }
    /**
     * Метод получения значения поля {@link Location#z}
     * @return возвращает координату по z
     */
    public float getZ() {
        return z;
    }
    /**
     * Метод получения значения поля {@link Location#name}
     * @return возвращает название локации
     */
    public String getName() {
        return name;
    }

    /**
     * Переопределённый метод toString.
     * @return возвращает читаемую и информативную строку с координатами (x, y, z) и названием локации
     */
    @Override
    public String toString() {
        return "{" +
                "\n\t\t\tx=" + x +
                "\n\t\t\ty=" + y +
                "\n\t\t\tz=" + z +
                "\n\t\t\tname='" + name + '\'' +
                "\n\t\t}";
    }
}

