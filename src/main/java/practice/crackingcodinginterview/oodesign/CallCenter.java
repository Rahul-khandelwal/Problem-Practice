/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.crackingcodinginterview.oodesign;

import java.util.*;

/**
 * Imagine a call center with three levels of employees: respondent, manager and director.
 * An incoming telephone call must be first allocated to the respondent who is free.
 * If the respondent can't handle the call, he must escalate the call to manager.
 * If the manager is not free or can't handle the call, then the call should be escalated to a director.
 * Design the data structure and classes for this problem.
 * Implement a method 'dispatchCall' which assigns a call to first available employee.
 */

/**
 * Represents a caller
 */
class Caller {
    
}

/**
 * Represents a call from a caller.
 * Call has minimum rank and is assigned to first employee who can handle it.
 */
class Call {
    /**
     * minimum rank who can handle this call.
     */
    private Rank rank;
    
    private Caller caller; // person who is calling
    
    private Employee handler; // employee who is handling the call

    public Call(Caller caller) {
        this.caller = caller;
        this.rank = Rank.RESPONDENT;
    }

    /**
     * Set employee who is handling the call.
     * 
     * @param handler 
     */
    public void setHandler(Employee handler) {
        this.handler = handler;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
    
    public void incrementRank() {
        // increment the rank
    }
    
    public void reply(String _message) {
        
    }
    
    public void disconnect() {
        
    }
}

/**
 * Ranks of employees
 */
enum Rank {
    RESPONDENT,
    MANAGER,
    DIRECTOR
}

/**
 * All three ranks of employees have different works to be done, so their specific functions are 
 * profile specific. We'll keep these things within their respective classes.
 * 
 * Common things like address, name, age, job title, etc. will be kept in this class and 
 * inherited by other classes.
 */
abstract class Employee {
    private Call currentCall = null; // current call this employee is handling
    protected Rank rank;
    private final CallHandler handler;

    public Employee(CallHandler _handler) {
        this.handler = _handler;
    }
    
    public void recieveCall(Call _call) {
        // start the conersation
    }
    
    public void callCompleted() {
        // call is completed
    }
    
    public void escalateAndReassign() {
        // esclate the call
    }
    
    public void assignNewCall(Call _call) {
        // assign new call if the employee is free
    }
    
    public boolean isFree() {
        return this.currentCall == null;
    }

    public Rank getRank() {
        return rank;
    }
}

class Respondent extends Employee {

    public Respondent(CallHandler _handler) {
        super(_handler);
        this.rank = Rank.RESPONDENT;
    }
    
}

class Manager extends Employee {

    public Manager(CallHandler _handler) {
        super(_handler);
        this.rank = Rank.RESPONDENT;
    }
    
}

class Director extends Employee {

    public Director(CallHandler _handler) {
        super(_handler);
        this.rank = Rank.RESPONDENT;
    }
    
}

/**
 * Handles the calls and all calls are first go through it.
 */
class CallHandler {
    private final int LEVELS = Rank.values().length; // 3 levels of employees here
    
    /**
     * Initialize 10 respondent, 4 manager and 2 directors
     */
    private final int NUM_RESPONDENT = 10;
    private final int NUM_MANAGER = 4;
    private final int NUM_DIRECTOR = 2;
    
    /**
     * List of employees by levels
     * employees[0] = respondents
     * employees[1] = managers
     * employees[2] = directors
     */
    List<List<Employee>> employees;
    
    /**
     * queues for each rank's calls
     */
    List<List<Call>> callQueues;

    public CallHandler() {
    }
    
    public Employee getHandlerForCall(Call _call) {
        return null; // Get the first available handler for the call
    }
    
    public void displatchCall(Caller _caller) {
        Call call = new Call(_caller);
        this.dispatchCall(call);
    }
    
    /**
     * Routes the call to available employee, saves it in queue if no employee is free.
     * 
     * @param _call 
     */
    public void dispatchCall(Call _call) {
       Employee emp = this.getHandlerForCall(_call);
       
       if (emp != null) {
           emp.recieveCall(_call);
           _call.setHandler(emp);
       } else {
           _call.reply("Please wait");
           callQueues.get(_call.getRank().ordinal()).add(_call);
       }
    }
    
    /**
     * An employee got free, look for waiting that this employee can serve.
     * 
     * @return Whether any call was assigned to employee.
     */
    public boolean assignCall(Employee _emp) {
        return true;
    }
    
}

/**
 *
 * @author Rahul
 */
public class CallCenter {
    
    public static void main(String[] args) {
        // This will be the main method.
        // It will initialize employees and call handler.
    }
    
}
