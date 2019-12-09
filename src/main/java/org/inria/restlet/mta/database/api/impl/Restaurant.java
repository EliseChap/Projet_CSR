package org.inria.restlet.mta.database.api.impl;

import java.util.Collection;
import java.util.HashSet;

import org.inria.restlet.mta.backend.Clients;
import org.inria.restlet.mta.backend.Cuisinier;
import org.inria.restlet.mta.backend.EmployeBuffet;
import org.inria.restlet.mta.backend.StandCuisson;
import org.inria.restlet.mta.database.api.Database;

public class Restaurant implements Database {

	private final static int nbClientsTotal = 50;
	private final static int sizeMax = 25;
	private int nbClients = 0;
	private int affichageClient = 0;
	private EmployeBuffet employebuffet = new EmployeBuffet();
	private Cuisinier cuisinier;
	private Clients[] clients;
	private StandCuisson standcuisson;

	public Restaurant() {
		super();
		this.employebuffet = new EmployeBuffet();
		this.standcuisson = new StandCuisson(this);
		this.cuisinier = new Cuisinier(this);
		clients = new Clients[this.nbClientsTotal];

		for (int i = 0; i < nbClientsTotal; i++) {
			clients[i] = new Clients(this);
			clients[i].setId(i + 1);
			System.out.println("Le client" + clients[i].getId() + " est crée");
		}
	}

	public synchronized void debut() {

		employebuffet.start();
		cuisinier.start();

		for (Clients client : clients) {

			while (nbClients >= sizeMax) {
				System.out.println("Je suis ici");
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

	public synchronized void clientSort() {
		nbClients--;
		notifyAll();
	}

	public StandCuisson getStandCuisson() {
		return standcuisson;
	}

	@Override
	public Clients[] getClients() {
		return this.clients;
	}

	@Override
	public Clients getClient(int clientId) {

		if (clients.length >= clientId && clientId > 0)
			return clients[clientId - 1];

		return null;
	}
}
