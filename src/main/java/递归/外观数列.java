package 递归;

/**
 * Date: 2023-05-09 16:20
 * Author: xupp
 */

public class 外观数列 {
    public static String countAndSay(int n) {
        return deep(n);
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String deep (int n){
        if(n==1){
            return "1";
        }
        String result = deep(n-1);
        char[] charArr = result.toCharArray();
        String reStr = new String();
        int step = 1;
        char last = charArr[0];
        int i =1;
        while (i < charArr.length){
            char target = charArr[i];
            if( last !=target) {
                reStr = reStr +  step + last;
                last = target;
                step = 1;
            }else {
                step ++ ;
            }
            i++;
        }
        reStr = reStr +  step + last;
        return reStr;
    }
}
