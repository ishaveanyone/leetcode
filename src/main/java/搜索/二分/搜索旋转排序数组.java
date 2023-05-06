package 搜索.二分;

/**
 * Date: 2023-04-28 9:45
 * Author: xupp
 */

public class 搜索旋转排序数组 {
    public static int search(int[] nums, int target) {
        //开始进行数据
        int head = nums[0];              // 头数据
        if( target == head ) return 0;
        int left = 0, right= nums.length-1;
        while ( left<right ){
            //说明左边有序
            int mid = (left+right)/2;
            if(nums[mid] == target) return mid;
            if(nums[left] == target) return left;
            if(nums[right] == target) return right;
            //如果没有旋转是这样的
            if( nums[left] <= nums[right] ){
                if( target <  nums[mid] )
                    right = mid-1;
                else
                    left = mid+1;
            }else{
                if( nums[left] <= nums[mid] )
                    if( nums[mid] >target && target>nums[right])
                        right = mid-1;
                    else
                        left =mid+1;
                else
                    if(nums[mid]<target  && target<nums[left])
                        left = mid+1;
                    else
                        right =mid-1;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        //[4,5,6,7,0,1,2]
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
}
