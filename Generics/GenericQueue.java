/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.generic;

import java.util.LinkedList;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class GenericQueue < T > {
    private LinkedList < T > item = new LinkedList < T >();
    
    public void enqueue ( T obj ) {
        item.addLast(obj);
    }
    
    public T dequeue () {
        return item.removeFirst();
    }
    
    public boolean isEmpty() {
        return ( item.size() == 0 );
    }
}
