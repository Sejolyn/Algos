package bst;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * 二叉搜索树（Binary Search Tree）接口。
 *
 * @param <E> 元素类型
 */
public interface BST<E> {

    /** 插入（若 key 已存在，选择覆盖）。 */
    void put(E key);

    /** 查询 key 是否在树中。 */
    boolean contains(E key);

    /** 删除一个 key（若不存在则无操作）。 */
    void remove(E key);

    /** 返回最小键（如果为空返回 Optional.empty()）。 */
    Optional<E> min();

    /** 返回最大键（如果为空返回 Optional.empty()）。 */
    Optional<E> max();

    /** 返回不大于给定 key 的最大键（floor）。 */
    Optional<E> floor(E key);

    /** 返回不小于给定 key 的最小键（ceil）。 */
    Optional<E> ceil(E key);

    /** 元素个数。 */
    int size();

    /** 是否为空。 */
    default boolean isEmpty() { return size() == 0; }

    /** 树高度（空树高度为 -1，只有根结点为 0）。 */
    int height();

    /** 清空。 */
    void clear();

    /** 中序遍历（升序）。 */
    void inorder(Consumer<E> action);

    /** 先序遍历。 */
    void preorder(Consumer<E> action);

    /** 后序遍历。 */
    void postorder(Consumer<E> action);

    /** 层序遍历（BFS）。 */
    void levelOrder(Consumer<E> action);

    /** 返回比较器（null 表示使用元素的自然顺序）。 */
    Comparator<? super E> comparator();

    /** 验证 BST 性质是否成立。 */
    boolean isValidBST();
}

