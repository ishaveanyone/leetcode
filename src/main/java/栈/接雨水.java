package 栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Date: 2023-05-12 10:09
 * Author: xupp
 */

public class 接雨水 {



    public static int trap2 (int[] height){
        int ans = 0;
        Stack<Integer>  st = new Stack<Integer>();
        for (int i = 0; i < height.length; i++)
        {
            while (!st.isEmpty() && height[st.peek()] < height[i])
            {
                int cur = st.peek();
                st.pop();
                if (st.empty()) break;
                int l = st.peek();
                int r = i;
                int h = Math.min(height[r], height[l]) - height[cur];
                ans += (r - l - 1) * h;
            }
            st.push(i);
        }
        return ans;
    }
    public static int trap(int[] height) {


        /*
        *
        *


        * */


        //只有后面的柱子大于栈顶才能接到水，也就是栈内的直观表现是 递增，所以是一个递减栈
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> used = new ArrayList<Integer>();
        int result = 0;
        for (int offset = 0; offset < height.length; ) {
            int reset =  searchIncStack(height,stack,used,offset);
            if( offset == reset ){
                stack.clear();
                used.clear();
                offset++;
                continue;//没有找到对应的递减栈
            }
            int width = used.size();
            int high = stack.peek();
            result = result +  width* high;
            for (int i = 0; i < used.size(); i++) {
                result -=used.get(i);
            }
            offset = reset;
            stack.clear();
            used.clear();
        }

        return result;
    }

    public static int searchIncStack(int[] height, Stack<Integer>  stack,  List<Integer> used ,int offset ){
        for (int i = offset; i < height.length; i++) {
            if(height[i] == 0 && stack.isEmpty())continue;
            if(stack.isEmpty()){stack.add(height[i]);continue;}
            if(height[i] >=stack.peek()){
                offset = i;
                break;
            }else{
                used.add(height[i]);
            }
        }
        return offset;
    }



    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap2(nums));

    }

}
