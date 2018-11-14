package com.enlilac.stone.alg.base.linklist;

import com.enlilac.stone.alg.base.Node;

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
}



