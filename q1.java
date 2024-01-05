public class Q1 {
/**
 *  a private method in order to find the leftmost occurrence of k
 *  a documentation of the code is found between the lines
 * @param arr
 * @param k
 * @return
 */
private static int binarySearchStart(int[] arr, int k) {
    int low=0;
    int high= arr.length-1;
    int result=-1;
    while(low<high){
      int mid=low+(high-low) /2; // adding the low value in the range
        if (arr[mid]==k){// if we've found an occurrence
            result=mid; // Saving the Occurrence
            high=mid-1;// Checking in the left range of the number
        } else if (arr[mid]<k) { // checking the right range
            low=mid+1;// Updating the low value
        }
        else {
            high=mid-1;// Updating the high value
        }
    }
    return result;

    }
    /**
     * a private method to find the rightmost occurrence of k
     * a documentation of the code is found between the lines
     * @param arr
     * @param k
     * @return
     */
    private static int binarySearchEnd(int[] arr, int k) {
      int low=0;
      int high= arr.length;
      int result=-1;
      while(low<=high){
          int mid =low+(high-low)/2;
          if(arr[mid]==k){
              result=mid;
              low=mid+1;// Checking in the left range of the number
          } else if (arr[mid]<k) {
              low = mid + 1; // Updating the low value

          }   else {
              high = mid - 1; // returning the rightmost value
          }
          }
        return result;
    }
    public static String rangeOfK(int[] arr, int k) {
        int start = binarySearchStart(arr, k);
        if (start == -1) {
            return "[-1,-1]";
        }else {
            int end = binarySearchEnd(arr, k);
            return "[" + start + "," + end + "]";
        }
    }
    public static void main(String[] args) {
        int []a= {1,1,1,2,2,3,3,3,3,3,3,4,5,7,8,10,10,10};
        System.out.println(rangeOfK(a,3));
    }
}
