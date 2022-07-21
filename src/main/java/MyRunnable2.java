import java.util.Scanner;

public class MyRunnable2 {

    /*
     * Enterprise Fizz Buzz:
     * Stage 1:
     * Pass over the first 1000 numbers (starting from 0) and :
     * if the number is divisible by 3 print 'fizz' in the command line,
     * if it's divisible by 7 print 'buzz' (divisible means the remainder of the division operation is 0),
     * if it's divisible by a number we've passed as argument previously print "EntrepriseFizzBuzz",
     * if it's a square of a natural number (natural numbers are all positive whole numbers, 1, 2, 3...)
     * print 'Mathematics'.
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String fizz = "fizz";
        String buzz = "buzz";
        String entrepriseFizzBuzz = "EntrepriseFizzBuzz";
        String mathematics = "Mathematics";
        int scannedInt = sc.nextInt();
        for (int i = 0; i < 1000; i++) {
            if(i % 3 ==0 ) System.out.println(fizz);
            if(i % 7 == 0) System.out.println(buzz);
            if(i % scannedInt == 0) System.out.println(entrepriseFizzBuzz);
            if(checkIfSquare(i)) System.out.println(mathematics);
        }
    }

    public static boolean checkIfSquare(int i){
        return Math.sqrt(i) - Math.round(Math.sqrt(i)) == 0;
    }
}
