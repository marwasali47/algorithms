import java.util.*;

public class LeetCodeEasy {

    public static void main(String[] args) {
        //System.out.println( isPalindrome(121));
        //String[] strs = {"ab","a"};
        //System.out.println(longestCommonPrefix(strs));
        //System.out.println(isValid("()"));
        //System.out.println(searchInsert(new int[]{1,3,5,6},2));
        //System.out.println(lengthOfLastWord("Helllo WORLD"));
        System.out.println(plusOne(new int[]{9,9}));
    }

    public static String longestCommonPrefix2(String[] strs) {

        if(strs.length ==  1 ) return strs[0];
        if(strs.length ==  0 ) return "";

        String prefix = strs[0];
        for(int i =1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
    public static String longestCommonPrefix(String[] strs) {

        if(strs.length ==  1 ) return strs[0];
        if(strs.length ==  0 ) return "";
        int minLength = Integer.MAX_VALUE ;
        for(int i = 0 ; i < strs.length ; i++){
            if(strs[i].length()  < minLength )
                minLength = strs[i].length();
        }

        List<String> list = new ArrayList<>();
        Set<String> myset= new HashSet();
        for(int i = 0 ; i < minLength ; i++){
            for(int j = 0 ; j < strs.length ; j++){
                boolean x = myset.add(strs[j].substring(0, i+1));
                if(x && j >0){
                    return  list.size() >  0? list.get(list.size()-1) : "";
                }
            }
            list.add(myset.iterator().next());
            myset.clear();
        }
        return list.size() >  0? list.get(list.size()-1) : "";
    }

    public static  boolean isPalindrome(int x) {

        String str = x +"";
        char[] arr = str.toCharArray();
        char[] revArr = new char[arr.length];
        int n= arr.length;
        int j = n;
        for (int i = 0; i < n; i++) {
            revArr[j - 1] = arr[i];
            j = j - 1;
        }
        String revrseStr = String.valueOf(revArr);

        return revrseStr.equals(str);

    }

    public static boolean isValid(String s) {

        Stack<Character> leftSymbols = new Stack();

        // Loop for each character of the string
        for (char c : s.toCharArray()) {
            // If left symbol is encountered
            if (c == '(' || c == '{' || c == '[') {
                leftSymbols.push(c);
            }
            // If right symbol is encountered
            else if (c == ')' && !leftSymbols.isEmpty() && leftSymbols.peek() == '(') {
                leftSymbols.pop();
            } else if (c == '}' && !leftSymbols.isEmpty() && leftSymbols.peek() == '{') {
                leftSymbols.pop();
            } else if (c == ']' && !leftSymbols.isEmpty() && leftSymbols.peek() == '[') {
                leftSymbols.pop();
            }
            // If none of the valid symbols is encountered
            else {
                return false;
            }
        }
        return leftSymbols.isEmpty();
    }

    public static int  removeValElementFromNumsArray(int[] nums, int val) {

        int count = 0;

        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == val)
                count++;
            else
                nums[i-count] = nums[i];
        }

        return nums.length-count;

    }

    public static  int removeDuplicatesFromSortedArray(int[] nums) {

        int count = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1])
                count++;
            else nums[i-count] = nums[i];
        }

        return nums.length -count;

    }


    public static int searchInsert(int[] nums, int target) {

        int start= 0 ; int end = nums.length ; int mid = (end-start) /2;
        while(start <= end){

            if(target > mid )
                start = mid +1 ;

            if(target == mid)
                return mid;

            if(target < mid){
                end = mid - 1;
            }
        }
        return start;
    }

    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0 ) return 0;

        String[] x = s.split(" ");

        return  x[x.length].length();

    }

    public static  int[] plusOne(int[] digits) {

        int  carry = 1;
        for(int i = digits.length-1 ; i >= 0 && carry > 0 ; i-- ){
            if(digits[i] + 1 <= 9 ){
                digits[i] = digits[i]+1;
                carry = 0;
                return digits;
            }else {
                carry = 1;
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }


}
