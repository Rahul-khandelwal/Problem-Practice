/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.problemsolving.stack;

import java.util.*;

/**
 * Design a Data Stack that supports all the stack operations like push(), pop(), isEmpty(), isFull() 
 * and an additional operation getMin() which should return minimum element from the Special Stack. 
 * All these operations of SpecialStack must be O(1). 
 * To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays, list, .. etc.
 * 
 * Example: 
 * Consider the following Special Stack 
 * 16  --> TOP
 * 15
 * 29
 * 19
 * 18
 * 
 * When getMin() is called it should return 15, which is the minimum 
 * element in the current stack. 
 * 
 * If we do pop two times on stack, the stack becomes
 * 29  --> TOP
 * 19
 * 18
 * 
 * When getMin() is called, it should return 18 which is the minimum 
 * in the current stack.
 * 
 * @author Rahul
 */
public class StackWithMinValueAccess {
    
    private final int size;
    private final Deque<Integer> stack;
    
    // This stack will contain minimum elements
    private final Deque<Integer> minElements;

    public StackWithMinValueAccess(int _size) {
        this.size = _size;
        this.stack = new ArrayDeque<>(this.size);
        this.minElements = new ArrayDeque<>();
    }
    
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
    
    public boolean isFull() {
        return this.size == this.stack.size();
    }
    
    public void push(int _number) {
        if (this.isFull()) {
            throw new StackOverflowError("Stack already has " + this.size + " elements.");
        }
        
        if (this.isEmpty()) {
            this.stack.push(_number);
            this.minElements.push(_number); // first element will always be minimum
        } else {
            // if incoming element is smaller than or equal to current top minimum, then push it for minimum
            int currMin = this.minElements.pop();
            
            // first push the poped element
            this.minElements.push(currMin);
            
            if (_number <= currMin) {
                this.minElements.push(_number);
            }
        }
    }
    
    public int pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        
        int popedElement = this.stack.pop();
        int minElement = this.minElements.pop();
        
        // If poped element is not the minimum element, then push back the miminum element
        if (minElement != popedElement) {
            this.minElements.push(minElement);
        }
        
        return popedElement;
    }
    
    public int getMinimum() {
        int minElement = this.minElements.pop();
        
        this.minElements.push(minElement);
        
        return minElement;
    }
    
}
