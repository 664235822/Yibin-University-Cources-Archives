/**
 * 二叉树的接口
 * 可以有不同的实现类，每个类可以使用不同的存储结构，比如顺序结构、链式结构
 * @author shangyang
 *
 */
public interface BinaryTree {

    /**
     * 是否为空树
     */
    public boolean isEmpty();

    /**
     * 树结点数量
     */
    public int size();

    /**
     * 获取树的高度
     */
    public int getHeight();

    /**
     * 获取叶子结点数量
     */
    public int leafSize();

    /**
     * 单节点数量
     */
    public int singleBranch();

    /**
     * 双节点数量
     */
    public int doubleBranch();

    /**
     * 交换左右结点
     */
    public void swap();

    /**
     * 查询指定值的结点
     * @param value
     * @return
     */
    public Node findKey(Object value);

    /**
     * 前序递归遍历
     */
    public void preOrderTraverse();

    /**
     * 中序递归遍历
     */
    public void inOrderTraverse();

    /**
     * 后序递归遍历
     */
    public void postOrderTraverse();

}