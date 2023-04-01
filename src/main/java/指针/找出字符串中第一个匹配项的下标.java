package 指针;

import javax.swing.*;

/**
 * Date: 2023-04-01 15:08
 * Author: xupp
 */

public class 找出字符串中第一个匹配项的下标 {

    public static int strStr(String haystack, String needle) {
       char[] haystackCharArray =  haystack.toCharArray();
       char[] needleCharArray = needle.toCharArray();
       int range = needle.length();
       int head = 0 ;
       int result = -1;
       while (head <= haystack.length()-range){
           boolean match =true;
           for (int i=head;i<range+head;i++){
               if(haystackCharArray[i] != needleCharArray[i-head] ){
                   match=false;
                   break;
               }
           }
           if(match){
               result = head;
               break;
           }
           head++;

       }
       return result;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
    }
}
