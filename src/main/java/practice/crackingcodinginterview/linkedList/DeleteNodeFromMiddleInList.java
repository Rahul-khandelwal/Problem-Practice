/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.crackingcodinginterview.linkedList;

/**
 * Implement an algorithm to delete any node from middle of the singly linked list (except first and last node),
 * given the access to only that node.
 * 
 * @author Rahul
 */
public class DeleteNodeFromMiddleInList {
    
    private final Node head;

    public DeleteNodeFromMiddleInList(Node head) {
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
     * Copy the content of next node in the node to be deleted.
     * Then set next to next.next
     * 
     * @param _n
     */
    public void deleteNode(Node _n) {
        _n.data = _n.next.data;
        _n.next = _n.next.next;
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
        
        DeleteNodeFromMiddleInList deleteNodeFromMiddleInList = new DeleteNodeFromMiddleInList(head);
        deleteNodeFromMiddleInList.print();
        deleteNodeFromMiddleInList.deleteNode(three);
        System.out.println();
        deleteNodeFromMiddleInList.print();
    }
}
