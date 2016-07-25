/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class PhoneValidator implements ConstraintValidator<Phone, String>{

    @Override
    public void initialize(Phone a) {
        
    }

    @Override
    public boolean isValid(String phoneNo, ConstraintValidatorContext cvc) {
        if ( phoneNo == null ) {
            return false;
        }
        // validate phone number of format "1234567890"
        if ( phoneNo.matches("\\d{10}")) {
            return true;
        }
        else {
            return false;
        }
    }

}
