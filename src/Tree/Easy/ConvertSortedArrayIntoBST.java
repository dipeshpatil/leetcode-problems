package Tree.Easy;

import Tree.TreeNode;

public class ConvertSortedArrayIntoBST {
    public static void main(String[] args) {
        ConvertSortedArrayIntoBST o = new ConvertSortedArrayIntoBST();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode tree = o.sortedArrayToBST(nums);
        o.displayTreeIn(tree);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return buildUpBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildUpBST(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildUpBST(nums, left, mid - 1);
        node.right = buildUpBST(nums, mid + 1, right);
        return node;
    }

    private void displayTreeIn(TreeNode node) {
        if (node == null)
            return;

        displayTreeIn(node.left);
        System.out.print(node.val + " ");
        displayTreeIn(node.right);
    }
}

/*
    https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
*/
