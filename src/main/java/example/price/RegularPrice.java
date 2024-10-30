package example.price;

public class RegularPrice extends Price{
    @Override
    public double getCharge(int DaysRented) {
       if (DaysRented > 2) {
           return 2 + (DaysRented - 2) * 1.5;
       }
       return 2;
    }
}
