package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2023-03-27 21:32
 * Author: xupp
 */

public class 括号生成 {




    public static List<String> generateParenthesis(int n) {

        //一个括号放之后 就可以往左或者往右填充一个新的括号
        List<String> resultList = new ArrayList<String>();
        backtrack(resultList,"",n,n);
        return resultList;
    }

    public static void main(String[] args) {
        generateParenthesis(3);
        System.out.println(1);
    }


    public static void backtrack( List<String> resultList,String path ,int left ,int right){
        if(left == 0 && right ==0){
            resultList.add(path);
            return;
        }
        if(left >0){
            backtrack(resultList,path+"(",left-1,right);
        }

        if(left<right){
            backtrack(resultList,path+")",left,right-1);
        }

    }

}
