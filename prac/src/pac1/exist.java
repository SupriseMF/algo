package pac1;

public class exist {

    /**
     * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     * 输入：
     * board = [["A","B","C","E"],
     *          ["S","F","C","S"],
     *          ["A","D","E","E"]],
     * word = "ABCCED"
     * 输出：true
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        /**
         * 深度优先遍历
         *
         * 每个点都要进行三次调用，最多O(3^l)，l为word的长度
         * 时间复杂度O(M * N * 3^l)
         * 空间复杂度O(M * N) 使用了visited数组，同时栈深度最大为O(min{M * N, l})
         *
         */
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = dfs(board, visited, i, j, 0, word);
                if (flag) {
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean dfs(char[][] board, boolean[][] visited, int row, int col, int index, final String word) {
        // 结束条件
        if (board[row][col] != word.charAt(index)) {
            return false;
        } else if (word.length() - 1 == index) {
            return true;
        }
        visited[row][col] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean res = false;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newRow > board.length - 1) {
                continue;
            }
            if (newCol < 0 || newCol > board[0].length - 1) {
                continue;
            }
            if (visited[newRow][newCol]) {
                continue;
            }
            boolean flag = dfs(board, visited, newRow, newCol, index + 1, word);
            if (flag) {
                res = true;
                break;
            }
        }
        // 回溯返回时，撤销访问标识
        visited[row][col] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));

    }
}
