public class Converter {
    static final double DISTANCE_VALUE = 0.75;
    static final double CALORIES_VALUE = 50.0;

    public double getDistance(int steps) {
        return (steps * DISTANCE_VALUE) / 1000;

    }

    public double getSumKlc(int steps) {
        return (steps * CALORIES_VALUE) / 1000;
    }

}
