package Tree;

import java.util.*;

public class Implementation {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    TreeNode root;

    Implementation(int val) {
        root = new TreeNode(val);
    }

    Implementation() {
        root = null;
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /** No of leafs */
    public static int size(TreeNode root) {
        if (root == null)
            return 0;
        return size(root.left) + size(root.right) + 1;
    }

    /** Height of Tree */
    public static int height(TreeNode root) {
        if (root == null)
            return -1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    /** Maximum TreeNode */
    public static int maximumTreeNode(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(root.val, Math.max(maximumTreeNode(root.left), maximumTreeNode(root.right)));
    }

    /** Minimum TreeNode */
    public static int minimumTreeNode(TreeNode root) {
        if (root == null)
            return 0;
        return Math.min(root.val, Math.min(maximumTreeNode(root.left), maximumTreeNode(root.right)));
    }

    /** Find a TreeNode in BinaryTree */
    public static boolean find(TreeNode root, int val) {
        if (root == null)
            return false;
        if (root.val == val)
            return true;
        return find(root.left, val) || find(root.right, val);
    }

    /** TreeNode to Root Path */
    public static ArrayList<Integer> TreeNodeToRootPath(TreeNode root, int val) {
        if (root == null)
            return new ArrayList<>();

        if (root.val == val) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(root.val);
            return res;
        }

        ArrayList<Integer> left = TreeNodeToRootPath(root.left, val);
        if (left.size() != 0) { 
            left.add(root.val);
            return left;
        }

        ArrayList<Integer> right = TreeNodeToRootPath(root.right, val);
        if (right.size() != 0) {
            right.add(root.val);
            return right;
        }
        return new ArrayList<>();
    }

    /** 2nd Method */
    public static boolean TreeNodeToRootPath_2(TreeNode root, int val, ArrayList<Integer> res) {
        if (root == null)
            return false;
        if (root.val == val) {
            res.add(root.val);
            return true;
        }

        boolean flag = TreeNodeToRootPath_2(root.left, val, res) || TreeNodeToRootPath_2(root.right, val, res);

        if (flag) {
            res.add(root.val);
        }
        return flag;
    }

    /** TreeNodeToAllLeafPath */
    public static void TreeNodeToAllLeafPath(TreeNode root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> res) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            ArrayList<Integer> base = new ArrayList<>(res);
            base.add(root.val);
            ans.add(base);
            return;
        }

        res.add(root.val);
        TreeNodeToAllLeafPath(root.left, ans, res);
        TreeNodeToAllLeafPath(root.right, ans, res);
        res.remove(res.size() - 1);
    }

    /** PathSum InterviewBit*/
    public static void pathSUM(TreeNode root, int targetSum, int sum, ArrayList<Integer> res,
            ArrayList<ArrayList<Integer>> ans) {
        if (root == null)
            return;

        sum += root.val;

        if (targetSum == sum && (root.left == null && root.right == null)) {
            ArrayList<Integer> base = new ArrayList<>(res);
            base.add(root.val);
            ans.add(base);
            return;
        }

        res.add(root.val);
        pathSUM(root.left, targetSum, sum, res, ans);
        pathSUM(root.right, targetSum, sum, res, ans);

        res.remove(res.size() - 1);
    }


    public static void main(String[] args) {
        Implementation tree = new Implementation(5);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(8);

        tree.root.left.left = new TreeNode(11);
        tree.root.left.right = new TreeNode(2);
        tree.root.left.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(7);

        tree.root.right.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(13);
        tree.root.right.right.right = new TreeNode(1);
        tree.root.right.right.left = new TreeNode(5);

        inorder(tree.root);
        System.out.println();

        preOrder(tree.root);
        System.out.println();

        postOrder(tree.root);

        System.out.println(height(tree.root));
        System.out.println(maximumTreeNode(tree.root));
        System.out.println(minimumTreeNode(tree.root));
        System.out.println(find(tree.root, 40));
        System.out.println(TreeNodeToRootPath_2(tree.root, 40, new ArrayList<>()));

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        // TreeNodeToAllLeafPath(tree.root, ans, res);

        pathSUM(tree.root, 22, 0, res, ans);

    }
}
