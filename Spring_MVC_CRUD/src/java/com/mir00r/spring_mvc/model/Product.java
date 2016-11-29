package com.mir00r.spring_mvc.model;
// Generated Jul 25, 2016 2:13:11 AM by Hibernate Tools 4.3.1

import org.hibernate.annotations.Entity;



@Entity
public class Product  implements java.io.Serializable {

     private Integer id;
     private String productName;
     private String description;
     private int price;
     private int qty;

    public Product() {
    }

    public Product(String productName, String description, int price, int qty) {
       this.productName = productName;
       this.description = description;
       this.price = price;
       this.qty = qty;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    public int getQty() {
        return this.qty;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }

}


