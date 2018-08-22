/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.concurrency;

/**
 *
 * @author Rahul
 */
public class StringSequencePrint {

    private String input;
    private Integer currChar;
    private int printerThreads;
    
    private final Object lock;

    public StringSequencePrint(String _input, int _printerThreads) {
        this.input = _input;
        this.currChar = 0;
        this.printerThreads = _printerThreads;
        this.lock = new Object();
    }

    public void print() {
        for (int i = 0; i < printerThreads; i++) {
            Thread thread = this.getSequencePrinter(i);
            thread.start();
        }
    }

    private Thread getSequencePrinter(int _seq) {
        return new Thread() {
            public void run() {
                while (currChar < input.length()) {
                    synchronized (lock) {
                        while (currChar % printerThreads != _seq) {
                            try {
                                lock.wait();
                            } catch (Exception _e) {
                                
                            }
                        }

                        if (currChar < input.length()) {
                            System.out.println(input.charAt(currChar));
                        }
                        
                        currChar++;
                        lock.notifyAll();
                    }
                }
            }
        };
    }
    
    public static void main(String[] args) {
        new StringSequencePrint("rahul.kh", 3).print();
    }
}
