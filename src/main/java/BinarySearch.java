import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinarySearch {

    public static int findSubArray(int[] array, int sum) {

        boolean found = false;
        int subArraySum = 0;
        int start = 0;
        int end = array.length -1;
        for (int i = 0; i < array.length; i++) {
            subArraySum += array[i];
            if(subArraySum < sum){
                continue;
            }else if(subArraySum > sum){
                subArraySum = 0;
                start = i+1;
            }else{
                end  = i;
                found = true;
                break;
            }
        }
        if(found)  return end -start + 1 ;
        else return 0;
    }

    public static int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int[] housesNearest = new int[houses.length];
        for (int i = 0; i < houses.length; i++) {
            housesNearest[i] = searchNearest(heaters , houses[i]);
        }
        Arrays.sort(housesNearest);
        return housesNearest[housesNearest.length -1 ];
    }

    public static int searchNearest(int[] heaters, int house) {

        int nearestDistance = Math.abs(heaters[0] - house);

        for (int i = 0; i < heaters.length; i++) {
            int distance = Math.abs(heaters[i] - house);
            if (distance <= nearestDistance) {
                nearestDistance = distance;
            }
        }
        return nearestDistance;
    }

    public static int getMinimumUniqueSum(List<Integer> arr) {

        Set<Integer> myset = new HashSet<>();
        for(int i  : arr){
            myset.add(i);
        }

        int sum = 0;
        for (Integer num : myset) {
            sum+= num;
        }
        return sum;

    }

    public static void main(String[] args) {

        int array []= new int[]{1,1,1,1,1,1,1,1} ;
       // System.out.println("findSubArray "+ findSubArray(array,11));
        //int houses []= new int[]{1,5} ; int heaters[] = new int[]{2};
        //System.out.println("findRadius : "+ findRadius(houses,heaters));

        //int matrtix[][] = new int[][]{{1 ,2} , {3,4}}; //, target = 13;
        //System.out.println("searchMatrix = " + searchMatrix(matrtix ,4));
        //System.out.println("guess Num : " + guessNumber(2126753390));

        /*int[] houses = new int[]{1,2,3};
        int[] heaters = new int[]{2};
        System.out.println("find radius " + findRadius(houses,heaters));*/

       /* int[] arr = new int[]{ -2,0,10,-19,4,6,-8} ;
        System.out.println("checkIfExist :" + checkIfExist(arr)) ;
*/
        //System.out.println("firstBadVersion = " + firstBadVersion(1000));

        /*int[] f = new int []{ 0,0,0,1,1,1,1 ,1,1};
        System.out.println("first index = " + BSfindFirst(f , 0 , f.length , 0));
        System.out.println("last index = " + BSfindLast(f , 0 , f.length , 0));

        int[] f1 = new int []{1,1,1,1,0,0,0,0,0,0};
        System.out.println("last index  desc= " + BSfindLastDecreasing(f1 , 0 , f1.length , 1));*/
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int start = 0 ; int end = matrix.length -1 ; int mid = 0;

        //Single element matrix
        if(matrix.length ==1)
            return Arrays.binarySearch(matrix[0],0 , matrix[0].length , target) >=0 ;

        while(start <= end ){

            mid = (start + end) / 2;

            if(Arrays.binarySearch(matrix[mid],0 , matrix[mid].length  , target) >=0 ){
                return true;
            }else {
                // target should be in this row ?
                if(target > matrix[mid][0] && target < matrix[mid][matrix[mid].length -1 ]) return false;

                //adjust start and end
                if(target > matrix[mid][0]) start = mid +1  ;

                else if (target < matrix[mid][matrix[mid].length -1 ]) end = mid -1 ;
            }
        }
        return false;

    }



    public static int guessNumber(int n) {
        long start = 1 ; long end = n ;
        while (start <= end){
            long mid = (start + end) / 2; //
            int midInt = new Integer(mid + "");
            //1 : Your guess is lower than the number I picked
            if (guess(midInt) == 1)
                start = mid + 1 ;

            //-1 : Your guess is higher than the number I picked
            else if (guess(midInt) == -1)
                end = mid-1 ;

            else
                return midInt;
        }
        return -1;
    }

    private static int guess(long guess) {
        if(guess < 1702766719) return 1;
        if(guess > 1702766719) return -1;
        return 0;
    }

    public  static boolean checkIfExist(int[] arr) {
        //sort array arr = [1,7,11,12 ,14]
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(findDoubleElementInArray(arr,arr[i]*2 ,i )) {
                return true;
            }
        }
        return false;
    }
    private static boolean findDoubleElementInArray(int[] arr, int i , int index) {
        int foundIndex  = Arrays.binarySearch(arr, i)  ;
        return  foundIndex >=0 && foundIndex != index;
    }

    public static int firstBadVersion(int n) {
        int start = 1 ; int end = n ; int badVersion = 0;
        while(start <= end) {
            int mid = start + (end-start) / 2;
            if(isBadVersion(mid)) {
                System.out.println("bad version = " + mid);
                badVersion = mid;
                end = mid -1;
            }
            else {
                start = mid+1;
            }
            System.out.println(mid + " " + start + " " + end );
        }
        return badVersion;
    }

    private static boolean isBadVersion(int version) {
        return version < 1000;
    }

    public static int BSfindLast(int[] f ,int start, int end, int val) {
        while(start < end) {
            int mid = start + (end-start+1) / 2;
            if(f[mid] < val)		start= mid + 1;
            else if(f[mid] > val)	end  = mid - 1;
            else start = mid;
        }
        return start;
    }

    public static int BSfindLastDecreasing(int[] f ,int start, int end, int val) {
        int index = 0 ;
        while(start < end && (end - start > 2)) {
            int mid = start + (end-start) / 2;
            if(f[mid] < val)		end= mid -1;
            else if(f[mid] > val)	start  = mid+1 ;
            else start = mid;
        }

        for(int i=start ; i< end ; i++){
            if(f[i] == val) index = i;
        }
        return  index;
    }

    public  static int BSfindFirst(int[] f,int start, int end, int val) {

        while(start < end) {
            int mid = start + (end-start) / 2;
            int item = f[mid];
            if(item < val)		start= mid + 1;
            else if(item > val)	end  = mid - 1;
            else end  = mid;
        }

        return start;
    }

    public  static  int binary_search(int A[], int key, int imin, int imax){

        // continue searching while [imin,imax] is not empty
        while (imin < imax){

            // calculate the midpoint for roughly equal partition
            int imid = (imin + imax) / 2; //(imin + imax) / 2

            // determine which subarray to search
            if (A[imid] < key)

                // change min index to search upper subarray
                imin = imid + 1;

            else if (A[imid] > key)
                // change max index to search lower subarray
                imax = imid - 1;

            else
                // key found at index imid
                return imid;
        }

        // key not found
        return -1;
    }


    public  static  int binary_search_lower_or_higher(int A[], int key, int imin, int imax){

        // continue searching while [imin,imax] is not empty
        while (imin < imax){
            // calculate the midpoint for roughly equal partition
            int imid = (imin + imax) / 2; //(imin + imax) / 2
            // determine which subarray to search
            if (A[imid] < key)
                // change min index to search upper subarray
                imin = imid + 1;

            else if (A[imid] > key)
                // change max index to search lower subarray
                imax = imid - 1;

            else
                // key found at index imid
                return 0;
        }

        // key not found
        return -1;
    }
}
