package bestgymevermembers;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class BestGymEverMembers {

    public static void main(String[] args) {

        // Skapar ett databas objekt
        Database database = new Database();
        // Laddar databasen från filen
        database.loadDatabase();
        
        // Skapar en while-loop för att vi inte vet hur länge dom vill 
        // fråga efter användare
        while (true) {
            // Frågar efter användar-input
            String name = AnvändarInmatning.getName();
            long personnummer = AnvändarInmatning.getPersonNumber();

            try {
                // Försöker lokalisera användaren i databasen
                Person person = database.findByNameAndPersonNummer(name, personnummer);
                
                // Om användaren är aktiv dvs har betalat medlemsavgift
                if (person.memberDate.isAfter(LocalDate.now().minusYears(1))) {
                    System.out.println("Är nuvarande medlem");
                    FileWriter fw = new FileWriter("visits.txt", true);
                    fw.append(BuildString.buildString(name, personnummer));
                    fw.flush();
                // Användaren finns sedan tidigare men är inte aktiv
                } else {
                    System.out.println("Har varit medlem men årsavgiften har inte betalats");
                }
            // Användaren har aldrig varit medlem
            } catch (PersonNotFoundException ex) {
                System.out.println("Har aldrig varit medlem");
            } catch (IOException ex) {
                System.out.println("Problem att skriva till fil: " + ex.getMessage());
            }
        }
    }
}
