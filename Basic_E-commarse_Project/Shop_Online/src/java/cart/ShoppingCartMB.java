/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cart;

import entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */

@ManagedBean
@SessionScoped
public class ShoppingCartMB {
    private List < Item > cart = new ArrayList<>();
    private double total;
    int cartsize;
    String item = "item";

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public double getTotal() {
        total = 0.0;
        for ( Item item : cart ) {
            total = total + (item.getQuantity() * item.getP().getProPrice() );
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCartsize() {
        return cartsize;
    }

    public void setCartsize(int cartsize) {
        this.cartsize = cartsize;
    }

    public String getItem() {
        if ( cartsize > 1 ) {
            item = "items";
        }
        
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    public String addtoCart ( Product p) {
        
        // after searching if we got any similer product then we increase our quantity
        if ( cart.size() > 0 ) {
            for ( Item item : cart ) {
                if ( item.getP().getProId().equals(p.getProId())) {
                    item.setQuantity(item.getQuantity() + 1 );
                    return "cart";
                }
            }
        }
        // otherwise 
        Item it = new Item();
        it.setQuantity(1);
        it.setP(p);
        
        cart.add(it);
        System.out.println("cart.ShoppingCartMB.addtoCart()------i am here--------");
        
        return "cart"; 
    }
    
    public void updateCart() {
        
    }
    
    public void removeCart ( Item it) {
        for ( Item item : cart ) {
            if ( item.equals(it) ) {
                cart.remove(it);
                break;
            }
        }
    }
    
    public String payment () {
        return "payment";
    }
}
