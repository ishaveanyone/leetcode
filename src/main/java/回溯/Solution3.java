package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2023-03-30 9:50
 * Author: xupp
 */

public class Solution3 {
    public static class ListNode {
        public  int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode();
        return dfsSwap(pre,head,k,k);
    }


    public static void main(String[] args) {
        ListNode l1  = new ListNode(1);
        ListNode l2  = new ListNode(2);
        ListNode l3  = new ListNode(3);
        ListNode l4  = new ListNode(4);
        ListNode l5  = new ListNode(5);
        ListNode l6  = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode l =   reverseKGroup(l1,3);
        System.out.println(1);

    }

    public static  ListNode dfsSwap ( ListNode head,ListNode current, int step ,int k){

        if( current == null && step >0 )
            //代表这段不能进行翻转 返回头指针
            return null;
        if( step == 1 ){
            head.next = current;
            if(current.next != null){
                //开启下一轮
                ListNode tail = dfsSwap( head,current.next, k, k );
                if(tail !=null) {
                    tail.next = current;
                    return current;
                }
            }
            return current;
        }

        ListNode node = dfsSwap( head,current.next, step - 1, k );
        if(step == k){
            System.out.println(1);
        }
        if(current.val == 1){
            //回退到原始的位置
            System.out.println(1);
        }
        if(node !=null) {
            node.next = current;
            return current;
        }
        return null;
    }

}
