package com.ghc.struct;

import com.ghc.tree.Tree;

/**
 * @Date 2023/6/19 /14:35
 * @Author guohc
 * @Description
 */
public class BaseDataStruct {

    //链表节点
    public static class Node{
        private Node next;

        private int data;

        public Node(int data){
            this.data=data;
        }
    }


    //链表反转
    public static Node reverseNode(Node head) {
        if (head == null || head.next == null) return head;
        Node last = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
