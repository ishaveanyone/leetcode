package 数组;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.*;

public class 三数之和 {


    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int i = 0, len = nums.length;
        Arrays.sort(nums);
        Map<String, List<Integer>> reMap = new HashMap<>();
        while (i < len-2){
            int p = i+1,q=len-1;
            if(nums[i]>0)break;
            while (p<q) {
                int sum = nums[i] + nums[p] + nums[q];

                if(sum == 0){
                    String key = nums[i] + "," + nums[p] + "," + nums[q];
                    reMap.putIfAbsent(key, Arrays.asList(nums[i],nums[p],nums[q]));
                    p++;
                    continue;
                }
                if (sum > 0) {
                    q--;
                }else{
                    p++;
                }
            }
            i++;
        }
        return new ArrayList<>(reMap.values());
    }
}
