package com.bookstore.web.util;

import java.util.HashMap;

/**
 * Représente une correspondance entre un mot à afficher et un attribut d'objet.
 * 
 * @author RGAT
 *
 */
public class Criterions {
    /**
     * key = word display
     * value = correspondence
     */
    private HashMap<String, String> criterionsMap = new HashMap<String,String>();

    /**
     * Initialise la HashMap des critères avec la correspondance "Mot a afficher" <=> "attribut"
     */
    private void initCriterionsMap()
    {
        criterionsMap.put("Titre", "title");
        criterionsMap.put("Auteur", "author.lastName");
        criterionsMap.put("Editeur", "editor");
        criterionsMap.put("ISBN", "isbn");
        criterionsMap.put("Prix inférieur à", "unitPrice");
    }

    public Criterions() {
        initCriterionsMap();
    }

    public HashMap<String, String> getCriterionsMap() {
        return criterionsMap;
    }
}
