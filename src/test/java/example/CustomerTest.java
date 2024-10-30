package example;

import org.junit.Test;
import java.util.List;
import static example.Movie.MovieType.*;
import static org.junit.Assert.assertEquals;
import static example.Movie.MovieType.HORROR;

public class CustomerTest {

    @Test
    public void testStatementForRegularMovie() {
        Movie movie = new Movie("Rembo", REGULAR);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("John Doe", List.of(rental));

        String expected = """
                Rental Record for John Doe
                \tRembo\t2.0
                Amount owed is 2.0
                You earned 1 frequent renter points""";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void testStatementForNewReleaseMovie() {
        Movie movie = new Movie("Lord of the Rings", NEW_RELEASE);
        Rental rental = new Rental(movie, 4);
        Customer customer = new Customer("John Doe", List.of(rental));

        String expected = """
                Rental Record for John Doe
                \tLord of the Rings\t12.0
                Amount owed is 12.0
                You earned 2 frequent renter points""";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void testStatementForChildrensMovie() {
        Movie movie = new Movie("Harry Potter", CHILDRENS);
        Rental rental = new Rental(movie, 5);
        Customer customer = new Customer("John Doe", List.of(rental));

        String expected = """
                Rental Record for John Doe
                \tHarry Potter\t4.5
                Amount owed is 4.5
                You earned 1 frequent renter points""";

        assertEquals(expected, customer.statement());
    }
    @Test
    public void testStatementForHorrorMovie() {
        Movie movie = new Movie("Alien", HORROR);
        Rental rental = new Rental(movie, 3);
        Customer customer = new Customer("John Doe", List.of(rental));

        String expected = "Rental Record for John Doe\n" +
                "\tAlien\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";

        assertEquals(expected, customer.statement());
    }
    @Test
    public void testStatementForMixedRentals() {
        Movie movie1 = new Movie("Rembo", REGULAR);
        Movie movie2 = new Movie("Lord of the Rings", NEW_RELEASE);
        Movie movie3 = new Movie("Harry Potter", CHILDRENS);

        Rental rental1 = new Rental(movie1, 1);
        Rental rental2 = new Rental(movie2, 4);
        Rental rental3 = new Rental(movie3, 5);

        Customer customer = new Customer("John Doe", List.of(rental1, rental2, rental3));

        String expected = """
                Rental Record for John Doe
                \tRembo\t2.0
                \tLord of the Rings\t12.0
                \tHarry Potter\t4.5
                Amount owed is 18.5
                You earned 4 frequent renter points""";

        assertEquals(expected, customer.statement());
    }


}
