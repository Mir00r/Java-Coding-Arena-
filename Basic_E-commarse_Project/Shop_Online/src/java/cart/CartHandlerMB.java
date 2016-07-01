/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
@ManagedBean
@SessionScoped
public class CartHandlerMB {

    List< CartBind> cartList = new ArrayList< CartBind>();
    Map< Integer, CartBind> map = new HashMap<Integer, CartBind>();

    int productId;
    int cartsize;
    int quantity;
    
    String productname;
    String item = "item";
    
    double price;
    double total;

    public List<CartBind> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartBind> cartList) {
        this.cartList = cartList;
    }

    public Map<Integer, CartBind> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartBind> map) {
        this.map = map;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartsize() {
        return cartsize;
    }

    public void setCartsize(int cartsize) {
        this.cartsize = cartsize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String proccessCart( int qty ) {
        CartBind cb = new CartBind();
        quantity = qty;

        cb.setProductname(productname);
        cb.setQuantity(quantity);
        cb.setPrice(price);
        cb.setTotal(quantity * price);

        cartList.add(cb);
        map.put(productId, cb);

        cartsize = cartList.size();
        if ( cartsize > 1 ) {
            item = "items";
        }
        return null;
    }
}
