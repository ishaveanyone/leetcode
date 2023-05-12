package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Date: 2023-05-11 9:52
 * Author: xupp
 */

public class 缺失的第一个正数 {

    public static int firstMissingPositive(int[] nums) {
       /* Arrays.sort(nums);
        int result =1;
        for (int num : nums) {
            if(num<=0)continue;
            if(num == result){
                result =   result+1;
            }
        }
        return result;*/

        //使用hash解决
        int result =1;
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length+1; i++) {
            if(!set.contains(i)){
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 1,2,1,4,1,134,5,6,9,55,2
        //3,4,-1,1,7
        //7,8,9,11,12
        int[] nums = {1};
        System.out.println(firstMissingPositive(nums));
    }
}
