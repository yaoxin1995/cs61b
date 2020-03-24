import org.junit.Test;
import static org.junit.Assert.*;

public class RabinKarpAlgorithmTests {
    @Test
    public void basic() {
        String input = "helloyyyw";
        String pattern = "hel";
        RabinKarpAlgorithm.rabinKarp(input, pattern);
        assertEquals(0, RabinKarpAlgorithm.rabinKarp(input, pattern));
    }
}
