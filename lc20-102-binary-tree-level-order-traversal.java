// 102. Binary Tree Level Order Traversal
// Medium

// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    ArrayList resultList = new ArrayList();
    int level = 0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return resultList;
        addNode(level, root);
        return resultList;
    }
    
    public void addNode(int level, TreeNode node){
        if (node == null)
            return;
        
        ArrayList levelList = null;
        //判断当前level对应的list是否已经存在，如果不存在则创建
        if(resultList.size() <= level){
            levelList = new ArrayList();
            resultList.add(levelList);
        }else{
            levelList = (ArrayList)resultList.get(level);
        }
            
        levelList.add(node.val);   
        
        if (node.left == null && node.right == null)
            return;
        level = level+1;
        addNode(level, node.left);
        addNode(level, node.right);

    }
}