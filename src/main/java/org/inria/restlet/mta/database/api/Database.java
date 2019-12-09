package org.inria.restlet.mta.database.api;

import java.util.Collection;
import java.util.List;

import org.inria.restlet.mta.backend.Clients;

/**
 *
 * Interface de la database
 *
 * @author Elise CHAPON
 * @author Ma�lla GHERAIA
 */
public interface Database
{
	/**
	 * Permet de r�cup�rer dans un tableau tous les clients d�clar�s
	 * 
	 * @return la liste des clients
	 */
	Clients[] getClients();


	/**
	 * Permet de r�cup�rer le client dont l'id est clientId
	 * 
	 * @param clientId		Id du client que l'on veut r�cup�r�
	 */
    Clients getClient(int clientId);

}
