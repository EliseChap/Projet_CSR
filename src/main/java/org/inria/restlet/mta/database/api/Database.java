package org.inria.restlet.mta.database.api;

import java.util.Collection;
import java.util.List;

import org.inria.restlet.mta.backend.Clients;

/**
 *
 * Interface to the database.
 *
 * @author msimonin
 *
 */
public interface Database
{
    

    /**
     *
     * Returns the list of clients.
     *
     * @return the list of clients
     */
	Clients[] getClients();


    /**
     *  Returns the client with a given id.
     *
     *  @return the client
     */
    Clients getClient(int clientId);

}
