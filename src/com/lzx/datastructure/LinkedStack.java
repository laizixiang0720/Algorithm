package com.lzx.datastructure;

/**
 * @author laizixiang
 */
public class LinkedStack<E> implements Stack<E> {
    private Node<E> top = null;

    @Override
    public void push(E e) {
        if (top == null) {
            top = new Node<>(e, null);

        } else {
            top = new Node<>(e, top);
        }

    }

    @Override
    public E pop() {
        if (top == null) {
            return null;
        }
        E e = top.element;
        top = top.next;
        return e;
    }
    public void reverse() {
        if(isEmpty()){
            return;
        }
        Node<E> p = top;
        Node<E> prv=null;
        Node<E> cur=null;
        while(p!=null){
            //保存当前节点
            cur=p;
            //节点后移
            p=p.next;

            cur.next=prv;
            prv=cur;
        }
        top=cur;
    }
    @Override
    public E peek() {
        if(top==null){
            return null;
        }
        return top.element;
    }

    @Override
    public boolean isEmpty() {
        return top==null;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        Node<E> p = top;
        while (p != null) {
            b.append(p.element).append('\n');
            p = p.next;
        }
        return b.toString();
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }


        @Override
        public String toString() {
            return String.valueOf(element);
        }
    }
}
