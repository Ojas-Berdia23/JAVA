// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

public class InfiniteArray {
    public static void main(String[] args) {
        // try not to use array.length function 
        int[] arr = {2,3,5,6,7,8,10,11,12,15,20,23,30};
        int target = 10;

        int ans = range(arr, target);
        System.out.println(ans);
    }

    static int range(int[] arr, int target) {
        // first find the range
        //  start with a box of size 2 i.e. 0th and 1st index.
        int start = 0;
        int end = 1;


        // arr.length used because index out of bound error
        // else use try and catch
        while (end < arr.length && target > arr[end]){
            int newStart =  end + 1;
            end = end + 2 * (end - start + 1);
            start = newStart;
        }
        return binarySearch(arr, target, start, end);

    }


    
    static int binarySearch(int[] arr, int target, int start, int end) {

        while(start <= end) {
            // find the middle element
            // int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if(target < arr[mid]) {
                end = mid - 1;
            }
            else if (target > arr[mid]) {
                start = mid + 1;
            }
            else {
                //ans found 
                return mid;
            }
        }
        return -1;
    }
}
