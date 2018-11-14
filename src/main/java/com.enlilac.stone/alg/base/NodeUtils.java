package com.enlilac.stone.alg.base;

public class NodeUtils {


    public static Node prepareNull() {
        return null;
    }

    public static Node prepareSingleNode() {
        return new Node(0, null);
    }

    public static Node prepareTwoNode() {
        Node head = new Node(0);
        Node second = new Node(1);
        head.next = second;
        return head;
    }

    public static Node prepareFourNode() {
        Node head = new Node(0);
        Node second = new Node(1);
        head.next = second;
        Node third = new Node(2);
        second.next = third;
        Node fourth = new Node(3);
        third.next = fourth;
        return head;
    }

    /**
     * 循环两节点
     *
     * @return
     */
    public static Node prepareTwoCycleNode() {
        Node head = new Node(0);
        Node second = new Node(1);
        head.next = second;
        second.next = head;
        return head;
    }

    /**
     * 循环4节点
     *
     * @return
     */
    public static Node prepareFourCycleNode() {
        Node head = new Node(0);
        Node second = new Node(1);
        head.next = second;
        Node third = new Node(2);
        second.next = third;
        Node fourth = new Node(3);
        third.next = fourth;
        fourth.next = head;
        return head;
    }
}
