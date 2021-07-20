package Tree.Construction;

import java.util.*;

public class Treversal {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    /** zig zag level order treversal */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                root = q.poll();
                res.add(root.val);
                if (root.left != null)
                    q.add(root.left);
                if (root.right != null)
                    q.add(root.right);
            }
            if (flag)
                Collections.reverse(res);
            flag = flag == false ? true : false;
            ans.add(res);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
