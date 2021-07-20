package Tree.Construction;

import java.util.*;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

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

    /** Construct Binary Tree from LinkedList */
    public static TreeNode sortedLLToBST(ListNode head) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(head.data);
        q.add(root);
        head = head.next;

        while (head != null) {
            TreeNode parent = q.poll();

            TreeNode leftchild = null, rightchild = null;
            leftchild = new TreeNode(head.data);
            q.add(leftchild);
            head = head.next;
            if (head != null) {
                rightchild = new TreeNode(head.data);
                q.add(rightchild);
                head = head.next;
            }

            parent.left = leftchild;
            parent.right = rightchild;
        }
        return root;
    }

    /**********************************************************************************************************/
    public static TreeNode midPtr(TreeNode head) {
        if (head == null && head.right == null)
            return head;

        TreeNode slow = head, fast = head;
        while (fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }

    /* Doubly LinkedList to Binary Search Tree */
    public static TreeNode SortedDLLToBST(TreeNode head) {
        if (head == null && head.right == null)
            return head;

        TreeNode mid = midPtr(head);
        TreeNode prev = mid.left, next = mid.right;
        mid.left = mid.right = next.left = null;

        if (prev != null)
            prev.right = null;

        TreeNode root = mid;
        TreeNode leftPtr = prev != null ? head : null, rightPtr = next;

        root.left = SortedDLLToBST(leftPtr);
        root.right = SortedDLLToBST(rightPtr);
        return root;
    }

    /************************************************************************************************************/
    /** Convert BST To DLL */
    static TreeNode head, prev = null;

    public static TreeNode bToDLL(TreeNode root) {

        BstToDLL(root);
        return head;
    }

    public static void BstToDLL(TreeNode root) {
        if (root == null)
            return;

        BstToDLL(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        BstToDLL(root.right);
    }

    public static void main(String[] args) {

    }
}
