/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r.spring_mvc.dao;

import com.mir00r.spring_mvc.model.Product;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
@Repository
public class ProductDaoImplementation implements ProductDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void AddProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public void UpdateProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> listProduct() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public Product getProductById(Integer productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RermoveProduct(Integer productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
