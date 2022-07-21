import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class substring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC" , "ABC"));
    }


    public static String minWindow(String s, String t) {

        if(s.equals(t)) return t;

        if(t.contains(s)) return "";


        for(int i=0 ; i< s.length() ; i++){
            for(int j= i+1 ; j <= s.length() ; j++){

            }
        }

       return  "";
    }

    private int[] getArray(String s){

        int[] t = new int[26];
        /*t[0] = s.indexOf('A') || ;
        t[1] = s.indexOf('B');
        t[2] = s.indexOf('B');*/
        return t;
    }
}