/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rahul.java.concurrency;

import java.util.logging.*;

/**
 * Write code to generate deadlock
 * 
 * @author Rahul
 */
public class DeadlockCreation {
    
    private final Object lock_1;
    private final Object lock_2;

    public DeadlockCreation() {
        this.lock_1 = new Object();
        this.lock_2 = new Object();
    }
    
    public void generateDeadlock() {
        Thread t1 = this.getThread_1();
        Thread t2 = this.getThread_2();
        t1.start();
        t2.start();
    }
    
    private Thread getThread_1() {
        return new Thread() {
            @Override
            public void run() {
                synchronized(lock_1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                    
                    System.out.println("thread 1 trying to get second lock.");
                    
                    synchronized(lock_2) {
                        System.out.println("thread 1 got second lock.");
                    }
                }
            }
            
        };
    }
    
    private Thread getThread_2() {
        return new Thread() {
            @Override
            public void run() {
                synchronized(lock_2) {
                    System.out.println("thread 2 trying to get first lock.");
                    
                    synchronized(lock_1) {
                        System.out.println("thread 2 got first lock.");
                    }
                }
            }
            
        };
    }
    
    public static void main(String[] args) {
        new DeadlockCreation().generateDeadlock();
    }
}
