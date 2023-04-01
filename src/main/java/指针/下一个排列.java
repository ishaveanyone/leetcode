package 指针;

/**
 * Date: 2023-04-01 12:17
 * Author: xupp
 */

public class 下一个排列 {

    public static void nextPermutation(int[] nums) {
        int currentIndex = nums.length - 1;
        int swapLeft = -1;
        int swapRight = -1;
        while ( currentIndex>0 && (swapLeft+1)<currentIndex){
            for (int i = currentIndex-1; i >= (swapLeft+1); i--) {
                int pointer = i;
                if (nums[currentIndex] > nums[pointer]) {
                    //从这段里面去找
                    swapLeft = pointer;
                    swapRight = currentIndex;
                    break;
                }
            }
            currentIndex--;
        }
        if(swapLeft != swapRight) {
            swap(nums, swapLeft, swapRight);
        }
        sort(nums,swapLeft+1);
    }


    public static void main(String[] args) {
        int [] nums ={2,2,7,5,4,3,2,2,1};
        nextPermutation(nums);
        System.out.println(1);
    }

    public static void swap(int[] nums,int left ,int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static  void  sort (int[] nums,int start){
        for(int i =0;i<nums.length;i++){
            for(int j =start;j<nums.length  - (i+1);j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

}
