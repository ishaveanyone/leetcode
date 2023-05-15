/**
 * Date: 2023-05-12 17:55
 * Author: xupp
 */

package 树;

import dto.TreeNode;

public class 二叉树的最大深度 {

    public static int maxDepth(TreeNode root) {
        if(root == null )return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }




    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left  = new TreeNode(2);
        p.right  = new TreeNode(3);
        System.out.println(maxDepth(p));

    }

}
