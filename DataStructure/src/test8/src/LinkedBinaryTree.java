public class LinkedBinaryTree implements BinaryTree {

    private Node root;    // 根结点

    public LinkedBinaryTree() {
    }

    public LinkedBinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {;
        return root == null;
    }

    @Override
    public int size() {
        System.out.println("二叉树结点数量： ");
        return this.size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            // 获取左子树的数量
            int nl = this.size(root.leftChild);
            // 获取右子树的数量
            int nr = this.size(root.rightChild);
            // 返回左子树、右子树size之和并加1
            return nl + nr + 1;
        }
    }

    @Override
    public int getHeight() {
        System.out.println("二叉树的高度是 ：");
        return this.getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            // 获取左子树的高度
            int nl = this.getHeight(root.leftChild);
            // 获取右子树的高度
            int nr = this.getHeight(root.rightChild);
            // 返回左子树、右子树较大高度并加1
            return nl > nr ? nl + 1 : nr + 1;
        }
    }

    @Override
    public int leafSize() {
        System.out.println("二叉树叶子结点数量： ");
        return this.leafSize(root);
    }

    public int leafSize(Node root) {
        if (root != null) {
            if (root.leftChild == null && root.rightChild == null)
                return 1;
            else
                return (leafSize(root.leftChild) + leafSize(root.rightChild));
        }

        return 0;
    }

    @Override
    public int singleBranch() {
        System.out.println("二叉树单结点数量：");
        return this.singleBranch(root);
    }

    private int singleBranch(Node root) {
        if (root == null) {
            return 0;
        } else if ((root.leftChild != null && root.rightChild == null) || (root.leftChild == null && root.rightChild != null)) {
            return singleBranch(root.leftChild) + singleBranch(root.rightChild) + 1;
        } else {
            return singleBranch(root.leftChild) + singleBranch(root.rightChild);
        }
    }

    @Override
    public int doubleBranch() {
        System.out.println("二叉树双结点数量：");
        return this.doubleBranch(root);
    }


    private int doubleBranch(Node root) {
        if (root == null) {
            return 0;
        } else if (root.leftChild != null && root.rightChild != null) {
            return doubleBranch(root.leftChild) + doubleBranch(root.rightChild) + 1;
        } else {
            return doubleBranch(root.leftChild) + doubleBranch(root.rightChild);
        }
    }

    @Override
    public void swap() {
        System.out.println("交换左右结点");
        swap(root);
    }

    private void swap(Node root) {
        if (root != null) {
            swap(root.leftChild);
            swap(root.rightChild);

            Node temp = root.leftChild;
            root.leftChild = root.rightChild;
            root.rightChild = temp;
        }
    }

    @Override
    public Node findKey(Object value) {
        return this.findKey(value, root);
    }

    private Node findKey(Object value, Node root) {
        // 结点为空，可能是整个树的根结点，也可能是递归调用中叶子结点中左孩子和右孩子
        if (root == null) {
            return null;
        } else if (root != null && root.value == value) {
            return root;
        } else {    // 递归体
            Node leftnode = this.findKey(value, root.leftChild);
            Node rightnode = this.findKey(value, root.rightChild);
            if (leftnode != null && leftnode.value == value) {
                return leftnode;
            } else if (rightnode != null && rightnode.value == value) {
                return rightnode;
            } else {
                return null;
            }
        }
    }

    @Override
    public void preOrderTraverse() {
        System.out.println("先序遍历");
        this.preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(Node root){
        // 输出根结点的值
        if (root != null) {
            System.out.print(root.value + "  ");
            preOrderTraverse(root.leftChild);
            preOrderTraverse(root.rightChild);
        }
    }

    @Override
    public void inOrderTraverse() {
        System.out.println("中序遍历");
        this.inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(Node root) {
        if (root != null) {
            // 遍历左子树
            this.inOrderTraverse(root.leftChild);
            // 输出根的值
            System.out.print(root.value + "  ");
            // 遍历右子树
            this.inOrderTraverse(root.rightChild);
        }
    }

    @Override
    public void postOrderTraverse() {
        System.out.println("后序遍历");
        this.postOrderTraverse(root);
        System.out.println();
    }

    private void postOrderTraverse(Node root) {
        if (root != null) {
            // 遍历左子树
            this.postOrderTraverse(root.leftChild);
            // 遍历右子树
            this.postOrderTraverse(root.rightChild);
            // 输出根的值
            System.out.print(root.value + "  ");
        }
    }


}