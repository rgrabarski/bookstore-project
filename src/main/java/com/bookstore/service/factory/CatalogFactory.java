package com.bookstore.service.factory;

import com.bookstore.service.ICatalogService;
import com.bookstore.service.database.CatalogDBService;

/**
 * Factory permettant de récupérer un service de gestion du catalogue.
 * 
 * @author RGAT
 *
 */
public class CatalogFactory {

	private static ICatalogService catalogService = null ;
	
	/**
	 * Fourni un service de gestion du catalogue.
	 * @return Un service de gestion du catalogue implémentant l'interface {@link ICatalogService}.
	 */
	public static ICatalogService getCatalogServiceInstance(){
		if(catalogService == null){
			return new CatalogDBService();
		}
		return catalogService;
	}

}
