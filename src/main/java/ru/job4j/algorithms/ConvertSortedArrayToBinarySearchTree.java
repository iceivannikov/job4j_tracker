package ru.job4j.algorithms;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, l, mid - 1);
        root.right = build(nums, mid + 1, r);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree test = new ConvertSortedArrayToBinarySearchTree();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        System.out.println(test.sortedArrayToBST(nums));
    }

    public static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{"
                    + "val=" + val
                    + ", left=" + left
                    + ", right=" + right
                    + '}';
        }
    }
}
