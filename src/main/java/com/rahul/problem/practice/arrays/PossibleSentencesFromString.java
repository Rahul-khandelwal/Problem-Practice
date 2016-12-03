/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rahul.problem.practice.arrays;

import java.util.*;

/**
 * Given a dictionary of words, find all possible sentences that can be formed from a string with no spaces.
 * Example : Iamcoolguy 
 * Answer: I am cool guy. 
 * 
 * @author Rahul
 */
public class PossibleSentencesFromString {

    private final Set<String> dictionary;
    
    public PossibleSentencesFromString(Set<String> _dictionary) {
        this.dictionary = _dictionary;
    }
    
    /**
     * FizzBuzz is the most basic solution and it considers that 
     * input will be broken down into two words only.
     * 
     * @param _input
     */
    public void printSequencesFizzBuzzSolution(String _input) {
        
        int length = _input.length();
        
        String prefix;
        String suffix;
        for (int i = 0 ; i < length ; i++) {
            prefix = _input.substring(0, i);
            
            if (this.dictionary.contains(prefix)) {
                suffix = _input.substring(i);
                
                if (this.dictionary.contains(suffix)) {
                    System.out.println(prefix + " " + suffix);
                }
            }
        }
        
    }
    
    /**
     * This solution is based in "Recursive Backtracking".
     * This solution works when string can be broken into any number of words.
     * This solution uses FizzBuzz solution recursively.
     * 
     * @param _input
     * @param _prefix
     */
    public void printSequencesRecursive(String _input, String _prefix) {
        
        if (this.dictionary.contains(_input)) {
            System.out.println(_prefix + (_prefix.length() > 0 ? " " : "") + _input);
            return;
        }
        
        String prefix;
        String suffix;
        int length = _input.length();
        for (int i = 0 ; i < length ; i++) {
            prefix = _input.substring(0, i);
            
            if (this.dictionary.contains(prefix)) {
                suffix = _input.substring(i);
                
                this.printSequencesRecursive(suffix, _prefix + (_prefix.length() > 0 ? " " : "") + prefix);
            }
        }
    }
    
    /**
     * This solution is based in "memorization".
     * 
     * @param _input
     * @param _prefix
     * @param _memory
     */
    public void printSequencesMemorized(String _input, String _prefix, Map<String, String> _memory) {
        
        if (this.dictionary.contains(_input)) {
            _memory.put(_input, _prefix + (_prefix.length() > 0 ? " " : "") + _input); // memorize for later use
        }
        
        if (_memory.containsKey(_input)) {
            System.out.println(_memory.get(_input));
            return;
        }
        
        String prefix;
        String suffix;
        int length = _input.length();
        for (int i = 0 ; i < length ; i++) {
            prefix = _input.substring(0, i);
            
            if (this.dictionary.contains(prefix)) {
                suffix = _input.substring(i);
                
                this.printSequencesRecursive(suffix, _prefix + (_prefix.length() > 0 ? " " : "") + prefix);
            }
        }
    }
    
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(new String[]{"I", "am", "cool", "guy"}));
        PossibleSentencesFromString psfs = new PossibleSentencesFromString(dictionary);
        
        psfs.printSequencesMemorized("Iamcoolguy", "", new HashMap<>());
    }
    
}
