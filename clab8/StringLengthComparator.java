// StringLengthComparator.java
import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String x, String y) {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
       return y.length()-x.length();
    }
}