package mad3125.tilak_c0868747.mt;

import java.util.ArrayList;

public class Rent {
    private Car car;
    private int noOfDays;
    private DriverAge age;
    private ArrayList<String> options;

    public Car getCar() {
        return car;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public DriverAge getAge() {
        return age;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public Rent(Car car, int noOfDays, DriverAge age, ArrayList<String> options) {
        this.car = car;
        this.noOfDays = noOfDays;
        this.age = age;
        this.options = options;
    }
}
