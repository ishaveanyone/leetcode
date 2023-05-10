package 回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Date: 2023-05-09 17:08
 * Author: xupp
 */

public class 组合总和 {

    public static List<List<Integer>> combinationSum( int[] candidates, int target ) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i <candidates.length ; i++) {
            backtrack(0,target,i,candidates,result,new ArrayList<Integer>());
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        Object p = combinationSum(nums,7);
        System.out.println(1);
    }


    //回溯
    public static int backtrack(
            int sum,
            int target,
            int offset ,
            int[] candidates,
            List<List<Integer>> result ,
            List<Integer> param
    ){
        param.add(candidates[offset]);
        sum = sum + candidates[offset];
        if( offset ==candidates.length ){
            return sum;
        }
        if( target == sum ){
            List<Integer> tmp =  new ArrayList<Integer>();
            tmp.addAll(param);
            result.add(tmp);
            return sum;
        }
        if(target<sum){
            return sum;
        }
        while ( offset<candidates.length ){
            sum = backtrack(sum,target,offset,candidates,result,param);
            int pop =  param.remove(param.size()-1); // 删除卡前面一个开始进行下一个数据的回溯
            sum = sum - pop;
            offset++;
        }
        return sum;
    }

}
