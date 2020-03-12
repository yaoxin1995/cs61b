import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
@Test
    public void TestOffByOne(){
        assertTrue(offByOne.equalChars('x','y'));

        assertFalse(offByOne.equalChars('a','r'));

        assertTrue(offByOne.equalChars('&','%'));

        assertFalse(offByOne.equalChars('&','$'));
    }

    // Your tests go here.
} /*Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/