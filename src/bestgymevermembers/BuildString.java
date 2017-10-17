package bestgymevermembers;

import java.time.LocalDate;

public class BuildString {

    /**
     * Bygger ihop den strängen vi vill spara till filen som vår PT efterfrågat
     * @param name
     * @param personnummer
     * @return 
     */
    public static String buildString(String name, long personnummer) {
        StringBuilder sb = new StringBuilder();
        sb.append(name)
                .append(", ")
                .append(personnummer)
                .append(", ")
                .append(LocalDate.now())
                .append("\n");
        return sb.toString();
    }
}
