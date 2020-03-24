public class RabinKarpAlgorithm {


    /**
     * This algorithm returns the starting index of the matching substring.
     * This method will return -1 if no matching substring is found, or if the input is invalid.
     */
    public static int rabinKarp(String input, String pattern) {
        String firstSubString=getSubString(input,pattern.length());
        RollingString test=new RollingString(firstSubString,pattern.length());
        RollingString standard=new RollingString(pattern,pattern.length());
        int hPattern=standard.hashCode();
        if(hPattern==test.hashCode()){
            if(test.equals(standard))
                return 0;
        }
        for(int i=1;i<=input.length()-pattern.length();i++){
           test.addChar(input.charAt(pattern.length()-1+i));
           if(test.hashCode()==hPattern){
               if(test.equals(standard))
                   return i;
           }
        }
        return -1;
    }

    private static String getSubString(String string,int length){
        String temp="";
        for(int i=0;i<length;i++)
            temp+=string.charAt(i);
        return temp;
    }
}
