/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.generic;

import java.util.List;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class GenericMethod {
    public static < T > boolean FindElementInlist ( T obj, List < T > elements ) {
        for ( T element : elements ) {
            if ( element.equals(obj) ) {
                return true;
            }
        }
        
        return false;
    }
    
    public static < T > void Swap ( T[] arr, int i, int j ) {
        T tmp = arr[ i ];
        arr[ i ] = arr[ j ];
        arr[ j ] = tmp;
    }
    
    public static < T extends Comparable < T > > void Sort ( T[] arr ) {
        for ( int i = 0; i < arr.length - 1; i++ ) {
            for ( int j = 0; j < arr.length - 1; j++ ) {
                if ( arr[ i ].compareTo(arr[j]) > 0 ){
                    Swap ( arr, i, j );
                }
            }
        }
    }
}
