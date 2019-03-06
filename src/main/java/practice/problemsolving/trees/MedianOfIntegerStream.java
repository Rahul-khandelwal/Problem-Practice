/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.trees;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 *
 * @author Rahul
 */
public class MedianOfIntegerStream {

    // TODO We can implement heap by ourself
    private final TreeSet<Integer> minHeap;
    private final TreeSet<Integer> maxHeap;

    private int currMedian;

    public MedianOfIntegerStream() {
        this.maxHeap = new TreeSet<>(Comparator.reverseOrder());
        this.minHeap = new TreeSet<>();
    }

    public void addNumber(int number) {
        // Update currMedian
        if (this.minHeap.size() == this.maxHeap.size()) {
            if (number > this.currMedian) {
                this.minHeap.add(number);
                this.currMedian = this.minHeap.first();
            } else {
                this.maxHeap.add(number);
                this.currMedian = this.maxHeap.first();
            }
        } else if (this.minHeap.size() > this.maxHeap.size()) {
            this.maxHeap.add(this.minHeap.pollFirst());
            this.minHeap.add(number);
            this.currMedian = (this.minHeap.first() + this.maxHeap.first()) / 2;
        } else {
            this.minHeap.add(this.maxHeap.pollFirst());
            this.maxHeap.add(number);
            this.currMedian = (this.minHeap.first() + this.maxHeap.first()) / 2;
        }
    }

    public int getCurrMedian() {
        return currMedian;
    }

    public static void main(String[] args) {
        MedianOfIntegerStream mois = new MedianOfIntegerStream();
        System.out.println(mois.currMedian);
        mois.addNumber(5);
        System.out.println(mois.currMedian);
        mois.addNumber(15);
        System.out.println(mois.currMedian);
        mois.addNumber(1);
        System.out.println(mois.currMedian);
        mois.addNumber(3);
        System.out.println(mois.currMedian);
    }
}
