package org.inria.restlet.mta.database.api;

import java.util.Collection;
import java.util.List;

import org.inria.restlet.mta.backend.Clients;

/**
 *
 * Interface de la database
 *
 * @author Elise CHAPON
 * @author Maëlla GHERAIA
 */
public interface Database
{
	/**
	 * Permet de récupérer dans un tableau tous les clients déclarés
	 * 
	 * @return la liste des clients
	 */
	Clients[] getClients();


	/**
	 * Permet de récupérer le client dont l'id est clientId
	 * 
	 * @param clientId		Id du client que l'on veut récupéré
	 */
    Clients getClient(int clientId);

}
