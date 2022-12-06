package mad3125.tilak_c0868747.mt;

import java.io.Serializable;
import java.util.ArrayList;

public class Car implements Serializable {
    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Car(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    static ArrayList<Car> cars = new ArrayList<>();

    @Override
    public String toString() {
        return getName();
    }
}
