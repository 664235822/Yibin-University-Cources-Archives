public class Main {

    public static void main(String[] args) {
        // 创建一个二叉树
        Node nodeF = new Node("F", null, null);
        Node nodeE = new Node("E", null, null);
        Node nodeD = new Node("D", null, null);
        Node nodeC = new Node("C", nodeF, null);
        Node nodeB = new Node("B", nodeD, nodeE);
        Node nodeA = new Node("A", nodeB, nodeC);

        BinaryTree binaryTree = new LinkedBinaryTree(nodeA);

        System.out.println(binaryTree.size());
        System.out.println(binaryTree.getHeight());
        System.out.println(binaryTree.leafSize());
        System.out.println(binaryTree.singleBranch());
        System.out.println(binaryTree.doubleBranch());
        System.out.println(binaryTree.findKey(nodeC));

        binaryTree.preOrderTraverse();
        binaryTree.inOrderTraverse();
        binaryTree.postOrderTraverse();

        binaryTree.swap();

        binaryTree.preOrderTraverse();
        binaryTree.inOrderTraverse();
        binaryTree.postOrderTraverse();
    }
}
