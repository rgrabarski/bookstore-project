package com.bookstore.web;

import com.bookstore.entities.Book;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="cartBean")
@SessionScoped
public class CartBean {

    private List<Book> cart ;

    public List<Book> getCart()
    {
        return cart;
    }

    public void setCart(List<Book> cart)
    {
        this.cart = cart;
    }

//    public void addToCart(Book book)
//    {
//        System.out.println("addToCart function");
//        if(cart == null){
//            System.out.println("cart init");
//            cart = new ArrayList<>();
//        }
//        if (book != null) {
//            cart.add(book);
//            System.out.println(book.getTitle() + " added to cart");
//        }
//    }

    public void addToCart(String isbn)
    {
        System.out.println("addToCart function");
        if(cart == null){
            System.out.println("cart init");
            cart = new ArrayList<>();
        }
//        if (book != null) {
//            cart.add(book);
//            System.out.println(book.getTitle() + " added to cart");
//        }
    }

}

