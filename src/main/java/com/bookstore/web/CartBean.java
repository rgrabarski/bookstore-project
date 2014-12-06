package com.bookstore.web;

import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.entities.CartLine;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name="cartBean")
@SessionScoped
public class CartBean {

    private List<CartLine> cart ;

    public List<CartLine> getCart()
    {
        return cart;
    }

    public void setCart(List<CartLine> cart)
    {
        this.cart = cart;
    }

    @PostConstruct
    public void init() {
        cart = new ArrayList<>();
        Book book = new Book();
        book.setTitle("titre");
        book.setIsbn("isbn");
        book.setUnitPrice(10.0);
        Author a = new Author();
        a.setFirstName("firstname");
        a.setLastName("lastname");
        book.setAuthor(a);
        CartLine cl = new CartLine();
        cl.setBook(book);
        cl.setQuantity(2);
        cart.add(cl);
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

    public void deleteCartLine(CartLine cl)
    {
        if (cart.contains(cl)){
            cart.remove(cl);
        }
    }

}

