public class BinSearch {
    public static int binSearch(int[] array, int key, int low, int high) {
        int left = low;
        int right = high;

        while(left <= right) {
            int mid = (left + right) >>> 1;
            if(array[mid] == key) {
                return mid; 
            } else if(array[mid] > key) {
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,2,2,3,4};
        System.out.println(binSearch(array, 3, 0, array.length-1));
    }
}
