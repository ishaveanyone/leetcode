package 搜索.二分;

/**
 * Date: 2023-05-06 10:32
 * Author: xupp
 */

public class 在排序数组中查找元素的第一个和最后一个位置 {


    public static int[] searchRange(int[] nums, int target) {

        //nums = [5,7,7,8,8,10], target = 8
        //输出：[3,4]
        if(nums.length ==1 && nums[0] ==target){
            return new int[]{0,0};
        }
        int[] result = {-1,-1};
        int left =0,right = nums.length-1;
        while ( left < right ) {
            //找前后位置
            int mid = (left+right)/2;
            if(target > nums[mid]){
                left = mid+1;
            }else if (target < nums[mid]){
                right = mid-1;
            }else{
                right = mid;
            }
            if(nums[left] == target) {result[0]=left ;break;}
        }

        left =0;right = nums.length-1;
        while ( left < right ) {
            //找前后位置
            int mid = (left+right)/2;
            if(target > nums[mid]){
                left = mid+1;
            }else if (target < nums[mid]){
                right = mid-1;
            }else{
                left = mid;
            }
            if(right - left ==1|| right -left ==0){
                if(nums[right] == target) {result[1]=right ;break;}
                if(nums[left] == target) {result[1]=left ;break;}
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] nums = {1,4};
        int[] result = searchRange(nums,4);
        for (int i : result) {
            System.out.println(i);
        }

    }


}
