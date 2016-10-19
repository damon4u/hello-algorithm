
/**
 * 动态规划求解数组最大差值
 * 给一个数组，其中有n个数字，求后面的数与前面的数的差值，将最大差值的两个数找出来。
 * @see <a href="http://jingxin.me/blog/blog/2013/04/08/dong-tai-gui-hua-qiu-jie-shu-zu-zui-da-chai-zhi/">动态规划求解数组最大差值</a>
 * (1)游标所指的数大于结果数组中的最大值，比如后面有11，那么结果数组就变成[3,11]
 * (2)游标所指的数小于结果数组中的最小值，那么它就有可能在后面替换结果数组中的最小值，例如后面出现了1，这个时候不能立刻替换掉3，需要找个临时变量将1保存下来。
 * (3)游标所指的数与临时最小值之差大于结果数组中两数字之差。这个条件应该优先于决策2和决策1，一旦这个决策生效，将同时替换结果数组中的最大最小值，决策1和决策2在这个时候应该不生效。例如后面出现了12，那么结果数组就应该变成[1,12]。假如这个时候决策1优先生效，那么结果数组会变成[3,12]，而临时变量1将永远没有上位之日了。
 */
public class MaxDiffLeftToRight {
    
    public static Result maxDiffLeftToRight(int[] array, int low, int high) {
        if(low >= high) {
            return new Result(low,high,0);
        }
        int left = low;
        int right = low + 1;
        int maxDiff = array[right] - array[left];
        int tmpMin = -1;
        for(int i = low + 2; i <= high; ++i) {
            if(tmpMin != -1 && array[i] - array[tmpMin] > maxDiff) {
                maxDiff = array[i] - array[tmpMin];
                left = tmpMin;
                right = i;
            } else if(array[i] > array[right]) {
                maxDiff = array[i] - array[left];
                right = i;
            } else if(array[i] < array[left] && (tmpMin == -1 || array[i] < array[tmpMin])) {
                tmpMin = i;
            }
        }
        System.out.println(array[left] + "," + array[right]);
        return new Result(left, right, maxDiff);
    }


    static class Result {
        Result(int left, int right, int maxDiff){
            this.left = left;
            this.right = right;
            this.maxDiff = maxDiff;
        }
        private int left;
        private int right;
        private int maxDiff;
        
        public String toString() {
            return "[" + this.left + "," + this.right + "] -> " + this.maxDiff;
        }
    }   

    public static void main(String[] args) {
        int[] array = {3,10,11,9,1,2,-1,10,7};
        System.out.println(maxDiffLeftToRight(array,0,array.length-1));
    
    }
}
