/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class Address {

    private String state;
    private String city;
    private String country;

    public Address(String state, String city, String country) {
        this.state = state;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" + "state=" + state + ", city=" + city + ", country=" + country + '}';
    }
}
