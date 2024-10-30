package example.price;

import example.Movie;

import java.util.HashMap;

public abstract class Price {
    private static Map<MovieType, Fucntion<Integer, Double>> map = new HashMap<>();
    static {
        map.put(REGULAR, a -> (a <= 2) ? 1.0 : (a - 2) * 1.5);
        map.put(NEW_RELEASE, a -> (a <= 2) ? 2.0 : (a - 2) * 3);
        map.put(REGULAR, a -> (a <= 3) ? 1.0 : (a - 3) * 1.0);
    }
    public abstract double getCharge(int DaysRented);
    public int getFrequentRenterPoints(int DaysRented) {
       return 1;
    }


}