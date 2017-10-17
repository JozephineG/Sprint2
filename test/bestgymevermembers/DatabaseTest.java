package bestgymevermembers;

//Importerar relevanta bibliotek för att kunna genomföra TDD
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.Test;

// Skapar en testclass
public class DatabaseTest {

    /*
    **Ett test objekt från Database-klassen för att kunna kalla på 
    **det som ska testas
     */
    Database database = new Database();

    @Test
    /**
     * Vi testar laddandet av databasen genom att först se så att det gick bra
     * och sedan testa så att den interna databasen är av rätt storlek
     */
    public final void loadDatabase() {
        TestCase.assertTrue(database.loadDatabase());
        TestCase.assertEquals(14, database.customerInfo.size());
    }

    @Test
    /**
     * Testar findByNameAndPersonNummer genom att först skapa en användare och
     * sedan fråga efter denna. Om den finns så är allt bra
     */
    public final void findByNameAndPersonNummer() {
        try {
            Person p = new Person();
            p.namn = "Olle";
            p.personnummer = 1234567;
            p.memberDate = LocalDate.now();
            database.customerInfo.add(p);

            Person p2 = database.findByNameAndPersonNummer("Olle", 1234567);
            TestCase.assertEquals(p2.namn, p.namn);
            TestCase.assertEquals(p2.personnummer, p.personnummer);
            TestCase.assertEquals(p2.memberDate, p.memberDate);
        } catch (PersonNotFoundException e) {
            System.out.println("Person not found");
        }
    }

    @Test(expected = PersonNotFoundException.class)
    /**
     * Testar att vi får ett exception när vi inte kan hitta den efterfrågade
     * användaren i den interna databasen
     */
    public final void findByNameAndPersonNummerException() throws PersonNotFoundException {
        database.findByNameAndPersonNummer("bla bla bla", 0);
    }

}
