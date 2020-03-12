import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    /**
     *assertFalse:Asserts that a condition is false. If it isn't it throws an AssertionError without a message.
     * assertTrue:Asserts that a condition is True. If it isn't it throws an AssertionError without a message.
     * */
    public void testIsPalindrome(){
        assertTrue(palindrome.isPalindrome(" "));

        assertTrue(palindrome.isPalindrome("a"));

        assertFalse(palindrome.isPalindrome("catacx"));

        assertTrue(palindrome.isPalindrome("12CaBaC21"));

        assertTrue(palindrome.isPalindrome("12344321"));
    }

    @Test
    public  void testIsPalindromeMit2Parameter(){
        CharacterComparator a=new OffByOne();
        assertTrue(palindrome.isPalindrome(" ",a));

        assertTrue(palindrome.isPalindrome("a",a));

        assertFalse(palindrome.isPalindrome("catac",a));

        palindrome.isPalindrome("acedb",a);

        assertTrue(palindrome.isPalindrome("acedb",a));

        assertTrue(palindrome.isPalindrome("eghf",a));


    }
}    /* Uncomment this class once you've created your Palindrome class. */