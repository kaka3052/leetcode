// 236. Lowest Common Ancestor of a Binary Tree
// Medium


// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

// Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]


 

// Example 1:

// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.
// Example 2:

// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// Output: 5
// Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 

// Note:

// All of the nodes' values will be unique.
// p and q are different and both values will exist in the binary tree.

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
    if(root==null) return null;
    if(p==null || q==null)  return null;
    ArrayList<TreeNode> p_path = new ArrayList<TreeNode>();
    ArrayList<TreeNode> q_path = new ArrayList<TreeNode>();
    findPath(root, p, p_path);
    findPath(root, q, q_path);
    int min_len = Math.min(p_path.size(), q_path.size());
    int LCA = 0;
    for(int i=0; i<min_len; i++){
        if(p_path.get(i)==q_path.get(i))
            LCA = i;
    }return p_path.get(LCA);
    
}
public static boolean findPath(TreeNode root, TreeNode n1, List<TreeNode> path){
	if(root == null)
		return false;
	path.add(root);
	if(root == n1)
		return true;
	if(findPath (root.left, n1, path) || findPath(root.right, n1, path))
		return true;
	path.remove(path.size() - 1);
	return false;
}
