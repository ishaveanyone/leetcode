/**
 * Date: 2023-05-12 15:27
 * Author: xupp
 */

package 树;


import dto.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 相同的树 {

    public static boolean isSameTree( TreeNode p, TreeNode q ) {

        if( p ==null && q == null ){
            return true;
        }
        if ( ( p == null && q!=null) || ( q == null && p!=null) ){
            return false;
        }
        //分别再去比较左右两个节点
        return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }



    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left  = new TreeNode(2);
        p.right  = new TreeNode(3);


        TreeNode q = new TreeNode(1);
        q.left  = new TreeNode(2);
        q.right  = new TreeNode(3);


        System.out.println(isSameTree(p, q));

    }













}
