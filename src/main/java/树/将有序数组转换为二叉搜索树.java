/**
 * Date: 2023-05-14 9:00
 * Author: xupp
 */

package 树;

//搜索树 ，左子树小于父节点 右字数大于父节点  每一个节点的左右子树高度差不超过1
import dto.TreeNode;
public class 将有序数组转换为二叉搜索树 {

    //取根
    public TreeNode recurrence(int[] nums, int left, int right) {
        if (left > right) return null;
        // 除法运算向下取整，所以偶数取左边
        int mid = (left + right) / 2;
        // 取到根节点
        TreeNode root = new TreeNode(nums[mid]);
        // 再判断左右两个树，取哪个根
        root.left = recurrence(nums, left, mid - 1);
        root.right = recurrence(nums, mid + 1, right);
        return root;
    }
}
