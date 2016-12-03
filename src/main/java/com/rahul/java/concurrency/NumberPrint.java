/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rahul.java.concurrency;

import java.util.concurrent.atomic.*;

/**
 * Print numbers 1,2,3,4,5,6.. in three threads. Numbers should be in sequence.
 *
 * @author Rahul
 */
public class NumberPrint {

    private final AtomicInteger count;

    public NumberPrint() {
        this.count = new AtomicInteger(1);
    }

    public void print() {
        Thread firstPrinter = this.getPrinter(0);
        Thread secondPrinter = this.getPrinter(1);
        Thread thirdPrinter = this.getPrinter(2);

        firstPrinter.start();
        secondPrinter.start();
        thirdPrinter.start();
    }

    private Thread getPrinter(int _printOnNumber) {

        return new Thread() {
            @Override
            public void run() {
                synchronized (count) {
                    while (count.get() < 100) {
                        try {
                            while (count.get() % 3 != _printOnNumber) {
                                count.wait();
                            }
                        } catch (InterruptedException _ie) {

                        }

                        System.out.println(count.getAndIncrement());
                        count.notifyAll();
                    }

                }
            }
        };

    }

    public static void main(String[] args) {
        new NumberPrint().print();
    }
}
