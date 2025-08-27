package ru.job4j.algorithms;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        boolean b = hasPathSum(root.left, targetSum - root.val);
        boolean b1 = hasPathSum(root.right, targetSum - root.val);
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return b || b1;
    }
}
