/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Write methods to get UNION and INTERSECTION of two unsorted lists.
 * 
 * @author Rahul
 */
public class UnionAndIntersectionOfLists {
   
    public List<Integer> getUnion(List<Integer> first, List<Integer> second) {
        List<Integer> sortedList = first.size() < second.size() ? first : second;
        List<Integer> unsortedList = first.size() < second.size() ? second : first;
        Collections.sort(sortedList);
        return this.union(sortedList, unsortedList);
    }
    
    public List<Integer> getIntersection(List<Integer> first, List<Integer> second) {
        List<Integer> sortedList = first.size() < second.size() ? first : second;
        List<Integer> unsortedList = first.size() < second.size() ? second : first;
        Collections.sort(sortedList);
        return this.intersection(sortedList, unsortedList);
    }
    
    private List<Integer> union(List<Integer> sortedList, List<Integer> unsortedList) {
        List<Integer> result = new ArrayList<>(sortedList);
        
        for (int i : unsortedList) {
            if (Collections.binarySearch(sortedList, i) < 0) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    private List<Integer> intersection(List<Integer> sortedList, List<Integer> unsortedList) {
        List<Integer> result = new ArrayList<>();
        
        for (int i : unsortedList) {
            if (Collections.binarySearch(sortedList, i) >= 0) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<Integer> first = new ArrayList<>();
        first.add(2);
        first.add(4);
        first.add(5);
        first.add(15);
        first.add(21);
        
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(4);
        second.add(6);
        second.add(15);
        second.add(22);
        
        System.out.println(new UnionAndIntersectionOfLists().getUnion(first, second));
        System.out.println(new UnionAndIntersectionOfLists().getIntersection(first, second));
    }
}
