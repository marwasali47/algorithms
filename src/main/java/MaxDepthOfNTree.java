import java.util.List;

public class MaxDepthOfNTree {


         public class TreeNode {
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

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxDepth(new Node(9)));
    }

    public static int maxDepth(Node root) {

        if (root == null)
            return 0;

        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int currentMax = maxDepth(root.children.get(i));
            if (currentMax > max) max = currentMax;
        }
        return max + 1;

    }

    public static int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        int left =  minDepth(root.left);
        int right = minDepth(root.right);
        int min = Math.min(left,right);
        return 1 + (min > 0 ? min : Math.max(left, right));

    }

    public static  int maxDepthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + Math.max(maxDepthOfBinaryTree(root.left) , maxDepthOfBinaryTree(root.right));

    }
}






