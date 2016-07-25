/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test_code;

import java.util.LinkedList;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class SharedQueue < E > {
    private LinkedList < E > list;
    private int size;

    public SharedQueue() {
    }

    public SharedQueue(int size) {
        this.list = new LinkedList<>();
        this.size = size;
    }
    
    public void add ( E e) {
        list.add(e);
    }
    
    public E remove () {
        return list.remove(0);
    }
    
    public boolean isFull () {
        return list.size() >= size;
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public int getSize() {
        return list.size();
    }
}
