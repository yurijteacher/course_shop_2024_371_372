package ua.com.kisit2024.course_shop_2024_371_372.bl;

import lombok.Getter;
import lombok.Setter;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter

public class Cart {

    List<ItemCart> cart;
    private double totalValue;
    private int sumElInCart;

    public Cart() {
        this.cart = new ArrayList<>();
        this.totalValue = 0;
        this.sumElInCart = 0;
    }

    public synchronized void addNewItemToCart(Product product, int quantity){
        boolean logic = true;

        for(ItemCart el: cart){
            if(el.getProduct().getId()==product.getId()){
                logic = false;
                el.setQuantity(el.getQuantity()+quantity);
            }
        }

        if(logic) cart.add(new ItemCart(product, quantity));
    }

    public synchronized void updateItemInCart(Product product, int quantity){

        if(quantity<=0){
            for(ItemCart el: cart){
                if(el.getProduct().getId()==product.getId()){
                    cart.remove(el);
                    break;
                }
            }
        } else {
            for(ItemCart el: cart){
                if(el.getProduct().getId()==product.getId()){
                    el.setQuantity(quantity);
                }
            }
        }

    }


    public synchronized void deleteItemFromCart(Product product){
        for(ItemCart el: cart){
            if(el.getProduct().getId()==product.getId()){
                cart.remove(el);
                break;
            }
        }
    }


    public synchronized  void deleteAllItemFromCart(){
        cart.clear();
        totalValue = 0;
        sumElInCart = 0;
    }

    public synchronized double getTotalValue() {

        totalValue = 0;
        for (ItemCart el : cart){
            totalValue += el.getQuantity() * el.getProduct().getPrice().doubleValue();
        }

        return totalValue;
    }

    public synchronized int getSumElInCart() {
        int a = cart.size();
        sumElInCart = a;
        return a;
    }


}
