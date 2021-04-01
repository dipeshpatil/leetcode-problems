package Tree.Easy;

import Tree.TreeNode;

public class ConvertSortedArrayIntoBST {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode tree = sortedArrayToBST(nums);
        displayTreeIn(tree);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return buildUpBST(nums, 0, nums.length - 1);
    }

    public static TreeNode buildUpBST(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildUpBST(nums, left, mid - 1);
        node.right = buildUpBST(nums, mid + 1, right);
        return node;
    }

    public static void displayTreeIn(TreeNode node) {
        if (node == null)
            return;

        displayTreeIn(node.left);
        System.out.print(node.val + " ");
        displayTreeIn(node.right);
    }

/*
    Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
    A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
*/
}
