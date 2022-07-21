public class RotateArray {

    public static void main(String[] args) {

            int[] nums = new int[] {-1 , -100 , 3, 99};
            int k = 2;

            int start = 0 ;
            int end = nums.length -1 ;


            while (k > 0 ){
                int temp  = nums[start];
                nums[start] = nums [end];
                nums[end] = temp;
                start++;
                end--;
                k--;
            }

        System.out.println(nums);

    }


}
