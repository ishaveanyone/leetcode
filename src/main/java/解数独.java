/**
 * Date: 2023-05-09 11:32
 * Author: xupp
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 解数独 {
    public void solveSudoku(char[][] board) {
        //需要先准备好对应的hash过滤数组
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][][] mids = new int[3][3][10];
        char[] arrays = {'1','2','3','4','5','6','7','8','9'};
        for (char array : arrays) {
            board = search(0,0,rows,cols,mids,board,array);
        }
    }





    public char[][] search( int i , int j ,int[][] rows ,int[][] cols,int[][][] mids ,char[][] board,char data){
        char current = board[i][j];
        if( current !='.' ){
            rows[i][current - '0'] =1;
            cols[j][current - '0'] =1;
            mids[i/3][j/3][current - '0'] = 1;
            return board;
        }
        //开始对所有的数据进行变量
        int target = data - '0';
        if( rows[i][target] == 1 ||  cols[j][target] ==1 ||  mids[i/3][j/3][target] ==1){//如果已经存在了
            return board; //已经存在了
        }else{
            rows[i][target] =1;
            cols[j][target] =1;
            mids[i/3][j/3][target] =1;
            board[i][j] = data;
        }
        char[] arrays = {'1','2','3','4','5','6','7','8','9'};
        if( i<8&&j<8 ) {
            for (char array : arrays) {
                board = search(i,j+1,rows,cols,mids,board,array);
            }
        }
        if (i<8 &&j ==8 ) {
            for (char array : arrays) {
                board =  search(i+1,0,rows,cols,mids,board,array);
            }
        }
        return board;//结束标识
    }


   /* public void solveSudoku(char[][] board) {
        //需要先准备好对应的hash过滤数组
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][][] mids = new int[3][3][10];
        char[] arrays = {'1','2','3','4','5','6','7','8','9'};
        for (char array : arrays) {
            search(0,0,rows,cols,mids,board,array);
        }
    }





    public void search( int i , int j ,int[][] rows ,int[][] cols,int[][][] mids ,char[][] board,char data){
        char current = board[i][j];
        if( current !='.' ){
            rows[i][current - '0'] =1;
            cols[j][current - '0'] =1;
            mids[i/3][j/3][current - '0'] =1;
            return;
        }
        //开始对所有的数据进行变量
        int target = data - '0';
        if( rows[i][target] == 1 ||  cols[j][target] ==1 ||  mids[i/3][j/3][target] ==1){//如果已经存在了
            return; //已经存在了
        }else{
            rows[i][target] =1;
            cols[j][target] =1;
            mids[i/3][j/3][target] =1;
            board[i][j] = data;
        }
        char[] arrays = {'1','2','3','4','5','6','7','8','9'};
        if( i<8&&j<8 ) {
            for (char array : arrays) {
                search(i,j+1,rows,cols,mids,board,array);
            }
        }
        else if (i<8 &&j ==8 ) {
            for (char array : arrays) {
                search(i+1,0,rows,cols,mids,board,array);
            }
        }else {
            return;//结束标识
        }
    }*/
}
