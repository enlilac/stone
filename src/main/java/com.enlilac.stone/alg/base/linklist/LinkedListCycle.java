package com.enlilac.stone.alg.base.linklist;

import com.enlilac.stone.alg.base.Node;
import com.enlilac.stone.alg.base.NodeUtils;
import com.sun.tools.javac.util.Assert;

/**
 * 单链表链表操作训练
 * 检测单链表是否有环
 * 原理：利用快慢两个指针，check 相等。
 */
public class LinkedListCycle {


    /**
     * 单链表是否有环
     *
     * @param head
     * @param <T>
     * @return
     */
    public static <T> boolean checkCycle(Node<T> head) {

        if (head == null || head.next == null) {
            return false;
        }

        /**
         * two point : slow, fast
         */
        Node<T> slow = head;
        Node<T> fast = head;
        Node<T> target = null;
        while (true) {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            if (slow == fast) {
                target = slow;
                System.out.println(target.getData());
                return true;
            }
        }
    }

    public static <T extends Comparable> Node<T> merge(Node<T> first, Node<T> second, Node<T> result) {
        Assert.checkNonNull(result);
        Node<T> f = first;
        Node<T> s = second;
        Node<T> r = result;
        Node<T> tmp = r;
        if (f == null && s != null) {
            return s;
        }
        if (f != null && s == null) {
            return f;
        }

        while (f != null && s != null) {
            if (f.getData().compareTo(s.getData()) <= 0) {
                r.next = f;
                f = f.next;
                r = r.next;
                if (f == null) {
                    r.next = s;
                }
            } else {
                r.next = s;
                s = s.next;
                r = r.next;
                if (s == null) {
                    r.next = f;
                }
            }
        }
        return result;
    }

    public static <T> Node<T> copy(Node<T> source, Node<T> target) {
        Node first = source;
        Node result = target;
        while (first != null) {
            result.next = first;
            result = result.next;
            first = first.next;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("null node:");
        Node head = NodeUtils.prepareNull();
        System.out.println(checkCycle(head));

        System.out.println("two cycle node:");
        head = NodeUtils.prepareTwoCycleNode();
        System.out.println(checkCycle(head));

        System.out.println("four cycle node:");
        head = NodeUtils.prepareFourCycleNode();
        System.out.println(checkCycle(head));

        System.out.println("four node:");
        head = NodeUtils.prepareFourNode();
        System.out.println(checkCycle(head));

        Node first = NodeUtils.prepareTwoNode();
        Node second = NodeUtils.prepareFourNode();
        Node result = new Node(-1);
        merge(first, second, result);
        System.out.println(result);
    }

}



