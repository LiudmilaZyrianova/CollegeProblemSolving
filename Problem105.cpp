//105. Construct Binary Tree from Preorder and Inorder Traversal - M. Given preorder and inorder traversal of a tree, construct the binary tree.
//Note: You may assume that duplicates do not exist in the tree.
//IMPORTANT FUNCTION: std::distance(vecOfNums.begin(), it);

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

TreeNode* buildTree(vector<int>& inorder, int inStart, int inEnd,
                          vector<int>& preorder, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd)
        return NULL;
    int rootValue = preorder[postStart];
    TreeNode* root = new TreeNode(rootValue);

    int k = 0;
    for (int i = 0; i < inorder.size(); i++) {
        if (inorder[i] == rootValue) {
            k = i;
            break;
        }
    }

    root->left = buildTree(inorder, inStart, k - 1, preorder, postStart + 1, postStart + k  - inStart);
    root->right = buildTree(inorder, k + 1, inEnd, preorder, postStart + k + 1 - inStart, postEnd);

    return root;
}

TreeNode* buildTree(vector<int>& inorder, vector<int>& preorder) {
    auto res = buildTree(inorder,0 , inorder.size()-1, preorder, 0, preorder.size()-1);
    return res;
}

int main() {
    vector<int> inorder {9,3,15,20,7};
    vector<int> preorder {3,9,20,15,7};

    TreeNode* tn = buildTree(inorder, preorder);
    delete(tn);

    return 0;
}
