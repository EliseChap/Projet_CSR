package org.inria.restlet.mta.backend;

import org.inria.restlet.mta.database.api.impl.Restaurant;

/**
 * Cette classe s'occupe du stand de cuisson du restaurant
 * @author Elise CHAPON
 * @author Ma�lla GHERAIA
 */
public class StandCuisson {

	private int nbClientsStand=0; 
	Restaurant restaurant;

	public StandCuisson(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}


	/**
	 * Cette m�thode r�cup�re le nombre de clients au stand
	 * @return	nbClientsStand
	 */
	public int getNombreClients() {
		return nbClientsStand; 
	}


	/**
	 * Cette m�thode incr�mente le nombre de clients du stand
	 */
	public void incrementerNombreClients() {
		nbClientsStand++; 
	}


	/**
	 * Cette m�thode d�cr�mente le nombre de clients du stand
	 */
	public void decrementerNombreClients() {
		nbClientsStand--; 
	}

}