/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.spring_mvc.controller;

import com.mir00r.spring_mvc.model.Product;
import com.mir00r.spring_mvc.service.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
@Controller
public class ProductController {
    
    @Autowired 
    ProductService productService;
    
    @RequestMapping("/") /*this url run in contextpath*/
    public String listProduct ( Map < String, Object > map ) {
        map.put("product", new Product());
        map.put("productList", productService.listProduct());
        return "index";
    }
    
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addBook ( @ModelAttribute("product") Product product, BindingResult result ) {
        
        if ( product.getId() == null ) {
            productService.AddProduct(product);
        }
        
        return "redirect:/";
    }

}
