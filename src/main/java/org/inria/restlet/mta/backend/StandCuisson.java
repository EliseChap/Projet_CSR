package org.inria.restlet.mta.backend;

import org.inria.restlet.mta.database.api.impl.Restaurant;

public class StandCuisson {

	private static int nbClientsStand=0; 
	Restaurant restaurant;
	
	public StandCuisson(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}

	public static int getNombreClients() {
		return nbClientsStand; 
	}
	
	public void incrementerNombreClients() {
		nbClientsStand++; 
	}
	
	
	public void decrementerNombreClients() {
		nbClientsStand--; 
	}

}
	

