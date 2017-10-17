package bestgymevermembers;

import java.util.Scanner;

public class AnvändarInmatning {

    /**
     * Frågar användaren efter ett namn, använder en loop för att säkerställa
     * att den anger ett korrekt namn
     * @return 
     */
    public static String getName() {
        Scanner memberInput = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Ange namn:");
                String namn;
                if (memberInput.hasNext()) {
                    namn = memberInput.nextLine();
                    return namn;
                }
            } catch (Exception e) {
                System.out.println("Felaktig inmatning");
            }
        }
    }

    /**
     * Frågar användaren efter ett personnummer, använder en loop för att säkerställa
     * att den anger ett korrekt personnummer
     * @return 
     */
    public static long getPersonNumber() {
        Scanner memberInputPersonNumber = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Ange personnummer:");
                long personnummer = memberInputPersonNumber.nextLong();
                return personnummer;
            } catch (NumberFormatException e) { //Eller exception
                System.out.println("Felaktig inmatning");
            }
        }
    }
}
