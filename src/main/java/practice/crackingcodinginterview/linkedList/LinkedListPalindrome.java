/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.crackingcodinginterview.linkedList;

/**
 * Implement a function to check if linked list is palindrome.
 * Here we'll compare first half of the list with reversed second half off the list.
 * If both are same then list is palindrome.
 * 
 * @author Rahul
 */
public class LinkedListPalindrome {

    public boolean isPalindrome(Node _head) {
        HeadAndTail reversed = this.reverse(_head);
        return this.isEqual(_head, reversed.head);
    }

    /**
     * Reverses the complete list.
     * 
     * @param _head
     * 
     * @return 
     */
    HeadAndTail reverse (Node _head) {
        if (_head == null) {
            return null;
        }
        
        HeadAndTail ht = this.reverse(_head.next);
        
        Node clone = _head.clone();
        clone.next = null;
        
        if (ht == null) {
            return new HeadAndTail(clone, clone);
        }
        
        ht.tail.next = clone;
        return new HeadAndTail(ht.head, clone);
    }
    
    boolean isEqual(Node _head, Node _reversedHead) {
        Node head_1 = _head;
        Node head_2 = _reversedHead;
        
        while (head_1 != null && head_2 != null) {
            if (head_1.data != head_2.data) {
                return false;
            }
            
            head_1 = head_1.next;
            head_2 = head_2.next;
        }
        
        return head_1 == null && head_2 == null;
    }
    
    static class HeadAndTail {
        Node head;
        Node tail;

        public HeadAndTail(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    } 
    
    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        
        @Override
        public Node clone() {
            Node clone = new Node(data);
            clone.next = this.next;
            return clone;
        }
    }
    
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(2);
        Node five = new Node(1);
        
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        
        LinkedListPalindrome listPalindrome = new LinkedListPalindrome();
        System.out.println(listPalindrome.isPalindrome(one));
    }
}
