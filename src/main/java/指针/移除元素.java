package 指针;

/**
 * Date: 2023-04-01 14:50
 * Author: xupp
 */

public class 移除元素 {

    public static int removeElement(int[] nums, int val) {
        int remove =0;
        int current = 0;
        while (current < nums.length-remove){
            if(nums[current] == val){
                move(nums,current,nums.length-remove-1);
                remove++;
            }
            if(nums[current] !=val) {
                current++;
            }
        }
        return nums.length-remove;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int result = removeElement(nums,2);
        System.out.println(result);
    }

    public static void move(int[] nums,int start,int end){
        while (start<end){
            int tmp = nums[start];
            int next = nums[start+1];
            nums[start] = next;
            nums[start+1] = tmp;
            start++;
        }
    }
}
