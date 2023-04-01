package 递归;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2023-03-30 9:50
 * Author: xupp
 */

/**
 *  这道题的算法其实并不难，
 *  主要的考察点还是递归函数的，方法入栈出栈的时候，形参会还原，我一直都把形参在递归调用中理解成最后一次对
 *  形参的修改作为最终的结果，其实应该将最终需要的结果返回
 *
 *
 *
 */
public class K个一组翻转链表 {
    public static class ListNode {
        public  int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        ListNode pointer = new ListNode();
        if(k ==1 ){
            return head;
        }
        pointer =  dfsSwap(pointer,tail,null,head,head.next,k,k);
        return pointer;
    }


    public static void main(String[] args) {
        ListNode l1  = new ListNode(1);
        ListNode l2  = new ListNode(2);
        ListNode l3  = new ListNode(3);
        ListNode l4  = new ListNode(4);
        ListNode l5  = new ListNode(5);
        ListNode l6  = new ListNode(6);
        ListNode l7  = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode l =   reverseKGroup(l1,3);
        System.out.println(1);

    }

    /**
     * 三指针
     * @param head
     * @param pre
     * @param current
     * @return
     */

    public static ListNode dfsSwap (  ListNode pointer,ListNode tail,ListNode pre,ListNode current,ListNode next,int k ,int step){

        tail = current;
        //先尝试搜索路径
        ListNode tmp = current;
        int tmpD = step;
        do{
            tmp =tmp.next;
            tmpD--;
        }while (tmp!=null);
        if(tmpD>0){
            return current;
        }
        while (step>0 && current!=null ) {
            current.next = pre;
            pre = current;
            current = next;
            if( next == null){
                break;
            }
            next = next.next;
            step--;
            if(step==1){
                pointer = current;
            }
        }
        if(current !=null){
            ListNode head =   dfsSwap(pointer,tail,null,current,current.next ,k,k);
            tail.next = head;
            return pointer;
        }else{
            return pointer;
        }
    }

}
