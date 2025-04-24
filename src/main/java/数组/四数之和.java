package 数组;

import java.util.*;
import java.util.stream.Collectors;

public class 四数之和 {


    public static void main(String[] args) {
       int[] nums = {1000000000,1000000000,1000000000,1000000000};int target = -294967296;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //使用贪心算法 那么 从 第一数值开始计
        Arrays.sort(nums);
        Map<String,List<Integer>> reMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                for (int k = j + 1; k < nums.length; k++) {

                    for (int l = k + 1; l < nums.length; l++) {
                        long num1 = nums[i] ;
                        long num2 = nums[j] ;
                        long num3 = nums[k] ;
                        long num4 = nums[l] ;
                        long sum = num1+num2+num3+num4;
                        if ( sum == target) {
                            String key = nums[i]+"_"+nums[j]+"_"+nums[k]+"_"+nums[l];
                            reMap.putIfAbsent(key,Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                            break;
                        }
                    }
                }
            }
        }
        return new ArrayList<>(reMap.values());

    }






}
