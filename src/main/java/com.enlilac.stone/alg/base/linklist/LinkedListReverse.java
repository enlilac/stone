package com.enlilac.stone.alg.base.linklist;

/**
 * 单链表链表操作训练
 */
public class LinkedListReverse {


    /**
     * 逆转单链表
     *
     * @param head
     * @param <T>
     * @return
     */
    public static <T> Node<T> reverse(Node<T> head) {

        if (head == null || head.next == null) {
            return head;
        }

        /**
         * three point : prev,curr,next
         * curr is the result head
         */
        Node<T> prev = null;
        Node<T> curr = head;
        Node<T> next;
        while (true) {
            next = curr.next; // save the next node
            curr.next = prev; // reverse current node
            prev = curr; // prev to current node
            if (next == null) {
                return curr;
            }
            curr = next; // current node to next
        }
    }

    public static void testReverse() {

        Node<Integer> head = null;
        System.out.println(reverse(head));
        head = new Node<Integer>(1);
        System.out.println(reverse(head));
    }

    public static void testReverse2() {

        Node<Integer> head = null;
        head = new Node<Integer>(1);
        Node<Integer> next = new Node<Integer>(2);
        head.next = next;
        System.out.println(reverse(head));
    }

    public static void testReverse3() {

        Node<Integer> head = null;
        head = new Node<Integer>(1);
        Node<Integer> next = new Node<Integer>(2);
        Node<Integer> third = new Node<Integer>(3);
        head.next = next;
        next.next = third;
        System.out.println(reverse(head));
    }

    public static void main(String[] args) {
        testReverse();
        testReverse2();
        testReverse3();
    }


    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Node [");
            sb.append(data);
            sb.append(",");
            while (next != null) {
                sb.append(next.data);
                sb.append(",");
                next = next.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}



