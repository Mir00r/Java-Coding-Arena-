/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r;

import java.util.ArrayList;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
public class AutoComplete {
    public ArrayList < String > listCountry = new ArrayList<>();
    String country;

    public ArrayList<String> getListCountry() {
        return listCountry;
    }

    public void setListCountry(ArrayList<String> listCountry) {
        this.listCountry = listCountry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public String execute () {
        populateCountry();
        return "success";
    }
    
    public void populateCountry () {
        listCountry.add("Bangladesh");
        listCountry.add("Australia");
        listCountry.add("Russia");
        listCountry.add("Bhutan");
        listCountry.add("Nepal");
        listCountry.add("England");
        listCountry.add("India");
        listCountry.add("Italy");
        listCountry.add("Canada");
        listCountry.add("Argentina");
        listCountry.add("America");
        
    }
}
