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
public class CompareToGeneric implements Comparator < String, Integer, Double > {

    @Override
    public int compareToStr(String obj1, String obj2) {
        return ( obj1.length() - obj2.length() ) ;
    }

    @Override
    public int compareToInt(Integer obj1, Integer obj2) {
        return ( obj1 + obj2 );
    }

    @Override
    public double compareToDou(Double obj1, Double obj2) {
        return ( obj1 + obj2 );
    }
 
}
