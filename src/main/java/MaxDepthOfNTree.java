import java.util.List;

public class MaxDepthOfNTree {

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
}






