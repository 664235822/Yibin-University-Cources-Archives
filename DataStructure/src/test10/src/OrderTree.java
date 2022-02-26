public class OrderTree {

    static class Tree {
        int value;
        Tree leftChild;
        Tree rightChild;
    }

    Tree root;

    public OrderTree(int[] values) {
        for (int i = 0; i < values.length; i++) {
            build(root, values[i]);
        }
    }

    void build(Tree root, int value) {
        if (this.root == null) {
            this.root = new Tree();
            this.root.value = value;
            return;
        }
        Tree tree = new Tree();
        tree.value = value;
        if (value < root.value) {
            left(root, tree);
        } else {
            right(root, tree);
        }
    }

    void left(Tree root, Tree tree) {
        if (root.leftChild == null) {
            root.leftChild = tree;
        } else if (tree.value < root.leftChild.value) {
            left(root.leftChild, tree);
        } else {
            right(root.leftChild, tree);
        }
    }

    void right(Tree root, Tree tree) {
        if (root.rightChild == null) {
            root.rightChild = tree;
        } else if (tree.value < root.rightChild.value) {
            left(root.rightChild, tree);
        } else {
            right(root.rightChild, tree);
        }
    }

    public void printTree() {
        printTree(root);
    }

    void printTree(Tree root) {
        if (root != null) {
            printTree(root.rightChild);
            System.out.print(root.value + " ");
            printTree(root.leftChild);
        }
    }

    public static void main(String[] args) {
        OrderTree orderTree = new OrderTree(new int[]{
                10, 44, 8, 22, 77, 6, 99, 10
        });
        orderTree.printTree();
    }
}
