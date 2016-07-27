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
public interface Comparator< T, U, V> {

    public int compareToStr(T obj1, T obj2);

    public int compareToInt(U obj1, U obj2);

    public double compareToDou(V obj1, V obj2);
}
