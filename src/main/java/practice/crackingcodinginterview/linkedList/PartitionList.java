/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.crackingcodinginterview.linkedList;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than x
 * come before all nodes greater than or equal to x.
 * If x is contained within the list, the values of x only need to be after the elements less than x.
 * The partition element x can appear anywhere in the "right partition", it does not need to be appear 
 * between the left and right partition.
 * 
 * @author Rahul
 */
public class PartitionList {
   
    private Node head;

    public PartitionList(Node head) {
        this.head = head;
    }
    
    public void print() {
        Node temp = this.head;
        
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
    
    public void partition_approach_one(int _pivotValue) {
        Node temp = this.head;
        Node pivotNode = null;
        
        if (temp.data < _pivotValue) {
            // set the current pivot node
            pivotNode = temp;
        }
        
        while (temp != null && temp.next != null) {
            
            if (temp.next.data < _pivotValue) {
                Node toShift = temp.next;
                
                temp.next = temp.next.next;
                
                if (pivotNode == null) {
                    pivotNode = toShift;
                    pivotNode.next = this.head;
                } else {
                    toShift.next = pivotNode.next;
                    pivotNode.next = toShift;
                }
                
                continue;
            }
            
            temp = temp.next;
        }
        
        if (pivotNode != null) {
            this.head = pivotNode;
        }
    }
    
    /**
     * In this approach, we'll create two different linked lists: one for elements less than x and one for elements greater than or equal to x.
     * we iterate through the linked list, inserting elements in our lesser or greater list.
     * once we reach the end of the list completing our splitting, we merge the two lists.
     * This approach is mostly "stable" as elements stay in their original order.
     * 
     * @param _pivotValue 
     */
    public void partition_approach_two(int _pivotValue) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        
        Node temp = this.head;

        while (temp != null) {
            Node next = temp.next;
            
            temp.next = null;
            
            if (temp.data < _pivotValue) {
                if (beforeStart == null) {
                    beforeStart = temp;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = temp;
                    beforeEnd = temp;
                }
            } else {
                if (afterStart == null) {
                    afterStart = temp;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = temp;
                    afterEnd = temp;
                }
            }
            
            temp = next;
        }
        
        if (beforeStart == null) {
            this.head = afterStart;
        } else {
            // Merge
            beforeEnd.next = afterStart;
            this.head = beforeStart;
        }
        
    }
    
    /**
     * In this approach, we start a "new" list (using the existing nodes).
     * Elements bigger than the pivot are put at the tail and elements smaller are put at the head.
     * Each time we insert an element, we update either head or tail.
     * 
     * This approach changes the original order.
     * 
     * @param _pivotValue 
     */
    public void partition_approach_three(int _pivotValue) {
        Node start = this.head;
        Node end = this.head;
        
        Node temp = this.head;

        while (temp != null) {
            Node next = temp.next;
            
            temp.next = null;
            
            if (temp.data < _pivotValue) {
                temp.next = start;
                start = temp;
            } else {
                end.next = temp;
                end = temp;
            }
            
            temp = next;
        }
        
        end.next = null;
        this.head = start;
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
        Node head = new Node (3);
        Node one = new Node(5);
        Node two = new Node(8);
        Node three = new Node(5);
        Node four = new Node(10);
        Node five = new Node(2);
        Node six = new Node(1);
        
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        
        PartitionList partitionList = new PartitionList(head);
        partitionList.print();
        partitionList.partition_approach_three(5);
        System.out.println();
        partitionList.print();
    } 
}
