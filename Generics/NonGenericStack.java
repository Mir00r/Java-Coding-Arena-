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
public class NonGenericStack {
    private Object[] element;
    private int size = 0;
    private static final int CAPACITY = 10;

    public NonGenericStack() {
        element = new Object[CAPACITY];
    }
    
    public void push ( Object obj ) {
        element[size] = obj;
        size++;
    }
    
    public Object pop () {
        if ( size <= 0 ) {
            return null;
        }
        size--;
        return element[size];
    }
}
