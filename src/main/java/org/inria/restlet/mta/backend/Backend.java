package org.inria.restlet.mta.backend;

import org.inria.restlet.mta.database.api.Database;
import org.inria.restlet.mta.database.api.impl.Restaurant;

/**
 * Backend for all resources.
 * 
 * @author ctedeschi
 * @author msimonin
 */
public class Backend
{
    /** Database.*/
    private Database database_;
    Restaurant restaurant;

    public Backend(Restaurant restaurant)
    {
        database_ = restaurant;
    }

    public Database getDatabase()
    {
        return database_;
    }

}
