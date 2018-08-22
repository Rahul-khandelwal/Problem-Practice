/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.geeksforgeeks.easy;

/**
 * Given a singly linked list of integers, Your task is to complete a function that returns true if the given list is palindrome, else returns false.
 * 
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700391
 * 
 * @author Rahul
 */
public class CheckLinkedListPalindrome {
    
    boolean isPalindrome(Node head) 
    {
        if (head == null || head.next == null) {
            return true;
        }
        
        // Get to the middle  of the list
        Node slow = head;
        Node fast = head;
        Node prev_slow = null;
        
        while (fast != null && fast.next != null) {
            prev_slow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // now prev_slow pointer is the end point of first half for both odd and even length list
        // If list is odd size, then fast pointer will be non null
        // use this to get secondHalf start point and save the pointer to middle element in odd
        // size list
        Node middle = null;
        if (fast != null) {
            middle = slow;
            slow = slow.next;
        }
        
        // now slow pointer is the begin of second half
        // terminate the first half
        prev_slow.next = null;
        
        slow = reverse(slow);
        
        // compare the lists
        boolean palindrome = this.compareList(head, slow);
        
        slow = reverse(slow);
        
        if (middle != null) {
            prev_slow.next = middle;
            prev_slow = middle;
        }
        
        prev_slow.next = slow;
        
        return palindrome;
    }    
    
    private Node reverse(Node _secondHalf) {
        Node prev = null;
        Node curr = _secondHalf;
        Node next;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev; // pointer to the start of second half
    }
    
    private boolean compareList(Node _head_1, Node _head_2) {
        Node temp_1 = _head_1;
        Node temp_2 = _head_2;
        
        while (temp_1 != null && temp_2 != null) {
            if (temp_1.data == temp_2.data) {
                temp_1 = temp_1.next;
                temp_2 = temp_2.next;
            } else {
                return false;
            }
        }
        
        if (temp_1 == null || temp_2 == null) {
            return true;
        }
        
        return false;
    }
}

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
