
package bestgymevermembers;

import java.time.LocalDate;
import junit.framework.TestCase;
import org.junit.Test;

public class BuildStringTest {

    /**
     * Testar att buildString returnerar enligt tänkt format
     */
    @Test
    public final void buildString() {
        String name = "abc";
        long personnummer = 0;
        TestCase.assertEquals(name + ", " + personnummer + ", " 
                + LocalDate.now() + "\n",BuildString.buildString(name, 0));
    }
    
}