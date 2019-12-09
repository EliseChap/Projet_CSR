package org.inria.restlet.mta.resources;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.backend.BuffetLegumes;
import org.inria.restlet.mta.backend.BuffetNouilles;
import org.inria.restlet.mta.backend.BuffetPoisson;
import org.inria.restlet.mta.backend.BuffetViande;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * Resource exposing a user.
 *
 * @author msimonin
 * @author ctedeschi
 *
 */
public class BuffetRessource extends ServerResource
{


    /** Backend.*/
    private Backend backend_;

    /** Utilisateur géré par cette resource.*/
    private BuffetLegumes legumes_ = new BuffetLegumes();
    private BuffetViande viande_ = new BuffetViande();
    private BuffetPoisson poisson_ = new BuffetPoisson();
    private BuffetNouilles nouilles_ = new BuffetNouilles();


    /**
     * Constructor.
     * Call for every single user request.
     */
    public BuffetRessource()
    {
        backend_ = (Backend) getApplication().getContext().getAttributes().get("backend");
    }


    @Get("json")
    public Representation getEtatClient() throws Exception
    {       

        JSONObject clientObject = new JSONObject();
        clientObject.put("etatlegumes", legumes_.getsize());
        clientObject.put("etatviande", viande_.getsize());
        clientObject.put("etatpoisson", poisson_.getsize());
        clientObject.put("etatnouilles", nouilles_.getsize());

        return new JsonRepresentation(clientObject);
    }
}
