/**
 * Date: 2023-05-12 14:29
 * Author: xupp
 */

package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dto.TreeNode;

public class 二叉树的中序遍历 {

    //todo 可以使用迭代的方式完成这个题目
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
//        search(root,result);

        Stack<TreeNode> stack = new Stack<TreeNode>();
        dd(root,stack,result);
        return result;
    }


    //使用递归算法
    /*public static void df(TreeNode root,List<Integer> result ){
        //开始刷左子树
        if(root == null) return;
        search(root.left,result);
        //先刷当前的节点
        result.add(root.val);
        //开始刷右子树
        search(root.right,result);
    }*/

    //使用迭代算法
    public  static void dd( TreeNode root ,  Stack<TreeNode> stack , List<Integer> result){
        TreeNode p = root;
        while ( p!=null || !stack.isEmpty()){
            if (p!=null) stack.add(p);
            while (p !=null &&  p.left!=null){
                p = p.left;
                stack.add(p);
            }
            p = stack.pop();
            result.add(p.val);
            p = p.right;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);

        right.left = left ;

        root.right =right;
        inorderTraversal(root);
    }


}
