package bestgymevermembers;
// Importerar relevanta bibliotek

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {

    //Skapar en lista för att kunna lagra informationen som kommer från filen
    List<Person> customerInfo = new ArrayList<>();

    public boolean loadDatabase() {
        //Skapar en try och catch för att kunna hantera eventuella fel
        try {
            String customerLine;
            // Skapar en ny läsare som ska läsa filen
            BufferedReader reader = new BufferedReader(new FileReader("customers.txt"));
            int line = 0;
            /*
            **Skapar ett objekt av klassen Person för att lagra varje specifik 
            **medlem enligt Person.class variablerna i objektet person
             */
            Person person = new Person();
            /*
            **Har en while loop för att kunna läsa igenom varje rad i filen 
            **på samma sätt. Den lästade if-satsen innehåller informationen från 
            **Person-klassen för att kunna läsa in informationen på önskat sätt
             */
            while ((customerLine = reader.readLine()) != null && !customerLine.equals("")) {
                /*
                * Splittar rader i filen för att kunna separera informationen
                * och spara den enligt Person-klass strukturen. If-satsen 
                * splittar raderna och sparar dem i två separata variabler så 
                * att listan får den önskade strukturen för avläsning
                * använder modulus eftersom att varje kund har information på
                * två rader
                 */
                if (line % 2 == 0) {
                    String[] split = customerLine.split(",");
                    person = new Person();
                    person.personnummer = Long.parseLong(split[0]);
                    person.namn = split[1].trim();
                } else {
                    person.memberDate = LocalDate.parse(customerLine);
                    customerInfo.add(person);
                }
                /*
                **Ökar på listan för varje rad. Låter loopen snurra runt för att 
                **kunna insamla varje rad
                 */
                line++;
            }
            return true;
            /*
            **Ser till att systemet tar hand om exception som dyker upp så att 
            **systemet inte stänger av sig
             */
        } catch (IOException e) {
            System.out.println("Could not read file");
            return false;
        }

    }

    /*
     * findByNameAndPersonNummer hittar en person i vår interna databas utifrån
     * namn och personnummer, om ingen hittas kastar vi ett exception för att
     * markera detta
    */
    public Person findByNameAndPersonNummer(String name, long personnummer) throws PersonNotFoundException {
        for (Person p : customerInfo) {
            if (name.equalsIgnoreCase(p.namn) && p.personnummer == personnummer) {
                return p;
            }
        }
        throw new PersonNotFoundException("Medlemmen finns ej registrerat");
    }
}
