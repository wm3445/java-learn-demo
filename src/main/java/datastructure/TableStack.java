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
        this.capacity = 10;
        this.top = -1;
        this.size = 0;
        this.table = (T[]) new Object[this.capacity];
    }

    public TableStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.size = 0;
        this.table = (T[]) new Object[this.capacity];
    }

    @Override
    public void push(T t) {
        if (size >= capacity) {
            throw new RuntimeException("栈容量已满");
        }
        table[++top] = t;
        size++;
    }

    @Override
    public T pop() {
        if (size == 0) {
            return null;
        }
        T[] tab = table;
        T t = tab[top];
        tab[top] = null;
        top--;
        size--;
        return t;
    }

    @Override
    public T peek() {
        T[] tab = table;
        return tab[top];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : table) {
            sb.append(t).append(",");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new TableStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        // stack.push(6);
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.toString());
        System.out.println(stack.peek());
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("-=-=-=-=-=-=-=-=-=-=----=-=-=");
        String str = "((2-3) + (5-1)) + 1";
        System.out.println(calculator(str));

    }

    private static int calculator(String str) {
        String trim = str.trim().replace(" ", "");
        Stack<String> cal = new TableStack<>(20);
        Stack<String> symbol = new TableStack<>(20);
        String fuhao;
        for (char c : trim.toCharArray()) {
            String cc = c + "";
            if (")".equals(cc)) {
                fuhao = symbol.pop();
                counter(fuhao, cal);
            } else {
                if (!"(".equals(cc)) {

                    try {
                        Integer.parseInt(cc);
                        cal.push(cc);
                    } catch (NumberFormatException e) {
                        symbol.push(cc);

                    }
                }
            }
        }
        fuhao = symbol.pop();
        counter(fuhao, cal);
        return Integer.valueOf(cal.peek());
    }

    private static void counter(String fuhao, Stack<String> num) {
        String f, s;
        int r;
        switch (fuhao.toCharArray()[0]) {
            case '+':
                f = num.pop();
                s = num.pop();
                r = Integer.valueOf(f == null ? "0" : f) + Integer.valueOf(s == null ? "0" : s);
                num.push(r + "");
                break;
            case '-':
                f = num.pop();
                s = num.pop();
                r = Integer.valueOf(s == null ? "0" : s) - Integer.valueOf(f == null ? "0" : f);
                num.push(r + "");
                break;
            case '*':
                f = num.pop();
                s = num.pop();
                r = Integer.valueOf(f == null ? "0" : f) * Integer.valueOf(s == null ? "0" : s);
                num.push(r + "");
                break;
            case '/':
                f = num.pop();
                s = num.pop();
                r = Integer.valueOf(s == null ? "0" : s) / Integer.valueOf(f == null ? "0" : f);
                num.push(r + "");
                break;
            default:
        }
    }
}
