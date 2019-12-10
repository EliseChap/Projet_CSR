package org.inria.restlet.mta.database.api.impl;

import java.util.Collection;
import java.util.HashSet;

import org.inria.restlet.mta.backend.BuffetLegumes;
import org.inria.restlet.mta.backend.BuffetNouilles;
import org.inria.restlet.mta.backend.BuffetPoisson;
import org.inria.restlet.mta.backend.BuffetViande;
import org.inria.restlet.mta.backend.Clients;
import org.inria.restlet.mta.backend.Cuisinier;
import org.inria.restlet.mta.backend.EmployeBuffet;
import org.inria.restlet.mta.backend.StandCuisson;
import org.inria.restlet.mta.database.api.Database;


/**
 * Cette classe s'occupe de ce qu'il se passe � l'entr�e du restaurant.
 * 
 * @author Elise CHAPON
 * @author Ma�lla GHERAIA
 *
 */
public class Restaurant implements Database {

	private final static int nbClientsTotal = 50;
	private final static int sizeMax = 25;
	private int nbClients = 0;
	private int affichageClient = 0;
	private EmployeBuffet employebuffet;
	private Cuisinier cuisinier;
	private Clients[] clients;
	private StandCuisson standcuisson;
	private BuffetLegumes legumes;
	private BuffetViande viandes;
	private BuffetNouilles nouilles;
	private BuffetPoisson poissons;
	

	public Restaurant() {
		super();
		this.employebuffet = new EmployeBuffet(this);
		this.standcuisson = new StandCuisson(this);
		this.cuisinier = new Cuisinier(this);
		this.legumes = new BuffetLegumes();
		this.viandes = new BuffetViande();
		this.nouilles = new BuffetNouilles();
		this.poissons = new BuffetPoisson();
		clients = new Clients[this.nbClientsTotal];

		for (int i = 0; i < nbClientsTotal; i++) {
			clients[i] = new Clients(this);
			clients[i].setId(i + 1);
			System.out.println("Le client" + clients[i].getId() + " est cr�e");
		}
	}

	

	/**
	 * Le restaurant ouvre et les processus employebuffet, cuisinier et client d�marrent.
	 */
	public synchronized void debut() {

		employebuffet.start();
		cuisinier.start();

		for (Clients client : clients) {

			while (nbClients >= sizeMax) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			affichageClient++;
			System.out.println("Nombre de clients qui entrent dans le restaurant : " + affichageClient);
			client.start();
			nbClients++;
		}
	}

	
	/**
	 * Cette m�thode d�cr�mente la variable nbClients qui permet de savoir combien de client sont pr�sent
	 * dans le restaurant
	 */
	public synchronized void clientSort() {
		nbClients--;
		notifyAll();
	}

	
	/**
	 * Cette m�thode permet de r�cup�rer le stand cuisson
	 * @return standcuisson
	 */
	public StandCuisson getStandCuisson() {
		return standcuisson;
	}

	
	/**
	 * Permet de r�cup�rer dans un tableau tous les clients d�clar�s
	 * 
	 * @return la liste des clients
	 */
	@Override
	public Clients[] getClients() {
		return this.clients;
	}

	
	/**
	 * Permet de r�cup�rer le client dont l'id est clientId
	 * 
	 * @param clientId		Id du client que l'on veut r�cup�r�
	 */
	@Override
	public Clients getClient(int clientId) {

		if (clients.length >= clientId && clientId > 0)
			return clients[clientId - 1];

		return null;
	}
	
	public BuffetLegumes getLegumes() {
		return legumes;
	}

	public BuffetViande getViandes() {
		return viandes;
	}

	public BuffetNouilles getNouilles() {
		return nouilles;
	}

	public BuffetPoisson getPoissons() {
		return poissons;
	}

}
