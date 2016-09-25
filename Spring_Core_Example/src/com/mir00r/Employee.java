/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r;

import java.util.List;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */


public class Employee {
    private List < Address > address1;

    public List<Address> getAddress1() {
        return address1;
    }

    public void setAddress1(List<Address> address1) {
        this.address1 = address1;
    }
    
    public void show () {
        System.out.println(address1);
    }
}



/*
public class Employee {
    private Address address1;
    private Address address2;

    public Address getAddress1() {
        return address1;
    }

    public void setAddress1(Address address1) {
        this.address1 = address1;
    }

    public Address getAddress2() {
        return address2;
    }

    public void setAddress2(Address address2) {
        this.address2 = address2;
    }
    
    
    
    public void show () {
        System.out.println(address1);
        System.out.println(address2);
    }
}


*/


/*
public class Employee {
    private int id;
    private String name;
    private Address address; // create object from Address class

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    public void show () {
        System.out.println(id + " : " + name);
        System.out.println(address);
    }
}
*/