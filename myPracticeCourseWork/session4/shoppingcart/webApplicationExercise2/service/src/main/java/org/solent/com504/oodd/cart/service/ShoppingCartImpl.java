/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.oodd.cart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.solent.com504.oodd.cart.model.service.ShoppingCart;
import org.solent.com504.oodd.cart.model.dto.ShoppingItem;

/**
 *
 * @author cgallen
 */
public class ShoppingCartImpl implements ShoppingCart {

    private HashMap<String, ShoppingItem> itemMap = new HashMap<String, ShoppingItem>();

    @Override
    public List<ShoppingItem> getShoppingCartItems() {
        List<ShoppingItem> itemlist = new ArrayList();
        for (String itemUUID : itemMap.keySet()) {
            ShoppingItem shoppingCartItem = itemMap.get(itemUUID);
            itemlist.add(shoppingCartItem);
        }
        return itemlist;
    }

    @Override
    public void addItemToCart(ShoppingItem shoppingItem) {
        // itemMap.put(shoppingItem.getUuid(), shoppingItem);
        
        boolean itemExists = false;
        for (String itemUUID : itemMap.keySet()) {
            ShoppingItem shoppingCartItem = itemMap.get(itemUUID);
            if (shoppingCartItem.getUuid().equals(shoppingItem.getUuid())){
                Integer qty = shoppingCartItem.getQuantity();
                shoppingCartItem.setQuantity(qty+1);
                itemExists = true;
                break;
            }
        }
        if (!itemExists){
            itemMap.put(shoppingItem.getUuid(), shoppingItem);
        }
        
    }

    @Override
    public String removeItemFromCart(String itemUuid) {
        ShoppingItem item = itemMap.get(itemUuid);
        itemMap.remove(itemUuid);
        return item.getName();
        
    }

    @Override
    public double getTotal() {
        double total = 0;
        
        for (String itemUUID : itemMap.keySet()) {
            ShoppingItem shoppingCartItem = itemMap.get(itemUUID);
            total = total + shoppingCartItem.getPrice() * shoppingCartItem.getQuantity();
        }
        
        return total;
    }

}
