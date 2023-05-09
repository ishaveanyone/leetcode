package hash;

/**
 * Date: 2023-05-08 17:29
 * Author: xupp
 */

public class 有效的数独 {


    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];// 每一个数据是否在所在行出现过
        int[][] col = new int[9][10];// 每一个数据是否在所在列出现过
        int[][][] mid = new int[3][3][10]; // 每一个数据是否在所在方格内出现过
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int target = board[i][j] - '0';
                if (row[i][target] != 0) return false;//说明已经出现过这个数据
                if (col[j][target] != 0) return false;//说明已经出现过这个数据
                if (mid[i / 3][j / 3][target] != 0) return false;
                row[i][target] = 1;
                col[j][target] = 1;
                mid[i / 3][j / 3][target] = 1;
            }
        }
        return true;
    }

}
