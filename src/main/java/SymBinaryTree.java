
class ANode {
    int key;
    ANode left, right;

    ANode(int item){
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    ANode root;

    boolean isMirror(ANode ANode1, ANode ANode2) {
        if (ANode1 == null && ANode2 == null)
            return true;

        if (ANode1 != null && ANode2 != null
                && ANode1.key == ANode2.key)
            return (isMirror(ANode1.left, ANode2.right)
                    && isMirror(ANode1.right, ANode2.left));

        return false;
    }

    boolean isSymmetric() {
        return isMirror(root, root);
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new ANode(1);
        tree.root.left = new ANode(2);
        tree.root.right = new ANode(2);
        tree.root.left.left = new ANode(3);
        tree.root.left.right = new ANode(4);
        tree.root.right.left = new ANode(4);
        tree.root.right.right = new ANode(5);
        System.out.println("isSymmetric " + tree.isSymmetric());
    }
}
