/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.spring_mvc.service;

import com.mir00r.spring_mvc.dao.ProductDao;
import com.mir00r.spring_mvc.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
@Service
public class ProductServiceImplementation implements ProductService {
    
    @Autowired
    ProductDao productDao;

    @Override
    @Transactional
    public void AddProduct(Product product) {
        productDao.AddProduct(product);
    }

    @Override
    @Transactional
    public void UpdateProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Product> listProduct() {
        return productDao.listProduct();
    }

    @Override
    @Transactional
    public Product getProductById(Integer productId) {
        return null;
    }

    @Override
    @Transactional
    public void RermoveProduct(Integer productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
