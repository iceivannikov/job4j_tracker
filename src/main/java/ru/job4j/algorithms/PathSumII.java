package ru.job4j.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        int currSum = 0;
        dfs(root, currSum, targetSum, result, path);
        return result;
    }

    private void dfs(TreeNode node, int currSum, int targetSum, List<List<Integer>> result, List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        currSum += node.val;
        if (node.left == null && node.right == null && currSum == targetSum) {
            result.add(new ArrayList<>(path));
        }
        dfs(node.left, currSum, targetSum, result, path);
        dfs(node.right, currSum, targetSum, result, path);
        path.remove(path.size() - 1);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
