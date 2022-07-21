import java.util.Stack;

public class minSumArray {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        System.out.println(decodeString("3[a]2[bc]"));
       // System.out.println( "minSubArrayLen = " +minSubArrayLen(11 , array));
       // System.out.println("arrangeCoins = "  +arrangeCoins(6));
        //System.out.println("arrangeCoins = "  +arrangeCoins(5));
    }

    public static String decodeString(String s) {
        Stack<String> decoded = new Stack();
        Stack<Character> stack = new Stack();
        Stack<Character> stackTemp = new Stack();

        for(int i=0 ; i < s.length() ; i++){
            stack.push(s.charAt(i));
        }

        while(!stack.isEmpty()){
            char myChar = stack.pop();
            if( !(myChar == '[' || myChar == ']')) {
                stackTemp.push(myChar);
            }
            if(myChar ==  ']') {
                Character chr2 = stack.pop();
                while (chr2 != '['){
                    stackTemp.push(chr2);
                    chr2 = stack.pop();
                }
                Character counter = stack.pop();
                Integer times = Integer.parseInt(Character.toString(counter));
                StringBuilder temp = new StringBuilder();
               while(!stackTemp.isEmpty()){
                   temp.append(stackTemp.pop());
               }
               while(times > 0){
                   decoded.push(temp.toString());
                   times--;
               }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!decoded.isEmpty()){
            sb.append(decoded.pop());
        }
        return sb.toString();
    }

    public static int arrangeCoins(int n) {

        int i = 1;
        while(n > 0){
            i++;
            n = n-i;
        }
        return i-1;

    }

    public static int minSubArrayLen(int sum, int[] array) {

        int minlength = 0;
        for(int i = 0 ; i < array.length ; i++){
            int mysum = 0;
            for ( int j = i ; j <  array.length ; j++){
                mysum = mysum + array[j];
                if(mysum == sum){
                    if(minlength == 0)  {
                        minlength =  (j-i+1 ) ;
                    }
                    else if ((j-i+1) < minlength ) {
                        minlength = j-i+1;
                    }
                }
                if(mysum > sum){
                    break;
                }
            }
        }

        return minlength;
    }
}
