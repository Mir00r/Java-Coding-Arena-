/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.generic;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class GenericStack < T > {
    
    private T[] element;
    private int size = 0;
    private static final int CAPACITY = 10;

    public GenericStack() {
        element = (T[])new Object[CAPACITY];
    }
    
    public void push ( T obj ) {
        element[size] = obj;
        size++;
    }
    
    public T pop () {
        if ( size <= 0 ) {
            return null;
        }
        size--;
        return element[size];
    }
}
