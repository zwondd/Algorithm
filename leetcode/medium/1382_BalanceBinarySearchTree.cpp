/*
    2023-01-15
    [Leetcode][Medium] 1382. Balance a Binary Search Tree
*/


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
#include <vector>
using namespace std;


// https://youtu.be/FMMDSB6YSLo
class Solution {
public:
    struct TreeNode {
        int val;
        TreeNode *left;
        TreeNode *right;
        TreeNode() : val(0), left(nullptr), right(nullptr) {}
        TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
        TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
    };

    void traverse(vector<TreeNode*>& output, TreeNode* node)
    {
        if ( node == nullptr )
            return;
        traverse(output, node->left);
        output.push_back(node);
        traverse(output, node->right);
    }

    TreeNode* recBuild(const vector<TreeNode*>& nodes, int left, int right)
    {
        if ( left>right )
            return nullptr;

        // int mid = (left+right)/2;  // overflow 가능성 있음
        int mid = left + (right-left) / 2;  // ** overflow 가능성 없음 **
        nodes[mid]->left = recBuild(nodes, left, mid-1);
        nodes[mid]->right = recBuild(nodes, mid+1, right);

        return nodes[mid];
    }

    // 1. array 로 tree 로 가져오기 
    // 2. tree를 balanced binary search tree를 만든다.  
    TreeNode* balanceBST(TreeNode* root) {
        vector<TreeNode*> nodes;
        traverse(nodes, root);

        return recBuild(nodes, 0, int(nodes.size())-1);
    }
};