package 动态规划;

import java.util.Arrays;

/**
 * Date: 2023-04-02 16:58
 * Author: xupp
 */

public class 最长有效括号 {

    public static int longestValidParentheses(String s) {
        if (s.equals("")){
            return 0;
        }
        int[] dp = new int[s.length()] ;
        char[] chars = s.toCharArray();
        dp[0] = 0;
        for (int i = 1; i < chars.length; i++) {
            if( chars[i] == '(' ){
                dp[i] = 0;
            }else{
                //查找这个右括号对应的左括号
                int targetLeftIndex = i - dp[i-1]-1;
                if( targetLeftIndex<0 ){
                    dp[i] = 0;
                    continue;
                }
                char targetLeftVal = chars[ targetLeftIndex ];
                if( targetLeftVal == ')' ){
                    dp[i] = 0;
                }else{
                    if(targetLeftIndex>=1) {
                        dp[i] = dp[i - 1] + 2 + dp[targetLeftIndex - 1];
                    }else{
                        dp[i] = dp[i - 1] + 2 ;
                    }
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        String s = "())";
        System.out.println(longestValidParentheses(s));
    }


}
