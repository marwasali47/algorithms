import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrintAllTreePaths {

     private static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        // print all root-to-leaf paths
        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<String>();
        printRootToLeafPaths(root , "" ,paths);
        return paths;
    }

    // Function to check if a given node is a leaf node or not
    public static boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    // Recursive function to find paths from the root node to every leaf node
    public static void printRootToLeafPaths(TreeNode node, String path , List<String> paths)
    {
        // base case
        if (node == null) {
            return;
        }

        // include the current node to the path
        path= path + node.val;
        if (!isLeaf(node)) {
            path = path + "->";
        }

        // if a leaf node is found, print the path
        if (isLeaf(node)) {
            paths.add(path);
        }

        // recur for the left and right subtree
        printRootToLeafPaths(node.left, path , paths);
        printRootToLeafPaths(node.right, path, paths);

    }
}
