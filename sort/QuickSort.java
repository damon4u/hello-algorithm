import java.util.Arrays;

/**
 * 快速排序
 * 采用分治的思想：
 * 首先选择一个key，然后完成一次partition，将待排序数据分为两部分，key左边的部分都比key小，key右边的部分都比key大
 * 之后将任务拆分为对左侧部分排序，再对右侧部分排序
 */
public class QuickSort {
    public static void quickSort(int[] array, int low, int high) {
        if(low < high) { // low小于high才需要排序，如果等于，那么就一个数，不用排
            int left = low;
            int right = high;
            int key = array[left]; // 使用第一个数作为key，完成partition

            while(left < right) { // 注意这里的循环条件，left指针右移，right指针左移，直到两者相遇，left=right
                while(left < right && array[right] >= key) { // right指针左移，注意判断两者是否相遇的left<right条件要一直带着
                    right--;
                }
                if(left < right) { // 这个比较可以减少最后left=right时的那次交换操作
                    array[left] = array[right];
                }

                while(left < right && array[left] <= key) {
                    left++;
                }
                if(left < right) {
                    array[right] = array[left];
                }
            }
            array[left] = key; // 最后left=right，把原来保留下来的第一个数字key赋值给array[left]
            quickSort(array, low, left-1); // 递归调用，完成左侧部分排序
            quickSort(array, right+1, high); // 递归调用，完成右侧部分排序
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,1,2,3,0,-1};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
