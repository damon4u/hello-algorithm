public class PrintDiagonal { 
    public static void printDiagonal(int[][] array, int n) {
        int index = 0;
        for(int i = 0; i < n; i++) {
            int x = 0;
            while(x <= index) {
                System.out.print(array[x][index-x] + "\t");
                x++;
            }
            System.out.println();
            index++;
        }
        for(int i = 1; i < n; i++) {
            int x = i;
            for(int j = n - i; j > 0; j--) {
                System.out.print(array[x][index-x] + "\t");
                x++;
            }
            System.out.println();
            index++;
        }
    }

    public static void print(int[][] array, int n) {
        for(int i = 0; i <= 2*(n-1); ++i) { //总共要输出2(n-1)+1趟
            for(int j = 0; j < n; ++j) {
                for(int k = 0; k < n; ++k) {
                    if(j + k == i) {
                        System.out.print(array[j][k] + "\t");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = java.lang.Integer.parseInt(args[0]);
        int[][] array = new int[n][n];
        for(int i = 0; i < n*n; ++i){
            array[i/n][i%n] = i + 1;
        }

        for(int i = 0; i < n*n; ++i) {
            if(i%n == 0) {
                System.out.println();
            }
            System.out.print(array[i/n][i%n] + "\t");
        }
        System.out.println();

        printDiagonal(array,n);
        System.out.println();
        print(array,n);
    }
}
