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
 * Ressource qui s'occupe du buffet
 *
 * @author msimonin
 * @author ctedeschi
 *
 */
public class BuffetRessource extends ServerResource
{


    /** Backend.*/
    private Backend backend_;

    /** Buffets générés par cette ressource.*/
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


    /**
     * Cette méthode permet de récupérer en json l'état du buffet
     * 
     * @return une JsonRepresentation
     * @throws Exception
     */
    @Get("json")
    public Representation getEtatBuffet() throws Exception
    {       
        JSONObject buffetObject = new JSONObject();
        buffetObject.put("etatlegumes", legumes_.getsize());
        buffetObject.put("etatviande", viande_.getsize());
        buffetObject.put("etatpoisson", poisson_.getsize());
        buffetObject.put("etatnouilles", nouilles_.getsize());

        return new JsonRepresentation(buffetObject);
    }
}
