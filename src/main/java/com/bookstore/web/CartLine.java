package com.bookstore.web;

import com.bookstore.entities.Book;

/**
 * Représente une ligne du panier.
 * 
 * @author RGAT
 *
 */
public class CartLine {

    private Book book;
    private Integer quantity;
    private double linePrice ;

    public CartLine() {
    }

    /**
     * Constructeur.
     * @param book Le livre pour lequel on constitue une ligne du panier.
     * @param quantity Le nombre de livres composant la ligne du panier
     * @throws Exception Si le livre est nul ou si la quantité est inférieure à 1.
     */
    public CartLine(Book book, Integer quantity) throws Exception {
        if (book != null && quantity > 0) {
            this.book = book;
            this.quantity = quantity;
            this.linePrice = quantity * book.getUnitPrice() ;
        } else {
            throw new Exception("CartLine: Book can not be null and quantity must be more than 0.");
        }
    }

    /* 
     * GETTERS AND SETTERS 
     * */
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	public double getLinePrice() {
		return linePrice;
	}

	public void setLinePrice(double linePrice) {
		this.linePrice = linePrice;
	}
}
