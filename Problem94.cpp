//94. Binary Tree Inorder Traversal - M. Given a binary tree, return the inorder traversal of its nodes' values.

#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
#include <unordered_map>
#include <algorithm>
#include <cmath>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void print(vector<int> nums1 ) {
    for (int e : nums1){
        cout << e << " ";
    }
    cout << "\n";
}

void recursiveFilling(vector<int>& res, TreeNode* root) {
    if (root->left != NULL) recursiveFilling(res, root->left);
    res.push_back(root->val);
    if (root->right != NULL) recursiveFilling(res, root->right);
}

vector<int> inorderTraversal(TreeNode* root){
    vector<int> res;
    if (root == NULL)  return res;
    recursiveFilling(res, root);
    return res;
}

int main() {

    TreeNode* t1 = new TreeNode(1);
    TreeNode* t2 = new TreeNode(2);
    TreeNode* t3 = new TreeNode(3);
    t1->right = t2;
    t2->left = t3;
    print(inorderTraversal(t1));
    delete(t1);
    delete(t2);
    delete(t3);

    return 0;
}
