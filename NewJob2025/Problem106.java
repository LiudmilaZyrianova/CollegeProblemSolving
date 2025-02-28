// 106. Construct Binary Tree from Inorder and Postorder Traversal

class Solution {
    public int findPos(int[] inorder, int inL, int inR, int val) {
        for (int i = inL; i <= inR; i++) {
            if (inorder[i] == val) return i;
        }

        return -1;
    }

    public TreeNode getRoot(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR) {
        TreeNode currRoot = new TreeNode(postorder[postR]);
        if (postL == postR) return currRoot;

        int rootPos = findPos(inorder, inL, inR, postorder[postR]);

        if (rootPos > inL) {
            currRoot.left = getRoot(inorder, inL, rootPos - 1, postorder, postL, postL + (rootPos - inL - 1));
        }

        if (rootPos < inR) {
            currRoot.right = getRoot(inorder, rootPos + 1, inR, postorder, postR - (inR-rootPos), postR - 1);
        }

        return currRoot;
        
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return getRoot(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
}
