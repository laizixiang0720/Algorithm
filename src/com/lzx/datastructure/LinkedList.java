package com.lzx.datastructure;


/**
 * @author laizixiang
 */
public class LinkedList<E> {
    public void setHead(Node<E> head) {
        this.head = head;
    }

    private Node<E> head;

    public LinkedList(Node<E> head) {
        this.head = head;
    }

    public LinkedList() {

    }

    public Node<E> getHead() {
        return head;
    }

    public void add(E element) {
        //无头结点为空的情况
        if (head == null) {
            head = new Node<>(element, null);
            return;
        }
        Node<E> pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new Node<>(element, null);
    }

    /**
     * 翻转链表
     *
     * @return 返回一个翻转后的链表，该链表和原来有关联，修改该链表中的数据会影响原链表。
     */
    public LinkedList<E> reverse() {
        Node<E> first;
        Node<E> prv = null;
        Node<E> p = head;
        Node<E> cur = null;
        while (p != null) {
            cur = p;
            p = p.next;
            cur.next = prv;
            prv = cur;
        }
        first = cur;
        return new LinkedList<>(first);
    }

    /**
     * 翻转链表自身
     */
    public void reverseSelf() {

        if (head == null) {
            return;
        }
        Node<E> prv = null;
        Node<E> p = head;
        Node<E> cur = null;
        while (p != null) {
            cur = p;
            p = p.next;
            cur.next = prv;
            prv = cur;
        }
        head = cur;
    }

    /**
     * 找到倒数第n结点
     *
     * @param n 倒数第几个位置
     * @return 返回倒数第n个结点
     */
    public Node<E> findByBackward(int n) {
        Node<E> node = head;
        int i = 0;
        for (Node<E> p = head; p != null; p = p.next) {
            if (i >= n) {
                node = node.next;
            }
            i++;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Node<E> pointer = head; pointer != null; pointer = pointer.next) {
            sb.append(String.format("[%d]->%s\n", count, pointer.element));
            count++;
        }
        return sb.toString();
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
            return "Node{ element=" + element + '}';
        }
    }
}
