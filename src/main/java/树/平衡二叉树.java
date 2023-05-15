/**
 * Date: 2023-05-15 11:16
 * Author: xupp
 */

package 树;

import dto.TreeNode;
public class 平衡二叉树 {


    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.left)&&isBalanced(root.right);
    }

    public static int search(TreeNode node,int deplen){
        if(node.left == null && node.right == null){
            //判断该节点是不是叶子节点
            return deplen;
        }
        deplen =  deplen+1;
        return  0;
//        return search(node.left)&&search(node.right);
    }

    public static int height(TreeNode root){
        if (root ==null) return 0;

        return 1+Math.max(height(root.left),height(root.right));
    }


    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left  = new TreeNode(2);
        p.right  = new TreeNode(3);
        System.out.println(isBalanced(p));

    }


}
