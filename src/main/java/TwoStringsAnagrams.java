import java.util.Arrays;

public class TwoStringsAnagrams {

    public static void main(String[] args) {
        System.out.println("areAnagrams  = " + areAnagrams("silent" , "listen"));

    }

    public static boolean areAnagrams(String str1, String str2) {
        // If the two strings have different lengths, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert both strings to lowercase and convert them to character arrays
        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();
        // Sort both character arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        /*
        // If the sorted character arrays are equal, the two strings are anagrams
        return Arrays.equals(arr1, arr2);
         */

        for(int i =0 ; i< arr1.length ; i++){
            if(arr1[i] != arr2[i]) return false;
        }

        return true;

    }
}
