public class MergeTwoSortedArrays {

    public static void main(String[] args) {

        System.out.println("merged  = " + merge(new int[]{1,2,3} ,new int[]{4,7}));
    }

    public static int[] merge(int[] arr1 , int[] arr2) {

        int[] merged = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        // Loop through both input arrays until we reach the end of one of them
        while (i < arr1.length && j < arr2.length) {
            // Compare the current elements in both arrays and add the smaller one to the merged array
            if (arr1[i] < arr2[j]) {
                merged[k] = arr1[i];
                i++;
            } else {
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }

        // If there are any remaining elements in the first input array, add them to the merged array
        while (i < arr1.length) {
            merged[k] = arr1[i];
            i++;
            k++;
        }

        // If there are any remaining elements in the second input array, add them to the merged array
        while (j < arr2.length) {
            merged[k] = arr2[j];
            j++;
            k++;
        }


        return merged;
    }

}
