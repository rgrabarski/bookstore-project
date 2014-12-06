package com.bookstore.entities;

public class CartLine {

    private Book book;
    private Integer quantity;

    public CartLine() {
    }

    public CartLine(Book book, Integer quantity) throws Exception {
        if (book == null || quantity < 1) {
            this.book = book;
            this.quantity = quantity;
        } else {
            throw new Exception("CartLine: Book can not be null and quantity must be more than 0.");
        }
    }



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
}
