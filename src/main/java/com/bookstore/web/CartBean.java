package com.bookstore.web;

import com.bookstore.entities.Book;
import com.bookstore.entities.CartLine;
import com.bookstore.service.ICatalogService;
import com.bookstore.service.database.CatalogDBService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="cartBean")
@SessionScoped
public class CartBean {

    private List<CartLine> cart ;
    private ICatalogService catalogService = new CatalogDBService();

    /**
     * Initialise les données.
     */
    @PostConstruct
    public void init() {
        cart = new ArrayList<>();
    }

    /**
     * Ajoute un article au panier.
     * @param isbn L'isbn du livre à ajouter.
     * @return {@code null} pour rester sur la même page.
     */
    public String addToCart(String isbn)
    {
        System.out.println("addToCart function");
        if(cart == null){
            cart = new ArrayList<>();
        }
        
        // Vérification si le livre représenté par l'ISBN existe bien :
        Book b = catalogService.findBookByISBN(isbn);
        
        // Si le livre existe, alors on l'ajoute au panier :
        if(b != null){
        	addCartLine(b);
        }
        
        // On retourne null pour rester sur la même page :
        return null;
    }
    
    /**
     * Ajoute un ligne au panier.
     * @param b Le livre à ajouter au panier.
     */
    private void addCartLine(Book b){
        CartLine cl = new CartLine();
        cl.setBook(b);
        cl.setQuantity(1);
        cart.add(cl);
    }

    /**
     * Supprime une ligne du panier
     * @param cl La ligne du panier à supprimer.
     */
    public void deleteCartLine(CartLine cl)
    {
        if (cart.contains(cl)){
            cart.remove(cl);
        }
    }
   
//  public void addToCart(Book book)
//  {
//      System.out.println("addToCart function");
//      if(cart == null){
//          System.out.println("cart init");
//          cart = new ArrayList<>();
//      }
//      if (book != null) {
//          cart.add(book);
//          System.out.println(book.getTitle() + " added to cart");
//      }
//  }
    
    /*
     * GETTERS AND SETTERS
     * */
    public List<CartLine> getCart()
    {
        return cart;
    }

    public void setCart(List<CartLine> cart)
    {
        this.cart = cart;
    }

}

