package 数组;

import java.time.chrono.IsoChronology;

public class 回文数 {

    public static void main(String[] args) {
        int a = 121;
        System.out.println(isPalindrome(a));
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
