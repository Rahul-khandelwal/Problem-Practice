/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.crackingcodinginterview.linkedList;

/**
 * Given two singly linked lists, determine if the two lists intersect.
 * Return the intersecting node.
 * Note that the intersection is defined based on reference, not on value.
 * That is, the same node should be shared by both the lists.
 * Note that after intersection point, both the lists are same.
 * 
 * @author Rahul
 */
public class LinkedListsIntersection {

    /**
     * Run through the lists and get the lengths and tails.
     * If tails are different, there is no intersection.
     * Set two pointers on start on lists.
     * On the longer list, advance the pointer by difference in lengths.
     * traverse each list until the pointers are same.
     * 
     * @param _head_1
     * @param _head_2
     * 
     * @return 
     */
    public Node intersect(Node _head_1, Node _head_2) {
        if (_head_1 == null || _head_2 == null) {
            return null;
        }
        
        // get the tail nodes and sizes
        Result result1 = this.getTailAndSize(_head_1);
        Result result2 = this.getTailAndSize(_head_2);
        
        // if tails are different, there is no intersection
        if (result1.tail != result2.tail) {
            return null;
        }
        
        // set the pointers to start of each list
        Node shorter = result1.length < result2.length ? _head_1 : _head_2;
        Node longer = result1.length < result2.length ? _head_2 : _head_1;
        
        // advance the pointer in longer list by difference in length
        longer = this.getKthNode(longer, Math.abs(result1.length - result2.length));
        
        // move the pointers untill collision
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        
        // return any pointer, both will be null if no collision
        return longer;
    }
    
    Node getKthNode(Node _head, int _k) {
        Node temp = _head;
        
        while (_k > 0 && temp != null) {
            temp = temp.next;
            _k--;
        }
        
        return temp;
    }
    
    Result getTailAndSize(Node _head) {
        if (_head == null) {
            return null;
        }
        
        int length = 0;
        Node temp = _head;
        
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        
        return new Result(temp, length);
    }
    
    class Result {
        Node tail;
        int length;

        public Result(Node tail, int length) {
            this.tail = tail;
            this.length = length;
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
        Node head_1 = new Node (7);
        Node one = new Node(1);
        Node two = new Node(6);
        Node three = new Node(3);
        Node head_2 = new Node(5);
        Node four = new Node(9);
        Node five = new Node(2);
        
        three.next = two;
        
        head_1.next = one;
        one.next = three;
        
        head_2.next = four;
        four.next = five;
        five.next = three;
        
        LinkedListsIntersection intersection = new LinkedListsIntersection();
        System.out.println(intersection.intersect(head_1, head_2).data);
    }
}
