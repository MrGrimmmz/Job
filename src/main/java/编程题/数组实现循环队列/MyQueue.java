package 编程题.数组实现循环队列;

/**
 * @author LIFAN
 * 2019/4/4 13:58
 */
public class MyQueue {
    /**
     * 队列管道，当管道中存放的数据大于队列的长度时将不会再offer数据，直至从队列中poll数据后
     */
    private Object[] queue;
    //队列的头部，获取数据时总是从头部获取
    private int head;
    //队列尾部，push数据时总是从尾部添加
    private int tail;
    //队列长度
    private int size;
    //数组中能存放数据的最大容量
    private final static int MAX_CAPACITY = 1<<30;
    //数组长度
    private int capacity;
    //最大下标
    private int maxIndex;

    public MyQueue(int initialCapacity){
        if (initialCapacity > MAX_CAPACITY)
            throw new OutOfMemoryError("initialCapacity too large");
        if (initialCapacity <= 0)
            throw new IndexOutOfBoundsException("initialCapacity must be more than zero");
        queue = new Object[initialCapacity];
        capacity = initialCapacity;
        maxIndex = initialCapacity - 1;
        head = tail = -1;
        size = 0;
    }
    public MyQueue(){
        queue = new Object[16];
        capacity = 16;
        head = tail = -1;
        size = 0;
        maxIndex = 15;
    }

    /**
     * 往队列尾部添加数据
     * @param object 数据
     * 添加数据时，首先判断队列的长度是否超出了数组的长度，如果超出了就添加失败
     * （也可以设置成等待，等到有人消费了队列里的数据，然后再添加进去）。
     * 都是从队列的尾部添加数据的，添加完数据后tail指针也会相应自增1
     */
    public void offer(Object object){
        if (size >= capacity){
            System.out.println("queue's size more than or equal to array's capacity");
            return;
        }
        if (++tail > maxIndex){
            tail = 0;
        }
        queue[tail] = object;
        size++;
    }

    /**
     * 从队列头部拉出数据
     * @return 返回队列的第一个数据
     * 拉取数据是从队列头部拉取的，拉取完之后将该元素删除，队列的长度减一，head自增1。
     */
    public Object poll(){
        if (size <= 0){
            System.out.println("the queue is null");
            return null;
        }
        if (++head > maxIndex){
            head = 0;
        }
        size--;
        Object old = queue[head];
        queue[head] = null;
        return old;
    }

    /**
     * 查看第一个数据
     * @return
     */
    public Object peek(){
        return queue[head];
    }

    /**
     * 队列中存储的数据量
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 清空队列
     */
    public void clear(){
        for (int i = 0; i < queue.length; i++) {
            queue[i] = null;
        }
        tail = head = -1;
        size = 0;
    }

    @Override
    public String toString() {
        if (size <= 0) return "{}";
        StringBuilder builder = new StringBuilder(size + 8);
        builder.append("{");
        int h = head;
        int count = 0;
        while (count < size){
            if (++h > maxIndex) h = 0;
            builder.append(queue[h]);
            builder.append(", ");
            count++;
        }
        return builder.substring(0,builder.length()-2) + "}";
    }

}
