package datastructure;

/**
 * @author wangmeng
 */
public interface Stack<T> {


    /**
     * 入栈
     *
     * @param t
     */
    void push(T t);

    /**
     * 删除元素出栈
     *
     * @return
     */
    T pop();

    /**
     * 不删除元素出栈
     *
     * @return
     */
    T peek();

    /**
     * 是否为null栈
     *
     * @return
     */
    boolean isEmpty();


}
