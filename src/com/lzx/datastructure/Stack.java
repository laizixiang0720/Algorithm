package com.lzx.datastructure;

/**
 * @author laizixiang
 */
public interface Stack<E> {
   void push(E e);
   E pop();
   E peek();
   boolean isEmpty();
}
