package Tree.Construction;

public class ConstructionBST {
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

    public static TreeNode sortedArrayToBST(int[] nums) {
        return BST(0, nums.length - 1, nums);
    }

    public static TreeNode BST(int si, int ei, int[] nums) {
        if (si > ei)
            return null;
        int mid = (si + ei) / 2;
        TreeNode root = new TreeNode(nums[mid], null, null);

        root.left = BST(si, mid - 1, nums);
        root.right = BST(mid + 1, ei, nums);

        return root;
    }
    public static void main(String[] args) {
        
    }
}
