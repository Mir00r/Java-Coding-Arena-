/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r.spring_mvc.dao;

import com.mir00r.spring_mvc.model.Product;
import java.util.List;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public interface ProductDao {

    public void AddProduct(Product product);

    public void UpdateProduct(Product product);

    public List< Product> listProduct();

    public Product getProductById(Integer productId);

    public void RermoveProduct(Integer productId);
}
