package mad3125.tilak_c0868747.mt;

import java.io.Serializable;
import java.util.ArrayList;

public class Rent implements Serializable {
    private Car car;
    private int noOfDays;
    private DriverAge age;
    private ArrayList<String> options;
    private double totalAmount;
    private double tax;
    private double totalPrice;

    public Car getCar() {
        return car;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public DriverAge getAge() {
        return age;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTax() {
        return tax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public Rent(Car car, int noOfDays, DriverAge age, ArrayList<String> options, double totalAmount, double tax, double totalPrice) {
        this.car = car;
        this.noOfDays = noOfDays;
        this.age = age;
        this.options = options;
        this.totalAmount = totalAmount;
        this.tax = tax;
        this.totalPrice = totalPrice;
    }
}
