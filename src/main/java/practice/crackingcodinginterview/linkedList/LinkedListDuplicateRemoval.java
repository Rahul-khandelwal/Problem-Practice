/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.crackingcodinginterview.linkedList;

import java.util.*;

/**
 * Remove duplicates from unsorted linked list (assume singly)
 * What if use of buffer is not allowed.
 * 
 * @author Rahul
 */
public class LinkedListDuplicateRemoval {
    
    private final Node head;

    public LinkedListDuplicateRemoval(Node head) {
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
     * This method removes duplicate nodes using extra space.
     * Time complexity O(n)
     * Space complexity O(n)
     */
    public void removeDuplicates() {
        if (this.head == null) {
            return;
        }
        
        Set<Integer> vals = new HashSet<>();
        vals.add(this.head.data);
        
        Node temp = this.head;
        
        while (temp.next != null) {
            if (vals.contains(temp.next.data)) {
                temp.next = temp.next.next;
            } else {
                vals.add(temp.next.data);
                temp = temp.next;
            }
        }
    }
    
    /**
     * This method removes duplicate nodes without using extra space.
     * Time complexity O(n^2)
     * space complexity O(1)
     */
    public void removeDuplicatesSpaceEfficient() {
        if (this.head == null) {
            return;
        }
        
        Node temp = this.head;
        
        while (temp != null && temp.next != null) {
            int currVal = temp.data;
            Node runner = temp;
            
            while (runner.next != null) {
                if (currVal == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            
            temp = temp.next;
        }
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
        Node one = new Node(1);
        Node two = new Node(1);
        Node three = new Node(1);
        Node four = new Node(2);
        Node head = new Node (2);
        
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        
        LinkedListDuplicateRemoval listDuplicateRemoval = new LinkedListDuplicateRemoval(head);
        listDuplicateRemoval.print();
        System.out.println("");
        listDuplicateRemoval.removeDuplicatesSpaceEfficient();
        listDuplicateRemoval.print();
    }
}
