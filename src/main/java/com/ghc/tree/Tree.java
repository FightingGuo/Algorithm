package com.ghc.tree;

import java.util.Stack;
import java.util.TreeMap;

/**
 * @Date 2023/6/15 /17:21
 * @Author guohc
 * @Description
 */
public class Tree {

    //树结构
    public static class Node {
        private Node right;
        private Node left;
        private int data;

        public Node(int data){
            this.data=data;
        }
    }

    //递归遍历树
    //前序
    public static void preOrderRecur(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.data+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }


    //中序
    public static void inOrderRecur(Node head){
        if (head == null){
            return;
        }
        preOrderRecur(head.left);
        System.out.println(head.data+" ");
        preOrderRecur(head.right);
    }

    //后序
    public static void posOrderRecur(Node head){
        if (head == null){
            return;
        }
        preOrderRecur(head.left);
        preOrderRecur(head.right);
        System.out.println(head.data+" ");
    }

    //迭代遍历树
    //前序
    public static void preOrderUnRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();//返回栈顶元素 并删除
                System.out.println(head.data + " ");
                if (head.right != null) stack.push(head.right);
                if (head.left != null) stack.push(head.left);
            }
        }
    }


    //中序
    public static void inOrderUnRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head!=null){
                if (head!=null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(stack.pop().data + " ");
                    head = head.right;
                }
            }
        }
    }



    //后序
    public static void posOrderUnRecur1(Node head){
        if (head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.add(head);
            Node temp = null;
            while (!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if (head.left!=null){
                    stack1.push(head.left);
                }
                if (head.right!=null){
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()){
                System.out.println(stack2.pop().data + " ");
            }
        }
    }


    //后序
    public static void posOrderUnRecur2(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            Node temp = null;
            while (!stack.isEmpty()){
                temp = stack.peek();
                if (temp.left!=null && head!=temp.left && head!=head.right){
                    stack.push(temp.left);
                } else if (temp.left!=null && head!=temp.right) {
                    stack.push(temp.right);
                }else {
                    System.out.println(stack.pop().data + " ");
                    head = temp;
                }
            }
        }
    }





}