package 数组;

import java.io.FileReader;

public class 删除有序数组中的重复项 {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2};
        System.out.println(removeDuplicates(arr));
    }


    public static int removeDuplicates(int[] nums) {

        //使用前后指针
        int i=0,len=nums.length ;
        int res=1;
        for (  i = 0; i < len-1; i++) {
            int p = i+1 ;
            if(nums[len-1]<=nums[i]){
                break;
            }
            while ( p < len){
                if(nums[p]>nums[i] ){
                    //交换 p 和 i+1的文字
                    int temp = nums[i+1];
                    nums[i+1] = nums[p];
                    nums[p] = temp;
                    res++;
                    break;
                }
                p++;
            }
        }
        return res;
    }
}
