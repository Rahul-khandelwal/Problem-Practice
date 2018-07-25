/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.crackingcodinginterview.linkedList;

/**
 * Implement an algorithm to find kth to last element in singly linked list.
 * 
 * @author Rahul
 */
public class KthToLastElementInLinkedList {
    
    private final Node head;

    public KthToLastElementInLinkedList(Node head) {
        this.head = head;
    }
    
    public void print() {
        Node temp = this.head;
        
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
    
    /**
     * This method will return kth to last element.
     * We'll take two pointers and we'll move one pointer in list to kth node.
     * When the fast pointer in on kth node, we'll start moving the slow pointer also,
     * so when fast pointer reaches the end, slow will be on kth to last element.
     * 
     * @param _k
     * 
     * @return Kth to last element.
     */
    public Node kthToLastElement(int _k) {
        if (this.head == null || _k < 1) {
            return null;
        }
        
        Node fast = this.head;
        Node slow = null;
        int steps = 1;
        
        while (fast != null) {
            fast = fast.next;
            
            if (steps >= _k) {
                if (slow == null) {
                    slow = this.head;
                } else {
                    slow = slow.next;
                }
            }
            
            steps++;
        }
        
        return slow;
    }
    
    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static void main(String[] args) {
        Node one = new Node(4);
        Node two = new Node(3);
        Node three = new Node(2);
        Node four = new Node(1);
        Node head = new Node (5);
        
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        
        KthToLastElementInLinkedList kthToLastElement = new KthToLastElementInLinkedList(head);
        System.out.println(kthToLastElement.kthToLastElement(3).data);
    }
}
