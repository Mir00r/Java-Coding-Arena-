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
public class GenericWildCard {
    public static void PrintCollection ( List < ? > objects) {
        for ( Object obj : objects ) {
            System.out.println(obj);
        }   
    }
}
