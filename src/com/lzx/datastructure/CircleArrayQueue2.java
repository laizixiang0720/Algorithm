package com.lzx.datastructure;


import java.util.Random;

/**
 * 循环队列<br/>
 * 浪费一个存储空间，令队列满足特征为front=(rear+1)%capacity
 *
 * @author laizixiang
 */
public class CircleArrayQueue2 {

    public static void main(String[] args) {
        CircleArrayQueue2 r = new CircleArrayQueue2(10);
        Random random = new Random(System.currentTimeMillis());
        System.out.println("----------------------添加数据----------------------");
        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(10, 30);
            r.add(i1);
            System.out.printf("--------------------第%d次--------------------\n",i);
            r.showQueue();
        }
        System.out.printf("\n当前数据量%d\n", r.size());
        System.out.printf("移除数据%d\n", r.remove());
        System.out.printf("移除数据%d\n", r.remove());
        System.out.printf("是否满：%s\n", r.isFull());

        r.add(12);
        r.add(13);
        System.out.println(r);
        for (int i = 0; i < 10; i++) {
            System.out.printf("移除数据%d\n", r.remove());
        }
        System.out.printf("是否满：%s\n", r.isFull());
        System.out.println(r);
    }

    /**
     * 队列容量
     */
    private final int capacity;
    private final Integer[] elements;

    private int front;
    private int rear;


    public CircleArrayQueue2() {
        this(10);
    }

    public CircleArrayQueue2(int capacity) {
        this.capacity = capacity;
        elements = new Integer[this.capacity];
    }

    public boolean isFull() {
        return front == (rear + 1) % capacity;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int size() {
        return (rear + capacity - front) % capacity;
    }

    public boolean add(int element) {
        if (isFull()) {
            System.out.println("注意队列已满！");
            return false;
        }
        elements[rear] = element;
        rear = (++rear) % capacity;
        return true;
    }

    public Integer remove() {
        if (isEmpty()) {
            System.out.println("注意队列为空！");
            return null;
        }
        Integer element = elements[front];
        elements[front] = null;
        front = (++front) % capacity;
        return element;
    }

    public void showQueue() {
        for (int i = 0; i < elements.length; i++) {
            if (i == front) {
                System.out.printf("[%d]-%d <- front\n", i, elements[i]);
            } else if (i == rear) {
                System.out.printf("[%d]-%d <- rear\n", i, elements[i]);
            } else {
                System.out.printf("[%d]-%d\n", i, elements[i]);
            }

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        int j = front;
        for (int i = 0; i < size + 1; i++) {
            sb.append('[').append(i).append(']').append('-').append('[').append(i % capacity).append(']')
                    .append("->").append(elements[i % capacity]);
            if (i == front) {
                sb.append("<-front");
            }
            if (i == rear) {
                sb.append("<-rear");
            }
            sb.append('\n');
            j = (++j) % capacity;
        }

        return sb.toString();
    }
}
