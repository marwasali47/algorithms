public class Steps {

    public static void main(String[] args){

    }

    public int getTotalCount(int n){
        if(n <= 0) return 0;
        int[] steps = new int[n+1];
        steps[0] = 1;
        steps[1] = 1;
        for(int i=2 ;i <= n ; i++){
            steps[i] = sumArray(steps, i);
        }
        return steps[n];
    }

    private int sumArray(int[] steps , int i) {
        int sum = 0;
        sum += steps[i-1] + steps[i-2];
        return sum ;
    }
}
