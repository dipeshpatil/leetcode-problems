package Tree.Easy;

import Tree.TreeNode;

public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        SearchInABinarySearchTree o = new SearchInABinarySearchTree();

        TreeNode tree = new TreeNode(
                3,
                new TreeNode(
                        9,
                        new TreeNode(12),
                        new TreeNode(42)
                ),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        o.print(o.searchBST(tree, 20));
        // 20 15 7
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;

        return val < root.val
                ? searchBST(root.left, val)
                : searchBST(root.right, val);
    }

    private void print(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            print(node.left);
            print(node.right);
        }
    }
}

/*
    https://leetcode.com/problems/search-in-a-binary-search-tree/
*/
