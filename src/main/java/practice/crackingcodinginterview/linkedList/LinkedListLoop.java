/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.crackingcodinginterview.linkedList;

/**
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * Example:
 * a -> b -> c -> d -> e -> c
 * Output: c
 * 
 * @author Rahul
 */
public class LinkedListLoop {
    
    /**
     * Algorithm:
     * 1. Create two pointers, fastPointer and slowPointer.
     * 2. Move fastPointer at rate of two steps and slowPointer at rate of one step.
     * 3. When they collide (their collision indicates that we have a loop), move slowPointer to head and keep fastPointer where it is.
     * 4. Move slowPoiner and fastPointer at rate of one step, there new collision point will be start of the loop.
     * 
     * @param _head
     * 
     * @return 
     */
    public Node beginningOfLoop(Node _head) {
        Node slow = _head;
        Node fast = _head;
        
        /**
         * Find meeting point, this will be LOOP_SIZE - k steps into the list.
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) { // collision
                break;
            }
        }
        
        /**
         * Error check, no meeting point, therefor no loop
         */
        if (fast == null || fast.next == null) {
            return null;
        }
        
        /**
         * Move slow to head and keep fast at meeting point.
         * Each are then k steps away from the loop start point.
         * If they move at same pace, they will meet at loop start point.
         */
        slow = _head;
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        /**
         * Both now point to the start of the loop.
         */
        return fast;
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
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = three;
        
        LinkedListLoop listLoop = new LinkedListLoop();
        System.out.println(listLoop.beginningOfLoop(one).data);
    }
}
