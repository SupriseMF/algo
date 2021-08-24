package pac1;

import java.util.Arrays;

public class rotate {

    /**
     * 旋转图像
     *  
     *  给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     *
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[7,4,1],[8,5,2],[9,6,3]]
     * [1,2,3]           [7,4,1]
     * [4,5,6]   -->     [8,5,2]
     * [7,8,9]           [9,6,3]
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        /**
         * 方法1、第N行的数，出现在倒数第N列
         * 方法2、翻转
         * 先进行水平翻转
         * 在进行对角线翻转
         *
         */
        int n = matrix.length;
        // 若是顺时针🔃旋转，采用每列上翻转
        //  且 外小内大，消耗时间更短
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        // 若是逆时针🔄旋转，采用每行上翻转
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n / 2; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[i][n - j - 1];
//                matrix[i][n - j - 1] = temp;
//            }
//        }
        // 对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();

        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
