package example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import example.price.RegularPrice;
import example.price.NewReleasePrice;
import example.price.ChildrenPrice;
import example.price.HorrorPrice;


public class CustomerTest {

    @Test
    public void testStatementForRegularMovie() {
        Movie movie = new Movie("Rembo", new RegularPrice());
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
        Movie movie = new Movie("Lord of the Rings", new NewReleasePrice());
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
        Movie movie = new Movie("Harry Potter", new ChildrenPrice());
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
        Movie movie = new Movie("Alien", new HorrorPrice());
        Rental rental = new Rental(movie, 3);
        Customer customer = new Customer("John Doe", List.of(rental));

        String expected = """
                Rental Record for John Doe
                \tAlien\t3.0
                Amount owed is 3.0
                You earned 1 frequent renter points""";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void testStatementForMixedRentals() {
        Movie movie1 = new Movie("Rembo", new RegularPrice());
        Movie movie2 = new Movie("Lord of the Rings", new NewReleasePrice());
        Movie movie3 = new Movie("Harry Potter", new ChildrenPrice());

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
