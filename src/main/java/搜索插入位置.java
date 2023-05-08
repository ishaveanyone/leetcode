
/**
 * Date: 2023-05-06 18:26
 * Author: xupp
 */

public class 搜索插入位置 {
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //
    //请必须使用时间复杂度为 O(log n) 的算法。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/search-insert-position
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int searchInsert(int[] nums, int target) {
        if(nums.length ==1 && nums[0]>=target){
            return 0;
        }
        if(nums.length ==1 && nums[0]<target){
            return 1;
        }
        int left =0,right =nums.length-1;
        int result =-1;

        while (left<right){
            int mid = (left+right)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else {
                right = mid;
            }
            if((right-left ==1 || right-left ==0) ){
                if( nums[left] ==target ) {
                    result = left;
                    break;
                }
                if( nums[right] ==target ){
                    result = right;
                    break;
                }
                if( target>nums[right] ){
                    result = right +1;
                    break;
                }
                if( target>nums[left] ) {
                    result = left+1;
                    break;
                }
                if( target<nums[left] ) {
                    result = left;
                    break;
                }
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,2));
    }
}
