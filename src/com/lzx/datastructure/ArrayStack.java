package com.lzx.datastructure;

import java.util.Arrays;

/**
 * @author laizixiang
 */
public class ArrayStack<E> implements Stack<E> {
    private final int capacity;
    private int top=-1;
    private Object[] elements;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        elements =new Object[capacity];
    }
    public void push(E e){
        if(top== (capacity-1)){
            return;
        }
        top++;
        elements[top]=e;
    }
    public E pop(){
        if(top==-1){
            return null;
        }
        return (E) elements[top];
    }

    @Override
    public E peek() {
        return (E) elements[top];
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            b.append('[').append(i).append("]").append("->").append(elements[i]).append('\n');
        }
        return b.toString();
    }
}
