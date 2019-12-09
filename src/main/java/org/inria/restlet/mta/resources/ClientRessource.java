package org.inria.restlet.mta.resources;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.backend.Clients;
import org.inria.restlet.mta.database.api.impl.Restaurant;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * Ressource qui s'occupe des clients.
 *
 * @author Elise CHAPON
 * @author Ma�lla GHERAIA
 *
 */
public class ClientRessource extends ServerResource
{

    /** Backend.*/
    private Backend backend_;

    /** Client g�n�r� par cette resource.*/
    private Clients client_ ;

    /**
     * Constructor.
     * Call for every single client request.
     */
    public ClientRessource()
    {
        backend_ = (Backend) getApplication().getContext().getAttributes().get("backend");
    }

    
    /**
     * Cette m�thode permet de r�cup�rer en json l'�tat du client qui a clientId comme id
     * 
     * @return une JsonRepresentation
     * @throws Exception
     */
    @Get("json")
    public Representation getEtatClient() throws Exception
    {
        String clientIdString = (String) getRequest().getAttributes().get("clientId");
        int clientId = Integer.valueOf(clientIdString);
        System.out.println(clientId);
        client_ = backend_.getDatabase().getClient(clientId);

        JSONObject clientObject = new JSONObject();
        clientObject.put("etat", client_.getEtat());
      
        return new JsonRepresentation(clientObject);
    }
}