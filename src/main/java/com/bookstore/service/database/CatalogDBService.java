package com.bookstore.service.database;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entities.Book;
import com.bookstore.service.ICatalogService;
import com.bookstore.web.util.EMFListener;
import org.hibernate.Query;

/**
 * Classe permettant de récupérer les informations relatives au catalogue depuis la base de données.<br>
 * Implémente l'interface {@link ICatalogService} et {@link Serializable}.
 * 
 * @author RGAT
 *
 */
@SuppressWarnings("serial")
public class CatalogDBService implements ICatalogService, Serializable {
    
    /**
     * Récupère la liste de tous les livres.
     * @return Une liste de tous les livres ou {@code null}.
     */
	public List<Book> findAll() {
		EntityManager em = null ;
		List<Book> books = null;
		
		try{
			em = EMFListener.createEntityManager();
			books = em.createQuery("From Book", Book.class).getResultList();
		} finally {
			if (em != null) {
				try{
					em.close();
				}
				catch(Exception e){/*nothing to do*/}
			}
		}
		return books;
	}

	/**
	 * Recherche des livres selon des critères et des valeurs.
	 * @param label La valeur à chercher (Keith, 978-1932394887, 47.03, ...) 
	 * @param criterion Le critère à rechercher (nom, isbn, prix, ...)
	 * @return La liste des livres correspondants au couple critère / label ou {@code null}.
	 * @throws Exception En cas d'erreur.
	 */
    public List<Book> findByLabelAndCriterion(String label, String criterion) throws Exception{
    	EntityManager em = null ;
    	List<Book> books = null ;
    	
    	try {
        	em = EMFListener.createEntityManager();
			//Recherche concernant un prix inférieur à celui demandé
			if (criterion.equals("unitPrice")){
				books = em.createQuery("select b From Book b where b." + criterion + "< :label", Book.class)
						.setParameter("label", Double.parseDouble(label))
						.getResultList();
			} else { // les autres recherches
				books = em.createQuery("select b From Book b where upper(b." + criterion + ") LIKE :label", Book.class)
						.setParameter("label", "%" + label.toUpperCase() + "%")
						.getResultList();
			}

        } catch (Exception e) {
            throw new Exception("CatalogService:findByLabelAndCriterion: " + e.getMessage());
        }finally{
        	if (em != null) {
				try{
					em.close();
				}
				catch(Exception e){/*nothing to do*/}
			}
        }
    	return books;

    }


//    public List<Book> findByMultiCriterions(String author_label, String title_label, String isbn_label, String price_label) throws Exception {
//        try {
//            return null;
//        } catch (Exception e) {
//            throw new Exception("CatalogService:findByMultiCriterions: " + e.getMessage());
//        }
//    }

    /**
     * Recherche en base de données un livre en focntion de son ISBN.
     * @param isbn L'ISBN du livre à rechercher.
     * @return Le livre correspondant à cet ISBN, {@code null} sinon.
     */
	@Override
	public Book findBookByISBN(String isbn) {
		EntityManager em = null ;
		Book book = null;
		
		try {
        	em = EMFListener.createEntityManager();
            book = em.find(Book.class, isbn);
       }finally{
        	if (em != null) {
				try{
					em.close();
				}
				catch(Exception e){/*nothing to do*/}
			}
        }
		return book;
	}
}
