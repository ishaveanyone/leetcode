package 指针;

/**
 * Date: 2023-04-01 14:18
 * Author: xupp
 */

public class 删除有序数组中的重复项 {

    public static int removeDuplicates(int[] nums) {
        int left =0 ;
        int right = nums.length -1;
        int remove = 0;
        while (  left<nums.length-remove  ){
            right = nums.length-1-remove;
            while (left <right) {
                if (nums[left] == nums[right]) {
                    move(nums, right, nums.length - remove - 1);
                    remove++;
                }
                right--;
            }
            left++;
        }
        return nums.length-remove;
    }


    public static void move(int[] nums,int start,int end){
        while (start<end){
            int tmp = nums[start];
            nums[start] = nums[start+1];
            nums[start+1] = tmp;
            start++;
        }
    }

    public static void main(String[] args) {
        int[] nums= {0,0,1,1,1,2,2,3,3,4};
       int cn = removeDuplicates(nums);
        System.out.println(cn);
    }

}
