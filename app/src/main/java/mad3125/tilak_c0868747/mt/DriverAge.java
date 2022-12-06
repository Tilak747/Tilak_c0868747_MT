package mad3125.tilak_c0868747.mt;

public enum DriverAge {
    LESS_THAN_20("Less than 20"),
    BETWEEN_20_AND_60("Between 20 and 60"),
    ABOVE_60("Above 60");

    private final String name;

    DriverAge(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
