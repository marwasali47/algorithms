public class palindromeString {

    public static void main(String[] args) {

        System.out.println("is Palindrome ? " + isPalindrome("racecar"));
    }

    public static boolean isPalindrome(String str) {

        String cleanStr = str.toLowerCase().replaceAll("[^a-z]", "");
        for(int i=0 ,j = cleanStr.length() -1; i< j ; i++ , j--){
            if(cleanStr.charAt(i) != cleanStr.charAt(j))
                return false;
        }

        return true;
    }
}
