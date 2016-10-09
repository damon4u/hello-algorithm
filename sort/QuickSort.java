import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array, int low, int high) {
        if(low < high) {
            int left = low;
            int right = high;
            int key = array[left];

            while(left < right) {
                while(left < right && array[right] >= key) {
                    right--;
                }
                if(left < right) {
                    array[left] = array[right];
                }

                while(left < right && array[left] <= key) {
                    left++;
                }
                if(left < right) {
                    array[left] = array[right];
                }
            }
            array[left] = key;
            quickSort(array, low, left-1);
            quickSort(array, right+1, high);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,1,2,3};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
