public class Fibonacci {

    public static void main(String[] args) {

        System.out.println("Fibonacci  = " + fib(7));
    }

    public static int fib(int n){

        if(n <= 1)
            return 1;

        return fib(n-2) + fib(n-1);
    }


}
