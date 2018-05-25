/*
 * this is the geeks for geeks solution.
 */
class Node 
{
    int key;
    Node left, right;
  
    public Node(int key) 
    {
        this.key = key;
        left = right = null;
    }
}
  
/* Class Res created to implement pass by reference
   of 'res' variable */
class Res 
{
    int r = Integer.MIN_VALUE;
}
  
public class FindMaximumDifference2 
{
    Node root;
  
    /* Recursive function to calculate maximum ancestor-node
       difference in  binary tree. It updates value at 'res'
       to store the result.  The returned value of this function
       is minimum value in subtree rooted with 't' */
    int maxDiffUtil(Node t, Res res) 
    {
        /* Returning Maximum int value if node is not
           there (one child case)  */
        if (t == null)
            return Integer.MAX_VALUE;
          
        /* If leaf node then just return node's value  */
        if (t.left == null && t.right == null)
            return t.key;
  
        /* Recursively calling left and right subtree
           for minimum value  */
        int val = Math.min(maxDiffUtil(t.left, res),
                maxDiffUtil(t.right, res));
  
        /* Updating res if (node value - minimum value
           from subtree) is bigger than res  */
        res.r = Math.max(res.r, t.key - val);
  
        /* Returning minimum value got so far */
        return Math.min(val, t.key);
    }
  
    /* This function mainly calls maxDiffUtil() */
    int maxDiff(Node root) 
    {
        // Initialising result with minimum int value
        Res res = new Res();
        maxDiffUtil(root, res);
  
        return res.r;
    }
  
    /* Helper function to print inorder traversal of
       binary tree   */
    void inorder(Node root) 
    {
        if (root != null) 
        {
            inorder(root.left);
            System.out.print(root.key + "");
            inorder(root.right);
        }
    }
  
    // Driver program to test the above functions
    public static void main(String[] args) 
    {
        FindMaximumDifference2 tree = new FindMaximumDifference2();
  
        // Making above given diagram's binary tree
        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(7);
  
        tree.root.right = new Node(10);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);
  
        System.out.println("Maximum difference between a node and"
                + " its ancestor is : " + tree.maxDiff(tree.root));
    }
}
