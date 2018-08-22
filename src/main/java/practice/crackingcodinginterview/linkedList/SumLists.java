/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.crackingcodinginterview.linkedList;

/**
 * You have two numbers represented by a linked list, where each number contains a single digit.
 * The digits are in reverse order, such that the first (least) digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as linked list.
 * 
 * Follow UP: 
 * Repeat the problem when digits are in forward order.
 * 
 * @author Rahul
 */
public class SumLists {
       
    public void print(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
    
    /**
     * Input:
     * (7 -> 1 -> 6) + (5 -> 9 -> 2) that is 617 + 295
     * Output:
     * 2 -> 1 -> 9 that is 912
     * 
     * @param _list_1
     * @param _list_2
     * 
     * @return 
     */
    public Node sumWhenReverseOrder(Node _list_1, Node _list_2) {
        Node head_first = _list_1;
        Node head_second = _list_2;
        
        Node head_sum = null;
        Node curr_sum = null;
        Node carry_forward = null;
        
        while (head_first != null || head_second != null) {
            int sum = 0;
            
            if (head_first != null) {
                sum += head_first.data;
                head_first = head_first.next;
            }
            
            if (head_second != null) {
                sum += head_second.data;
                head_second = head_second.next;
            }
            
            if (carry_forward != null) {
                sum += carry_forward.data;
                carry_forward = null;
            }
            
            Node sumNode;
            
            if (sum <= 9) {
                sumNode = new Node(sum);
            } else {
                sumNode = new Node(sum % 10);
                carry_forward = new Node(sum / 10);
            }
            
            if (head_sum == null) {
                head_sum = sumNode;
                curr_sum = sumNode;
            } else {
                curr_sum.next = sumNode;
                curr_sum = curr_sum.next;
            }
        }
        
        if (carry_forward != null) {
            curr_sum.next = carry_forward;
        }
        
        return head_sum;
    }
    
    /**
     * This class contains sum of two nodes and their carry forward.
     * It will be used to return recursive results when adding list in forward order
     */
    class PartialSum {
        Node sum;
        int carry;
    }
    
    /**
     * Here we are considering that list are in forward order, that means least digit is last node.
     * So sum needs to start from last node. This will be handled by recursion.
     * 
     * But we need to make sure that both list are of same length, so we'll pad the shorter list with zeroes.
     * 
     * As the result of the recursion might return sum and carry forward, we'll create a wrapper class to return both the results.
     * 
     * Example:
     * Input - (6 -> 1 -> 7) + (2 -> 9 -> 5) that is 617 + 295
     * Output - 9 -> 1 -> 2 that is 912
     * 
     * @param _head_1
     * @param _head_2
     * 
     * @return 
     */
    public Node sumWhenForwardOrder(Node _head_1, Node _head_2) {
        int len_1 = this.length(_head_1);
        int len_2 = this.length(_head_2);
        
        if (len_1 < len_2) {
            _head_1 = this.padList(_head_1, len_2 - len_1);
        } else {
            _head_2 = this.padList(_head_2, len_1 - len_2);
        }
        
        PartialSum sum = this.addListRecursive(_head_1, _head_2);
        
        // if no carry value is left over, then return the list
        if (sum.carry == 0) {
            return sum.sum;
        }
        
        Node result = this.insertBefore(sum.sum, sum.carry);
        return result;
    }
    
    PartialSum addListRecursive(Node _head_1, Node _head_2) {
        if (_head_1 == null && _head_2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }
        
        // Add smaller digits recursively (Note both list are now of same size)
        PartialSum sum = this.addListRecursive(_head_1.next, _head_2.next);
        
        // add the carry from last recurive call in current data
        int val = sum.carry + _head_1.data + _head_2.data;
        
        // insert current result before result of last recursive call
        Node full_result = this.insertBefore(sum.sum, val % 10);
        
        // return the  current sum and carry value
        sum.sum = full_result;
        sum.carry = val / 10;
        
        return sum;
    }
    
    public int length(Node _head) {
        Node temp = _head;
        int length = 0;
        
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        
        return length;
    }
    
    Node padList(Node _head, int _len) {
        Node head = _head;
        
        for (int i = 0 ; i < _len ; i++) {
            head = this.insertBefore(head, 0);
        }
        
        return head;
    }
    
    Node insertBefore(Node _head, int data) {
        Node head = new Node(data);
        
        if (_head != null) {
            head.next = _head;
        }
        
        return head;
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
        Node head_2 = new Node(5);
        Node four = new Node(9);
        Node five = new Node(2);
        
        head_1.next = one;
        one.next = two;
        
        head_2.next = four;
        four.next = five;
        
        SumLists sumLists = new SumLists();
        sumLists.print(head_1);
        System.out.println("");
        sumLists.print(head_2);
        Node sum = sumLists.sumWhenReverseOrder(head_1, head_2);
        System.out.println("");
        sumLists.print(sum);
        
        head_1.next = null;
        one.next = head_1;
        two.next = one;
        
        head_2.next = null;
        four.next = head_2;
        five.next = four;
        
        System.out.println("");
        sumLists.print(two);
        System.out.println("");
        sumLists.print(five);
        sum = sumLists.sumWhenForwardOrder(two, five);
        System.out.println("");
        sumLists.print(sum);
    }
}
