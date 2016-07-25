/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.model;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class Manager {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("In set Method");
        //throw (new RuntimeException());
    }
    
    public String setNameReturn ( String name ) {
        this.name = name;
        System.out.println("In set method with Name+++++++");
        return name;
    }
    
}
