package org.inria.restlet.mta.backend;

import org.inria.restlet.mta.database.api.impl.Restaurant;

/**
 * Cette classe s'occupe du stand de cuisson du restaurant
 * @author Elise CHAPON
 * @author Maëlla GHERAIA
 */
public class StandCuisson {

	private int nbClientsStand=0; 
	Restaurant restaurant;

	public StandCuisson(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}


	/**
	 * Cette méthode récupère le nombre de clients au stand
	 * @return	nbClientsStand
	 */
	public int getNombreClients() {
		return nbClientsStand; 
	}


	/**
	 * Cette méthode incrémente le nombre de clients du stand
	 */
	public void incrementerNombreClients() {
		nbClientsStand++; 
	}


	/**
	 * Cette méthode décrémente le nombre de clients du stand
	 */
	public void decrementerNombreClients() {
		nbClientsStand--; 
	}

}