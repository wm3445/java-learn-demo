package datastructure;


/**
 * @author wangmeng
 */
public class TableStack<T> implements Stack<T> {

    /**
     * 栈数组
     */
    private T[] table;
    /**
     * 栈顶
     */
    private int top;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 栈内数据大小
     */
    private int size;

    public TableStack() {
        this.top = -1;
        this.capacity = 10;
        this.size = 0;
        this.table = (T[]) new Object[this.capacity];
    }

    public TableStack(int capacity){
        this.top = -1;
        this.capacity = capacity;
        this.size = 0;
        this.table = (T[]) new Object[this.capacity];
    }

    @Override
    public void push(T t) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
