/**
 * Date: 2023-05-12 17:47
 * Author: xupp
 */

package 树;


import dto.TreeNode;

public class 对称二叉树 {


    public boolean isSymmetric(TreeNode root) {

        TreeNode p = root.left;
        TreeNode q = root.right;

        return  compare(p,q);
    }
    //对称就是
    public static boolean compare(TreeNode p,TreeNode q){
        if(p== null && q==null){
            return true;
        }
        if((p==null && q!=null) || (p!=null &&q==null)){
            return false;
        }
        return p.val==q.val&&compare(p.left,q.right)&&compare(p.right,q.left);
    }
}
