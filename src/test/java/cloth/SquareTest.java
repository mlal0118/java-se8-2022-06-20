package cloth;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

    static class Dummy implements Square {
        @Override
        public double getSide() {
            return 5;
        }
    }

    @Test
    void testGetArea() {
        assertEquals(25, new Dummy().getArea());
    }
}
