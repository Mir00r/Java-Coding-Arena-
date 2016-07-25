/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.controller;

import java.beans.PropertyEditorSupport;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class EmployeeNameEditor extends PropertyEditorSupport{

    @Override
    public void setAsText(String ename) throws IllegalArgumentException {
        if ( ename.contains("Mr.") || ename.contains("Ms.") ) {
            setValue(ename);
        }
        else {
            setValue("Mr. " +ename);
        }
    }
    
}
