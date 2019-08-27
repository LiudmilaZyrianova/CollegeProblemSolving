//106. Construct Binary Tree from Inorder and Postorder Traversal - M. Given inorder and postorder traversal of a tree, construct the binary tree.
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
                          vector<int>& postorder, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd)
        return NULL;
    int rootValue = postorder[postEnd];
    TreeNode* root = new TreeNode(rootValue);

    int k = 0;
    for (int i = 0; i < inorder.size(); i++) {
        if (inorder[i] == rootValue) {
            k = i;
            break;
        }
    }

    root->left = buildTree(inorder, inStart, k - 1, postorder, postStart, postStart + k - (inStart + 1));
    root->right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k- inStart, postEnd - 1);

    return root;
}

TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
    auto res = buildTree(inorder,0 , inorder.size()-1, postorder, 0, postorder.size()-1);
    return res;
}


int main() {
    vector<int> inorder {9,3,15,20,7};
    vector<int> postorder {9,15,7,20,3};

    TreeNode* tn = buildTree(inorder, postorder);
    delete(tn);

    return 0;
}
