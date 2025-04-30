package 数组;

import java.awt.font.NumericShaper;
import java.util.Arrays;

public class Z字形变换 {

    public static void main(String[] args) {
        String s = "AdadafdafB";
        int numRows  = 3;

        System.out.println(convert2(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        char[][] chars = new char[numRows][s.length()];
        StringBuffer sb = new StringBuffer();
        int col =0,row =0, offset = 1 ,charIdx = 0;
        while (true) {
            if(row == numRows){
                offset =-1;
                col++;
                row-=2;
                continue;
            }
            if (charIdx >= s.length()) {
                break;
            }
            chars[row][col] = s.charAt(charIdx);
            charIdx ++;
            row+=offset;//加上偏移量

            if(row == -1){
                offset =1;
                col++;
                row+=2;
            }
        }

        for(int i = 0; i < numRows; i++){
            for (int j = 0; j < s.length(); j++) {
                if(chars[i][j] == '\u0000'){
                    continue;
                }
                sb.append(chars[i][j]);
            }
        }
        return sb.toString();
    }



    public static String convert2(String s, int row) {
            if (row < 2) return s;
            // 从上往下、从左到右
            char[] cs = s.toCharArray();
            StringBuilder[] arr = new StringBuilder[row];
            Arrays.setAll(arr, i -> new StringBuilder());
            int f = 1;
            for (int i=0,j=0;i<cs.length;i++) {
                arr[j].append(cs[i]);
                j += f;
                if (j == row-1 || j == 0) f *= -1;
            }
            StringBuilder sbr = new StringBuilder();
            for (int i=0;i<row;i++) sbr.append(arr[i]);
            return sbr.toString();

    }




}
