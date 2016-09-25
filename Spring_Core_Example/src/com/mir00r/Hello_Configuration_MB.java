/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
@Configuration
public class Hello_Configuration_MB {
    
    @Bean
    public Hello hello(){
        return new Hello();
    }
}
