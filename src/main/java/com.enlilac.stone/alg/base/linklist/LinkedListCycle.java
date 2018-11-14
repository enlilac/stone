package com.enlilac.stone.alg.base.linklist;

import com.enlilac.stone.alg.base.Node;
import com.enlilac.stone.alg.base.NodeUtils;

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
    }

}



