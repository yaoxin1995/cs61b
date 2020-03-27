import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * A String-like class that allows users to add and remove characters in the String
 * in constant time and have a constant-time hash function. Used for the Rabin-Karp
 * string-matching algorithm.
 */
class
RollingString{

    /**
     * Number of total possible int values a character can take on.
     * DO NOT CHANGE THIS.
     */
    static final int UNIQUECHARS = 128;

    /**
     * The prime base that we are using as our mod space. Happens to be 61B. :)
     * DO NOT CHANGE THIS.
     */
    static final int PRIMEBASE = 6113;

    private StringBuilder rollingString;

    private String currentString;

    private int length;


    private  long cachedHashValue;

    private int preFirstChar;

    /**
     * Initializes a RollingString with a current value of String s.
     * s must be the same length as the maximum length.
     */
    public RollingString(String s, int length) {
        assert(s.length() == length);
        /* FIX ME */
        this.length=length;
        rollingString=new StringBuilder(s);
        currentString=s;


        for(int i=0;i<length;i++){
            cachedHashValue+=(int)(rollingString.charAt(i)*Math.pow(UNIQUECHARS,length-1-i));
        }

    }

    /**
     * Adds a character to the back of the stored "string" and 
     * removes the first character of the "string". 
     * Should be a constant-time operation.
     */
    public void addChar(char c) {
        /* FIX ME */
        rollingString.insert(length,c);
        preFirstChar=rollingString.charAt(0);
        rollingString.deleteCharAt(0);
        cachedHashValue-=preFirstChar*Math.pow(UNIQUECHARS,length-1);
        cachedHashValue=cachedHashValue*UNIQUECHARS;
        cachedHashValue+=c;
    }



    /**
     * Returns the "string" stored in this RollingString, i.e. materializes
     * the String. Should take linear time in the number of characters in
     * the string.
     */
    public String toString() {
        //StringBuilder strb = new StringBuilder();

        return rollingString.toString();
    }

    /**
     * Returns the fixed length of the stored "string".
     * Should be a constant-time operation.
     */
    public int length() {
        /* FIX ME */
        return rollingString.length();
    }


    /**
     * Checks if two RollingStrings are equal.
     * Two RollingStrings are equal if they have the same characters in the same
     * order, i.e. their materialized strings are the same.
     */
    @Override
    public boolean equals(Object o) {
        /* FIX ME */
        if(o==null)
            return false;
        if(this.getClass()!=o.getClass())
            return false;
        if(this==o)
            return true;
        RollingString test=(RollingString)o;
        if(this.length()!=test.length())
            return false;
        for(int i=0;i<this.length;i++){
            if(this.rollingString.charAt(i)!=test.rollingString.charAt(i))
                return false;
        }
        return true;
    }

    /**
     * Returns the hashcode of the stored "string".
     * Should take constant time.
     */

    /* **

    @Override

    public int hashCode() {



        int h=cachedHashValue;
        if(h==0&&rollingString.length()>0){
            for(int i=0;i<length();i++){
                h=(int)(rollingString.charAt(i)*Math.pow(UNIQUECHARS,length-1-i));
            }
            h=h%PRIMEBASE;
        }
        else if(h!=0){
            int temp=h;
            h=temp-getfirstHach()+rollingString.charAt(length-1)%PRIMEBASE;
        }
        cachedHashValue=h;
        return h;
    }

    private int getfirstHach(){
        int b=Math.floorMod((int)(preFirstChar*Math.pow(UNIQUECHARS,length()-1)), PRIMEBASE);
        int a=(int)((preFirstChar*Math.pow(UNIQUECHARS,length()-1))%PRIMEBASE);
        return b;
    }
    **/

    @Override

    public int hashCode() {
        return  (int)(cachedHashValue%PRIMEBASE);
    }
}
