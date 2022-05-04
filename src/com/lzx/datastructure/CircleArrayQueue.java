package com.lzx.datastructure;


import java.util.LinkedList;
import java.util.Random;

/**
 * 循环队列<br/>
 * 使用一个计数器记录队列中元素的个数
 * @author laizixiang
 */
public class CircleArrayQueue {

    public static void main(String[] args) {
        CircleArrayQueue r = new CircleArrayQueue();
        Random random = new Random(System.currentTimeMillis());
        System.out.println("----------------------添加数据----------------------");
        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(10, 30);
            r.add(i1);
            System.out.println(r);
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
    private int rear=-1;
    private int size;


    public CircleArrayQueue() {
        this(10);
    }

    public CircleArrayQueue(int capacity) {
        this.capacity = capacity;
        elements = new Integer[capacity];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean add(int element) {
        if (isFull()) {
            System.out.println("注意队列已满！");
            return false;
        }
        rear = (++rear) % capacity;
        elements[rear] = element;
        size++;
        return true;
    }

    public Integer remove() {
        if (isEmpty()) {
            System.out.println("注意队列为空！");
            return null;
        }
        Integer element = elements[front];
        elements[front]=null;
        front = (++front) % capacity;
        size--;
        return element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = front;
        int count = 0;
        while (count != size()) {

            sb.append('[').append(count).append(']').append('-').append('[').append(i).append(']')
                    .append("->").append(elements[i]);
            if (i == front) {
                sb.append("<-front");
            }
            if (i == rear) {
                sb.append("<-rear");
            }
            sb.append('\n');
            count++;
            i++;
            i = i % capacity;

        }

        return sb.toString();
    }
}
