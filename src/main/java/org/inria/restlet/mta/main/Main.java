package org.inria.restlet.mta.main;

import org.inria.restlet.mta.application.MyRestaurantApplication;
import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.database.api.impl.Restaurant;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.data.Protocol;

/**
 * Main RESTlet minimal example
 *
 * @author msimonin
 */
public final class Main
{

    /** Hide constructor. */
    private Main()
    {
        throw new UnsupportedOperationException();
    }

    /**
     * Main method.
     *
     * @param args  The arguments of the commande line
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {   	
    	Restaurant restaurant = new Restaurant();
    	
        // Create a component
        Component component = new Component();
        Context context = component.getContext().createChildContext();
        component.getServers().add(Protocol.HTTP, 8124);

        // Create an application
        Application application = new MyRestaurantApplication(context);

        // Add the backend into component's context
        Backend backend = new Backend(restaurant);
        context.getAttributes().put("backend", backend);
        component.getDefaultHost().attach(application);

        // Start the component
        component.start();
    	restaurant.debut(); 		
    }

}
