import java.util.ArrayList;
import java.util.List;

public class CountTreeNodes {

    /**
     * Definition for a binary tree node.*/
     public static class TreeNode {
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
        List<String> nodes = new ArrayList<String>();
        System.out.println( countTreeNodes(root ));
    }

    // Recursive function to find paths from the root node to every leaf node
    public static int countTreeNodes(TreeNode root)
    {
        if(root == null){
            return 0;
        }
        return 1 +  countTreeNodes(root.left ) + countTreeNodes(root.right);

    }
}
