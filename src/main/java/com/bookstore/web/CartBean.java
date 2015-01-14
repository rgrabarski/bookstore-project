package com.bookstore.web;

import com.bookstore.entities.Book;
import com.bookstore.entities.CartLine;
import com.bookstore.service.ICatalogService;
import com.bookstore.service.database.CatalogDBService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="cartBean")
@SessionScoped
public class CartBean {

    private List<CartLine> cart ;
    private ICatalogService catalogService = new CatalogDBService();
    private int nbArticles = 0;
    private double prixTotal = 0.0 ;

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
        if(cart == null){
            cart = new ArrayList<>();
        }
        
        // Vérification si le livre représenté par l'ISBN existe bien :
        Book b = catalogService.findBookByISBN(isbn);
        
        // Si le livre existe, alors on l'ajoute au panier :
        if(b != null){
        	addCartLine(b, 1);
        }
        
        // On retourne null pour rester sur la même page :
        return null;
    }
    
    /**
     * Ajoute un ligne au panier.
     * @param b Le livre à ajouter au panier.
     * @param quantity Le nombre de ce livre à ajouter.
     */
    private void addCartLine(Book b, int quantity){
        Boolean found = false ;
        
        // Pour chaque ligne du tableau :
        for(CartLine cartline : cart){
        	// Si la ligne contient déjà ce livre (même ISBN) :
        	if(cartline.getBook().getIsbn().equals(b.getIsbn())){
        		// Alors on modifie la quantité de cet article :
        		cartline.setQuantity(cartline.getQuantity() + quantity);
        		
        		// Et on modifie le prix total de la ligne :
        		cartline.setLinePrice((cartline.getQuantity() * b.getUnitPrice()));
        		
        		// Et on dit qu'on a trouvé une occurence de ce livre :
        		found = true;
        	}
        }
        
        // Si on a trouvé aucune occurence de ce livre :
        if(! found){
        	// Alors on l'ajoute au panier :
        	CartLine cl;
			try {
				cl = new CartLine(b, quantity);
				cart.add(cl);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // Mise à jour du prix total du panier :
        prixTotal = prixTotal + ( quantity *  b.getUnitPrice()) ;
        
        // Mise à jour du nombre d'articles dans le panier :
        nbArticles =  nbArticles + quantity ;
    }

    /**
     * Supprime une ligne du panier
     * @param cl La ligne du panier à supprimer.
     */
    public String deleteCartLine(CartLine cl)
    {
        if (cart.contains(cl)){
            cart.remove(cl);
            
            // Mise à jour de la quantité totale du panier :
            nbArticles = nbArticles - cl.getQuantity();
            
            // Mise à jour du prix total :
            prixTotal = prixTotal - (cl.getQuantity() * cl.getBook().getUnitPrice());
        }
        return null;
    }
   
    /**
     * Affiche la page du panier.
     * @return La page du panier.
     */
    public String displayCart(){
    	return "cart";
    }
    
    /**
     * Met à jour la quantité pour une ligne de livre donnée.
     * @param e
     */
    public void updateQuantity(AjaxBehaviorEvent e){
    	try{
    		// Récupération de la ligne en cours de traitement lors de l'appel :
    		CartLine c= (CartLine)e.getComponent().getAttributes().get("current");
    		
    		// Mise à jour du prix final de la ligne :
    		c.setLinePrice(c.getQuantity() * c.getBook().getUnitPrice());
    		
    		// Mise à jour du nombre d'articles dans le panier :
    		updateNumberOfArticles();
    		
    		// Mise à jour du prix total du panier :
    		updateTotalPrice();
    		
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
    /**
     * Recalcule le prix final de la totalité des articles du panier.
     */
    private void updateTotalPrice(){
    	double total = 0 ;
    	for(CartLine c : cart){
    		total += c.getQuantity() * c.getBook().getUnitPrice() ;
    	}
    	prixTotal = total ;
    }
    
    /**
     * Recalcule le nombre ttal d'articles dans le panier.
     */
    private void updateNumberOfArticles(){
    	int nb = 0;
    	for(CartLine c : cart){
    		nb += c.getQuantity();
    	}
    	nbArticles = nb ;
    }
    

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

    public int getNbArticles() {
		return nbArticles;
	}

	public void setNbArticles(int nbArticles) {
		this.nbArticles = nbArticles;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
}

